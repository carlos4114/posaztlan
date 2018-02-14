package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArticuloXProductoVO;

public class ArticuloXProductosAssembler {

	public static ArticuloXProductoVO getArticuloXProductoVO(ArticulosXProducto articuloXProducto){

		if(articuloXProducto==null )
			return null;
		
		ArticuloXProductoVO  articuloXProductoVO = new ArticuloXProductoVO();
		articuloXProductoVO.setId(articuloXProducto.getId());
		articuloXProductoVO.setArticuloVO(ArticuloAssembler.getArticuloVO(articuloXProducto.getArticulo()));
		articuloXProductoVO.setCantidad(articuloXProducto.getCantidad());

		return articuloXProductoVO;
	}
	
	public static List<ArticuloXProductoVO> getArticulosXProductoVO(Set<ArticulosXProducto> articulosXProducto){

		if(articulosXProducto==null || articulosXProducto.isEmpty())
			return null;
		
		List<ArticuloXProductoVO> articuloXProductoVO = new ArrayList<ArticuloXProductoVO>();
		
		for (ArticulosXProducto articuloXProducto : articulosXProducto) {
			articuloXProductoVO.add(ArticuloXProductosAssembler.getArticuloXProductoVO(articuloXProducto));
		}
		
		return articuloXProductoVO;
	}
	
}
