package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductosXPaqueteDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaqueteId;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PaqueteAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PaquetesXPuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.PuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaquetesXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductosAgregadosVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductosSeleccionadosVO;

@Service
@Transactional
public class PaqueteBO {
	
	@Autowired
	private ProductoDAOI productoDAO;

	@Autowired
	private PaqueteDAOI paqueteDAO;
	
	@Autowired
	PaqueteXPuntoVentaDAOI paqueteXPuntoVentaDAO;
	
	@Autowired
	ProductosXPaqueteDAOI productosXPaqueteDAO;
	
	public List<ProductoVO> findProductosByCine(Integer idCine) {
		return ProductoAssembler.getProductos(productoDAO.findByCine(idCine));
	}

	public List<PaqueteVO> findPaquetesByCine(Integer idCine) {
		return PaqueteAssembler.getPaquetes(paqueteDAO.findByCine(idCine));
	}
	
	public PaqueteVO save(PaqueteVO paqueteVO) {
		Paquete paquete = PaqueteAssembler.getPaquete(paqueteVO);
		return PaqueteAssembler.getPaqueteVO(paqueteDAO.save(paquete));
	}

	public void delete(Integer idPaquete) {
		Paquete paquete = paqueteDAO.findById(idPaquete);
		paquete.setActivo(false);
		paqueteDAO.update(paquete);
	}
	
	public Paquete guardarPaquete(PaqueteVO paqueteVO) {
		Paquete paquete = PaqueteAssembler.getPaquete(paqueteVO);
		paquete = paqueteDAO.save(paquete);

		return paquete;
	}

	@Transactional(readOnly = false)
	public List<PaqueteVO> obtener(Integer idCine) throws BusinessGlobalException{
		List<PaqueteVO> paquetes = PaqueteAssembler.getPaquetes(paqueteDAO.findByCine(idCine));
		
		for(PaqueteVO paqueteVO: paquetes){
			paqueteVO.setProductosSeleccionadosList(getProductosSeleccionados(paqueteVO.getIdPaquete()));
		}
		
		return paquetes;
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO ValidarPaquete(PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		if (paqueteVO == null) 
            throw new BusinessGlobalException("Error al guardar paquete. El paquete no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		//validar que el producto no exista por nombre
		List<Paquete> paquetes = this.paqueteDAO.findByName(paqueteVO.getNombre(),paqueteVO.getIdCine()); 
				
		if(paquetes.size() > 0){
	            	responseVO.setErrorCode(1);
	            	responseVO.setMessage("El producto ya existe.");
	
		}
		
		return responseVO;
	}
	
	@Transactional(readOnly = false)
	public void guardarProductosXPaquete(PaqueteVO paqueteVO, Paquete paquete) throws BusinessGlobalException, Exception{
		Integer indice = 0;
		
		for(ProductosSeleccionadosVO productosSeleccionados : paqueteVO.getProductosSeleccionadosList()){
			for (ProductosAgregadosVO productosAgregados : productosSeleccionados.getProductosAgregadosList()){
				
				productosXPaqueteDAO.save(new ProductosXPaquete(
						new ProductosXPaqueteId(
								paquete.getIdPaquete(), 
								productosAgregados.getIdProducto()),
								paquete, 
								new Producto(productosAgregados.getIdProducto()), 
								productosAgregados.getCantidad(), indice));
			}
			
			indice = indice +1;
		}
		
	}

	@Transactional(readOnly = false)
	public void guardarPaquetesXPuntoVenta(PaqueteVO paqueteVO, Paquete paquete) throws BusinessGlobalException, Exception{
		
		PaquetesXPuntoVentaVO paquetesXPuntoVentaVO = new PaquetesXPuntoVentaVO();
		PaquetesXPuntoVenta paquetesXPuntoVenta;
				
		for(Integer idPuntoVenta : paqueteVO.getPuntosVentaList()){
	
			paquetesXPuntoVentaVO.setPaquete(paquete);
			paquetesXPuntoVentaVO.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(idPuntoVenta));
			
			paquetesXPuntoVenta = PaquetesXPuntoVentaAssembler.getPaqueteXPuntoVenta(paquetesXPuntoVentaVO);
			
			paqueteXPuntoVentaDAO.save(paquetesXPuntoVenta);

		}
	}
	
	public List<ProductosSeleccionadosVO> getProductosSeleccionados(Integer idPaquete) {
		List<ProductosSeleccionadosVO> productosSeleccionados = new ArrayList<ProductosSeleccionadosVO>();
		List<ProductosAgregadosVO> productosAgregados= new ArrayList<ProductosAgregadosVO>();
		Integer indice = 0;
		long cantidad = 0;
		List<ProductosXPaquete> productosList = productosXPaqueteDAO.findByIdPaquete(idPaquete);
		
		
		for(ProductosXPaquete producto: productosList ){
			if(indice == producto.getIndice()){
				ProductosAgregadosVO productoAgregado = new ProductosAgregadosVO();
				productoAgregado.setIdProducto(producto.getProducto().getIdProducto());
				productoAgregado.setCantidad(producto.getCantidad());
				productoAgregado.setNombre(producto.getProducto().getNombre());				
				productosAgregados.add(productoAgregado);
			}
			else{
				ProductosSeleccionadosVO productoSeleccionado = new ProductosSeleccionadosVO();
				productoSeleccionado.setProductosAgregadosList(productosAgregados);
				productoSeleccionado.setCantidad(producto.getCantidad());
				productosSeleccionados.add(productoSeleccionado);
				productosAgregados = new ArrayList<ProductosAgregadosVO>();
				
				ProductosAgregadosVO productoAgregado = new ProductosAgregadosVO();
				productoAgregado.setIdProducto(producto.getProducto().getIdProducto());
				productoAgregado.setCantidad(producto.getCantidad());
				productoAgregado.setNombre(producto.getProducto().getNombre());				
				productosAgregados.add(productoAgregado);
				
				indice = indice +1;
				cantidad = producto.getCantidad();
			}		
		}
		
		ProductosSeleccionadosVO productoSeleccionado = new ProductosSeleccionadosVO();
		productoSeleccionado.setProductosAgregadosList(productosAgregados);
		productoSeleccionado.setCantidad(cantidad);
		productosSeleccionados.add(productoSeleccionado);
	
		return productosSeleccionados;
	}
	
	@Transactional(readOnly = false)
	public void actualizar(PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		
		Paquete paquete = paqueteDAO.findById(paqueteVO.getIdPaquete());
		paquete.setActivo(false);
		paqueteDAO.update(paquete);
		
	}
}