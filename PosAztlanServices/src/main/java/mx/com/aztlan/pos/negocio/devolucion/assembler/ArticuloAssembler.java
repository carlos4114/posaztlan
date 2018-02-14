package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArticuloVO;

public class ArticuloAssembler {

	public static ArticuloVO getArticuloVO(Articulo articulo){

		if(articulo==null )
			return null;
		
		ArticuloVO  articuloVO = new ArticuloVO();
		articuloVO.setIdArticulo(articulo.getIdArticulo());
		articuloVO.setCineVO(CineAssembler.getCineVO(articulo.getCine()));
		articuloVO.setClasificacionArtVO(ClasificacionArtAssembler.getClasificacionArtVO(articulo.getClasificacionArt()));
		articuloVO.setUnidadMedidaVO(UnidadMedidaAssembler.getUnidadMedidaVO(articulo.getUnidadMedida()));
		articuloVO.setNombre(articulo.getNombre());
		articuloVO.setActivo(articulo.isActivo());
		articuloVO.setPuntoReorden(articulo.getPuntoReorden());		

		return articuloVO;
	}
	

	public static Articulo getArticulo(Integer idArticulo){

		if(idArticulo==null )
			return null;
		
		Articulo  articulo = new Articulo();
		articulo.setIdArticulo(idArticulo);
	

		return articulo;
	}
	
	public static List<ArticuloVO> getArticulosVO(List<Articulo> articulos){

		if(articulos==null || articulos.isEmpty())
			return null;
		
		List<ArticuloVO> articulosVO = new ArrayList<ArticuloVO>();
		
		for (Articulo articulo : articulos) {
			articulosVO.add(ArticuloAssembler.getArticuloVO(articulo));
		}

		return articulosVO;
	}
	
}
