package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;

public class ArticuloAssembler {

	public static ArticuloVO getArticuloVO(ArticulosXPuntoVenta articuloXPuntoVenta){
		
		if(articuloXPuntoVenta==null)
			return null;
		
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setIdArticulo(articuloXPuntoVenta.getArticulo().getIdArticulo());
		articuloVO.setCineVO(CineAssembler.getCineVO(articuloXPuntoVenta.getArticulo().getCine()));
		articuloVO.setClasificacionArtVO(ClasificacionArtAssembler.getClasificacionArtVO(articuloXPuntoVenta.getArticulo().getClasificacionArt()));
		articuloVO.setUnidadMedidaVO(UnidadMedidaAssembler.getUnidadMedidaVO(articuloXPuntoVenta.getArticulo().getUnidadMedida()));
		articuloVO.setNombre(articuloXPuntoVenta.getArticulo().getNombre());
		articuloVO.setActivo(articuloXPuntoVenta.getArticulo().isActivo());
		articuloVO.setPuntoReorden(articuloXPuntoVenta.getArticulo().getPuntoReorden());
		
		return articuloVO;
	}
	

	
	public static List<ArticuloVO> getArticulosVO(List<ArticulosXPuntoVenta> articulosXPuntoVenta){
		
		if(articulosXPuntoVenta==null || articulosXPuntoVenta.isEmpty())
			return null;
		
		List<ArticuloVO> articulosVO = new ArrayList<ArticuloVO>();
		
		for (ArticulosXPuntoVenta articuloXPuntoVenta : articulosXPuntoVenta) {
			articulosVO.add(ArticuloAssembler.getArticuloVO(articuloXPuntoVenta));
		}

		return articulosVO;
		
	}

	
}
