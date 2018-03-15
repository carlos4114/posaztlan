package mx.com.aztlan.pos.negocio.administracion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusOrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalleId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

public class OrdenCompraAssembler {


	public static OrdenCompra getOrdenCompra(OrdenCompraVO ordenCompraVO, Integer idUsuario, Integer folio){
		OrdenCompra ordenCompra = new OrdenCompra();
		
		ordenCompra.setIdOrdenCompra(ordenCompra.getIdOrdenCompra());
		ordenCompra.setEmpresa(new Empresa(ordenCompraVO.getIdEmpresa()));
		ordenCompra.setFolio(folio);
		ordenCompra.setIdProveedor(ordenCompraVO.getIdProveedor());
		ordenCompra.setDescuento(ordenCompraVO.getDescuento()==null?new BigDecimal(0):ordenCompraVO.getDescuento());
		ordenCompra.setEstatusOrdenCompra(new EstatusOrdenCompra(ordenCompraVO.getIdEstatusOrdenCompra()));
		ordenCompra.setFechaHora(FechasUtilsBO.getCurrentDate());
		ordenCompra.setUsuarioCreador(new Usuario(idUsuario));
	
		return ordenCompra;
	}
	
	public static OrdenCompraDetalle getOrdenCompraDetalle(OrdenCompra ordenCompra, ProductoVO productoVO){
		OrdenCompraDetalle ordenCompraDetalle = new OrdenCompraDetalle();
		
		ordenCompraDetalle.setId(new OrdenCompraDetalleId(ordenCompra.getIdOrdenCompra(), productoVO.getIdProducto()));
		ordenCompraDetalle.setCantidad(productoVO.getCantidad());
		ordenCompraDetalle.setPrecioUnitario(productoVO.getPrecioUnitario());
		
		return ordenCompraDetalle;
	}
	
	public static ProductoVO getProductoVO(Producto producto, BigDecimal precio){
		if(producto==null)
			return null;
		
		ProductoVO productoVO = new ProductoVO();
		
		productoVO.setIdProducto(producto.getIdProducto());
		productoVO.setNombre(producto.getNombre());
		productoVO.setDescripcion(producto.getDescripcion());
		productoVO.setIdFamilia(producto.getFamilia().getIdFamilia());
		productoVO.setNombreFamilia(producto.getFamilia().getNombre());
		productoVO.setIdMarca(producto.getMarca().getIdMarca());
		productoVO.setNombreMarca(producto.getMarca().getNombre());
		productoVO.setIdTipoProducto(producto.getTipoProducto().getIdTipoProducto());
		productoVO.setNombreTipo(producto.getTipoProducto().getNombre());
		productoVO.setIdMedida(producto.getMedida().getIdMedida());
		productoVO.setNombreMedida(producto.getMedida().getNombre());
		productoVO.setIdUnidadMedida(producto.getUnidadMedida().getIdUnidadMedida());
		productoVO.setNombreUnidadMedida(producto.getUnidadMedida().getNombre());
		productoVO.setDescripcion(producto.getDescripcion());
		productoVO.setPrecioUnitario(precio==null?null:precio);
		
		return productoVO;
	}
	
	public static List<ProductoVO> getProductosVO(List<Producto> productos){

		if(productos==null)
			return null;
		
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		
		for (Producto producto : productos) {
			productosVO.add(OrdenCompraAssembler.getProductoVO(producto, null));
		}

		return productosVO;
	}
}
