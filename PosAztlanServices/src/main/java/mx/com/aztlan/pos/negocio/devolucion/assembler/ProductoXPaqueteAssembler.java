package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaquete;
import mx.com.aztlan.pos.negocio.devolucion.vo.ProductoXPaqueteVO;


public class ProductoXPaqueteAssembler {

	public static ProductoXPaqueteVO getProductoXPaqueteVO(ProductosXPaquete productoXPaquete){

		if(productoXPaquete==null )
			return null;
		
		ProductoXPaqueteVO  productoXPaqueteVO = new ProductoXPaqueteVO();
		productoXPaqueteVO.setId(productoXPaquete.getId());
		productoXPaqueteVO.setProductoVO(ProductoAssembler.getProductoVO(productoXPaquete.getProducto()));
		productoXPaqueteVO.setCantidad(productoXPaquete.getCantidad());

		return productoXPaqueteVO;
	}
	
	public static List<ProductoXPaqueteVO> getProductoXPaqueteVO(Set<ProductosXPaquete> productosXPaquete){

		if(productosXPaquete==null || productosXPaquete.isEmpty())
			return null;
		
		List<ProductoXPaqueteVO> productosXPaqueteVO = new ArrayList<ProductoXPaqueteVO>();
		
		for (ProductosXPaquete productoXPaquete : productosXPaquete) {
			productosXPaqueteVO.add(ProductoXPaqueteAssembler.getProductoXPaqueteVO(productoXPaquete));
		}
		
		return productosXPaqueteVO;
	}
	
	public static ProductoXPaqueteVO getProductoXPaqueteVO(Producto producto){
		
		if(producto==null)
			return null;
		
		ProductoXPaqueteVO productoXPaqueteVO = new ProductoXPaqueteVO();
		productoXPaqueteVO.setProductoVO(ProductoAssembler.getProductoVO(producto));
		productoXPaqueteVO.setCantidad(1);
		
		return productoXPaqueteVO;
	}
	
	
	public static List<ProductoXPaqueteVO> getProductosXPaqueteVO(Producto producto) {

		if (producto == null )
			return null;

		List<ProductoXPaqueteVO>  productosPaqueteVO = new ArrayList<ProductoXPaqueteVO>();
		productosPaqueteVO.add(ProductoXPaqueteAssembler.getProductoXPaqueteVO(producto));

		return productosPaqueteVO;
	}
}
