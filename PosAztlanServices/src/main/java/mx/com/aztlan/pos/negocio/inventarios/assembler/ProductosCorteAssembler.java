package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosCorte;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.ArticuloAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.PuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProductosCorteVO;

public class ProductosCorteAssembler {

	public static ProductosCorte getProductosCorte(Integer idProductoCorte){

		if(idProductoCorte==null )
			return null;

		ProductosCorte productosCorte= new ProductosCorte();
		productosCorte.setIdProductoCorte(idProductoCorte);
		
		return productosCorte;
	}
	
	public static ProductosCorte getProductosCorte(ProductosCorteVO productosCorteVO){

		if(productosCorteVO==null )
			return null;

		ProductosCorte productosCorte= new ProductosCorte();
		productosCorte.setIdProductoCorte(productosCorteVO.getIdProductoCorte());
		productosCorte.setProducto(ProductoAssembler.getProducto(productosCorteVO.getProducto().getIdProducto()));
		productosCorte.setUsuario(UsuarioAssembler.getUsuario(productosCorteVO.getUsuario().getIdUsuario()));
		productosCorte.setExistenciaFisica(productosCorteVO.getExistenciaFisica());
		productosCorte.setExistenciaSistema(productosCorteVO.getExistenciaSistema());
		productosCorte.setEstatusConteo(productosCorteVO.getEstatusConteo());
		productosCorte.setFecha(productosCorteVO.getFecha());
		productosCorte.setUltimaModificacion(productosCorteVO.getUltimaModificacion());
		productosCorte.setUsuarioModificacion(UsuarioAssembler.getUsuario(productosCorteVO.getUsuario().getIdUsuario()));
		productosCorte.setAlmacen(AlmacenAssembler.getAlmacen(productosCorteVO.getAlmacen().getIdAlmacen()));
		
		return productosCorte;
	}
	
	public static ProductosCorteVO getProductosCorteVO(ProductosCorte productosCorte) {
		if(productosCorte == null )
			return null;
		
		ProductosCorteVO productosCorteVO = new ProductosCorteVO();
		
		productosCorteVO.setIdProductoCorte(productosCorte.getIdProductoCorte());
		productosCorteVO.setProducto(ProductoAssembler.getProductoVO(productosCorte.getProducto()));
		productosCorteVO.setUsuario(UsuarioAssembler.getUsuarioVO(productosCorte.getUsuario().getIdUsuario()));
		productosCorteVO.setExistenciaFisica(productosCorte.getExistenciaFisica());
		productosCorteVO.setExistenciaSistema(productosCorte.getExistenciaSistema());
		productosCorteVO.setEstatusConteo(productosCorte.getEstatusConteo());
		productosCorteVO.setFecha(productosCorte.getFecha());
		productosCorteVO.setUltimaModificacion(productosCorte.getUltimaModificacion());
		productosCorteVO.setUsuarioModificacion(UsuarioAssembler.getUsuarioVO(productosCorteVO.getUsuario().getIdUsuario()));
		productosCorteVO.setAlmacen(AlmacenAssembler.getAlmacenVO(productosCorte.getAlmacen()));
		
		return productosCorteVO;
	}
	
	public static List<ProductosCorteVO> getProductosCorteVO(List<ProductosCorte> productosCortes){

		if(productosCortes==null || productosCortes.isEmpty())
			return null;
		
		List<ProductosCorteVO> productosCorteVO = new ArrayList<ProductosCorteVO>();
		
		for (ProductosCorte productosCorte : productosCortes) {
			productosCorteVO.add(ProductosCorteAssembler.getProductosCorteVO(productosCorte));
		}

		return productosCorteVO;
	}	

}
