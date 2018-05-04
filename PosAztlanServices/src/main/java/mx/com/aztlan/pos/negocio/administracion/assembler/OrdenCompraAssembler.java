package mx.com.aztlan.pos.negocio.administracion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusOrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalleId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ImpuestoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

public class OrdenCompraAssembler {


	public static OrdenCompra getOrdenCompra(OrdenCompraVO ordenCompraVO, Integer idUsuario, Integer folio){
		OrdenCompra ordenCompra = new OrdenCompra();
		
		ordenCompra.setIdOrdenCompra(ordenCompraVO.getIdOrdenCompra());
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
		ordenCompraDetalle.setEstatusOrdenCompra(ordenCompra.getEstatusOrdenCompra());
		ordenCompraDetalle.setCantidadRestante(productoVO.getCantidad());
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
	
	public static OrdenCompraVO getOrdenCompraVO(OrdenCompra ordenCompra, List<OrdenCompraDetalle> detalle){
		if(ordenCompra==null)
			return null;
		
		OrdenCompraVO ordenCompraVO = new OrdenCompraVO();
		
		ordenCompraVO.setIdEmpresa(ordenCompra.getEmpresa().getIdEmpresa());
		ordenCompraVO.setIdOrdenCompra(ordenCompra.getIdOrdenCompra());
		ordenCompraVO.setDescuento(ordenCompra.getDescuento());
		ordenCompraVO.setIdEstatusOrdenCompra(ordenCompra.getEstatusOrdenCompra().getIdEstatusOrdenCompra());
		ordenCompraVO.setNombreEstatusOrdenCompra(ordenCompra.getEstatusOrdenCompra().getNombre());
		ordenCompraVO.setIdProveedor(ordenCompra.getIdProveedor());
		//ordenCompraVO.setNombreProveedor(ordenCompra.getProveedor().getNombre());
		ordenCompraVO.setProductos(getProductos(detalle));
		
	
		return ordenCompraVO;
	}
	
	public static List<ProductoVO> getProductos(List<OrdenCompraDetalle> ordenCompraDetalle) {
		List<ProductoVO> productos = new ArrayList<ProductoVO>();
		
		for(OrdenCompraDetalle producto : ordenCompraDetalle) {
			ProductoVO productoVO = new ProductoVO();
			productoVO.setIdProducto(producto.getId().getIdProducto());
			productoVO.setNombre(producto.getProducto().getNombre());
			productoVO.setNombreFamilia(producto.getProducto().getFamilia().getNombre());
			productoVO.setNombreMarca(producto.getProducto().getMarca().getNombre());
			productoVO.setNombreMedida(producto.getProducto().getMedida().getNombre());
			productoVO.setNombreTipo(producto.getProducto().getTipoProducto().getNombre());
			productoVO.setNombreUnidadMedida(producto.getProducto().getUnidadMedida().getNombre());
			productoVO.setDescripcion(producto.getProducto().getDescripcion());
			productoVO.setCantidad(producto.getCantidad());
			productoVO.setPrecioUnitario(producto.getPrecioUnitario());
			//productoVO.setCantidadFinal(producto.getCantidadFinal());
			productoVO.setPrecioUnitarioFinal(producto.getPrecioUnitarioFinal());
			productoVO.setNombreEstatus(producto.getEstatusOrdenCompra().getNombre());
			productoVO.setCantidadRestante(producto.getCantidadRestante());
			productos.add(productoVO);
		}
		
		return productos;
	}
}
