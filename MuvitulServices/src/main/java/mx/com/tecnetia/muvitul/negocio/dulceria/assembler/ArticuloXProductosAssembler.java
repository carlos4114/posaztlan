package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosXProducto;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArticuloXProductoVO;

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
