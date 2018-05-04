package mx.com.aztlan.pos.negocio.configuracion.business;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticuloDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticulosXProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestoXProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PrecioXCanalDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PropiedadConfigEmpresaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.SkuIbatisDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanal;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanalId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PropiedadConfigEmpresa;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.SecuenciaSkuEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ImpuestoXProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.assembler.UnidadMedidaAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.ImpuestoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PreciosXCanalVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;

@Service
@Transactional
public class ProductoBO {

	@Autowired
	ProductoDAOI productoDAO;		
	
	@Autowired 
	ArticulosXProductoDAOI articulosXProductoDAO;
	
	@Autowired 
	ProductoXPuntoVentaDAOI productoXPuntoVentaDAO;
	
	@Autowired
	ImpuestoXProductoDAOI impuestoXProductoDAO;
	
	@Autowired
	ArticuloDAOI articuloDAO;
	
	@Autowired
	InventarioDAOI inventarioDAO;
	
	@Autowired
	PrecioXCanalDAOI precioXCanalDAO;
	
	@Autowired
	PropiedadConfigEmpresaDAOI propiedadConfigEmpresaDAO;
	
	@Autowired
	SkuIbatisDAOI skuIbatisDAO;	
	
	@Transactional(readOnly = true)
	public List<ProductoVO> findByEmpresa(Integer idEmpresa) throws BusinessGlobalException  {
		 
		return ProductoAssembler.getProductos(productoDAO.findByEmpresa(idEmpresa));
		
	}
	
	/*@Transactional(readOnly = false)
	public HttpResponseVO ValidarProducto(ProductoVO productoVO) throws BusinessGlobalException, Exception{
		if (productoVO == null) 
            throw new BusinessGlobalException("Error al guardar producto. El producto no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		//validar que el producto no exista por nombre
		List<Producto> productos = this.productoDAO.findByName(productoVO.getCineVO().getIdCine(), productoVO.getNombre()); 
				
		if(productos.size() > 0){
	            	responseVO.setErrorCode(1);
	            	responseVO.setMessage("El producto ya existe.");
	
		}
		
		return responseVO;
	}
	*/
	
	@Transactional(readOnly = false)
	public String crearSku(ProductoVO productoVO) throws BusinessGlobalException, Exception{

		if (productoVO == null) 
            throw new BusinessGlobalException("Error al crear el SKU del producto. El producto no puede ser nulo.");
		StringBuffer sku = new StringBuffer("");
		
		PropiedadConfigEmpresa propiedadConfig = this.propiedadConfigEmpresaDAO.findById(productoVO.getIdEmpresa());
		StringTokenizer secuenciaSkuTk = new StringTokenizer(propiedadConfig.getSecuenciaCreacionSku(),"|");
		
		while(secuenciaSkuTk.hasMoreTokens()){
			String tk = secuenciaSkuTk.nextToken();
			String sigSecuencia = "";
			switch (tk){
			case SecuenciaSkuEnum.EMPRESA: 
				sigSecuencia = productoVO.getIdEmpresa().toString();
				break;
			case SecuenciaSkuEnum.FAMILIA: 
				sigSecuencia = productoVO.getIdFamilia().toString();
				break;
			case SecuenciaSkuEnum.MARCA: 
				sigSecuencia = productoVO.getIdMarca().toString();
				break;
			case SecuenciaSkuEnum.MEDIDA: 
				sigSecuencia = productoVO.getIdMedida().toString();
				break;
			case SecuenciaSkuEnum.TIPO_PRODUCTO: 
				sigSecuencia = productoVO.getIdTipoProducto().toString();
				break;			
			}
			sku.append(new String("000"+sigSecuencia).substring((sigSecuencia.length()+3)-3)); 
		}
		
		Integer ultimoFolio = this.skuIbatisDAO.getUltimoFolio(sku.toString(), productoVO.getIdEmpresa());
		String siguienteFolio = ultimoFolio == null ? "1" : Integer.toString(ultimoFolio+1);
		sku.append(new String("000"+siguienteFolio).substring((siguienteFolio.length()+3)-3)); 
		
		return sku.toString();
		
	}
	
	
	@Transactional(readOnly = false)
	public Producto guardarProducto(ProductoVO productoVO) throws BusinessGlobalException, Exception{

		if (productoVO == null) 
            throw new BusinessGlobalException("Error al guardar producto. El producto no puede ser nulo.");
		
		
		Producto producto = ProductoAssembler.getProducto(productoVO);
		producto = productoDAO.save(producto);

		return producto;
		
	}
		
