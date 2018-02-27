package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProductoId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticulosXProductoVO;


public class ArticulosXProductoAssembler {

	public static ArticulosXProducto getArticuloXProducto(ArticulosXProductoVO articulosXProductoVO, Producto producto){
		
		if(articulosXProductoVO==null)
			return null;
		
		ArticulosXProducto articulosXProducto = new ArticulosXProducto();
		articulosXProducto.setId(new ArticulosXProductoId(producto.getIdProducto(), articulosXProductoVO.getIdArticulo()));
		articulosXProducto.setArticulo(new Articulo(articulosXProductoVO.getIdArticulo()));
		articulosXProducto.setProducto(new Producto(producto.getIdProducto()));
		articulosXProducto.setCantidad(articulosXProductoVO.getCantidad());
		
		return articulosXProducto;
	}

}
