package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.ProductoVO;

public class ProductoAssembler {

	public static ProductoVO getProductoVO(Producto producto){

		if(producto==null )
			return null;
		
		ProductoVO productoVO = new ProductoVO();
		productoVO.setIdProducto(producto.getIdProducto());
		productoVO.setCineVO(CineAssembler.getCineVO(producto.getCine()));
		productoVO.setNombre(producto.getNombre());
		productoVO.setIcono(producto.getIcono());
		productoVO.setActivo(producto.isActivo());
		productoVO.setArticulosXProductosVO(ArticuloXProductosAssembler.getArticulosXProductoVO(producto.getArticulosXProductos()));
		
		return productoVO;
	}
	
	public static List<ProductoVO> getProductosVO(Set<Producto> productos){

		if(productos==null || productos.isEmpty())
			return null;
		
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		
		for (Producto producto : productos) {
			productosVO.add(ProductoAssembler.getProductoVO(producto));
		}

		return productosVO;
	}
	
	
	public static Producto getProducto(Integer idProducto){

		if(idProducto==null )
			return null;
		
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);

		return producto;
	}
	
}