	@Transactional(readOnly = false)
	public void guardarPreciosXCanal(ProductoVO productoVO, Producto producto) throws BusinessGlobalException, Exception{
		
		for(PreciosXCanalVO precioXCanal: productoVO.getPreciosXCanalList()) {
			PrecioXCanal precioC = new PrecioXCanal(
					new PrecioXCanalId(precioXCanal.getIdCanal(), producto.getIdProducto()),
					producto, new Canal(precioXCanal.getIdCanal()), precioXCanal.getPrecio());
			
			precioXCanalDAO.save(precioC);
		}
		
	}
	
	@Transactional(readOnly = false)
	public void guardarImpuestos(ProductoVO productoVO, Producto producto) throws BusinessGlobalException, Exception{
		
		ImpuestoXProducto impuestoXProducto;
		
		for(ImpuestoVO impuestoVO : productoVO.getImpuestosList()){
			impuestoXProducto  = ImpuestoXProductoAssembler.getImpuestoXProducto(impuestoVO, producto);
			impuestoXProductoDAO.save(impuestoXProducto);
		}

	}

	@Transactional(readOnly = false)
	public Producto actualizar(ProductoVO productoVO) throws BusinessGlobalException, Exception{
		if (productoVO == null) 
            throw new BusinessGlobalException("Error al guardar producto. El producto no puede ser nulo.");
		
		Producto producto = productoDAO.findByIdProducto(productoVO.getIdProducto()).get(0);
		producto = ProductoAssembler.getProducto(productoVO, producto);
		producto = productoDAO.update(producto);
		
		return producto;
	}

	
	@Transactional(readOnly = false)
	public void actualizarPreciosXCanal(ProductoVO productoVO, Producto producto) throws BusinessGlobalException, Exception{

		this.precioXCanalDAO.delete(productoVO.getIdProducto());
		
		for(PreciosXCanalVO preciosXCanalVO: productoVO.getPreciosXCanalList()){
			precioXCanalDAO.save(new PrecioXCanal(
					new PrecioXCanalId(preciosXCanalVO.getIdCanal(), producto.getIdProducto()),
					producto, new Canal(preciosXCanalVO.getIdCanal()), preciosXCanalVO.getPrecio()));
		}
	}
	
	@Transactional(readOnly = false)
	public void actualizarImpuestos(ProductoVO productoVO, Producto producto) throws BusinessGlobalException, Exception{
		
		List<ImpuestoXProducto> impuestos = impuestoXProductoDAO.findByIdProducto(productoVO.getIdProducto());
		
		ImpuestoXProducto impuestoXProducto;
		
		for(ImpuestoXProducto impuesto : impuestos){
			impuesto.setActivo(false);
			impuestoXProductoDAO.update(impuesto);
		}
		
		for(ImpuestoVO impuestoVO : productoVO.getImpuestosList()){
			for(ImpuestoXProducto impuesto : impuestos){
				if(impuestoVO.getNombre().equals(impuesto.getNombre())){
					if(impuestoVO.getPorcentaje().doubleValue() == impuesto.getPorcentaje().doubleValue()){
						
							impuesto.setActivo(true);
							impuestoXProductoDAO.update(impuesto);
							
					}else{
						impuestoXProducto  = ImpuestoXProductoAssembler.getImpuestoXProducto(impuestoVO, producto);
						impuestoXProductoDAO.save(impuestoXProducto);
					}
					
				}
				else{
					impuestoXProducto  = ImpuestoXProductoAssembler.getImpuestoXProducto(impuestoVO, producto);
					impuestoXProductoDAO.save(impuestoXProducto);
				}
			}
			
		}
		
	}
	
	@Transactional(readOnly = true)
	public BigDecimal consultaPrecioUnitario(Integer idArticulo) throws BusinessGlobalException, Exception{
		return inventarioDAO.getPrecioUnitario(idArticulo);
	}
	
	@Transactional(readOnly = false)
	public UnidadMedidaVO consultaUnidadMedida(Integer idArticulo) throws BusinessGlobalException  {
		
		List<Articulo> articulo = articuloDAO.findByIdArticulo(idArticulo);
		
		return UnidadMedidaAssembler.getUnidadMedidaVO(articulo.get(0).getUnidadMedida());
	}
	
}
