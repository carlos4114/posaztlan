package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.configuracion.business.ProductoBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;
import mx.com.aztlan.pos.negocio.inventarios.business.InventarioBO;


@Service
public class ProductoController {
	
	@Autowired
	ProductoBO productoBO;	
	
	@Autowired
	InventarioBO inventarioBO;	
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(ProductoVO productoVO) throws BusinessGlobalException, Exception{
		if (productoVO == null) 
            throw new BusinessGlobalException("Error al guardar el producto. El producto no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		String sku = productoBO.crearSku(productoVO);
		productoVO.setSku(sku);
		Producto producto = productoBO.guardarProducto(productoVO);
		
		productoBO.guardarPreciosXCanal(productoVO, producto);
		
		productoBO.guardarImpuestos(productoVO, producto);		
		
		return responseVO;
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(ProductoVO productoVO) throws BusinessGlobalException, Exception{
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		Producto producto =  productoBO.actualizar(productoVO);
		
		productoBO.actualizarPreciosXCanal(productoVO, producto);
		 
		productoBO.actualizarImpuestos(productoVO, producto);
			
		return responseVO;
	}
	
	@Transactional (readOnly=true)
	public List<ProductoExistenciaVO> getProductosExistencia(FiltrosVO filtrosVO) throws Exception{
		return this.inventarioBO.getProductosExistencia(filtrosVO);
	}

	
	@Transactional(readOnly = true)
	public List<ProductoVO> obtener(Integer idEmpresa)  throws BusinessGlobalException{
		return productoBO.findByEmpresa(idEmpresa);
	}
	
	@Transactional(readOnly = true)
	public UnidadMedidaVO consultaUnidadMedida(Integer idArticulo)  throws BusinessGlobalException{
		return productoBO.consultaUnidadMedida(idArticulo);
	}

	@Transactional(readOnly = true)
	public BigDecimal consultaPrecioUnitario(Integer idArticulo)  throws BusinessGlobalException, Exception{
		return productoBO.consultaPrecioUnitario(idArticulo);
	}
	
}
