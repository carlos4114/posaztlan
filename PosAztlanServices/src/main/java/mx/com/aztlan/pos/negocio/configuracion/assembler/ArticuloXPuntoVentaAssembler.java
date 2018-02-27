package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVentaId;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticulosXPuntoVentaVO;



public class ArticuloXPuntoVentaAssembler {

	public static ArticulosXPuntoVenta getArticuloXPuntoVenta(ArticulosXPuntoVentaVO articulosXPuntoVentaVO){
		
		if(articulosXPuntoVentaVO==null)
			return null;
		
		ArticulosXPuntoVenta articulosXPuntoVenta = new ArticulosXPuntoVenta();
		articulosXPuntoVenta.setId(new ArticulosXPuntoVentaId(articulosXPuntoVentaVO.getPuntoVenta().getIdPuntoVenta(),articulosXPuntoVentaVO.getArticulo().getIdArticulo()));
		articulosXPuntoVenta.setArticulo(articulosXPuntoVentaVO.getArticulo());
		articulosXPuntoVenta.setPuntoVenta(articulosXPuntoVentaVO.getPuntoVenta());
		
		return articulosXPuntoVenta;
	}
	

	public static ArticulosXPuntoVentaVO getArticuloXPuntoVentaVO (ArticulosXPuntoVenta articuloXPuntoVenta) {
		if(articuloXPuntoVenta == null )
			return null;
		
		ArticulosXPuntoVentaVO articulosXPuntoVentaVO= new ArticulosXPuntoVentaVO();
		articulosXPuntoVentaVO.setId(new ArticulosXPuntoVentaId(articuloXPuntoVenta.getPuntoVenta().getIdPuntoVenta(), articuloXPuntoVenta.getArticulo().getIdArticulo()));
		articulosXPuntoVentaVO.setArticulo(articuloXPuntoVenta.getArticulo());
		articulosXPuntoVentaVO.setPuntoVenta(articuloXPuntoVenta.getPuntoVenta());
		
		return articulosXPuntoVentaVO;
	}
	
	public static List<ArticulosXPuntoVentaVO> getArticulosXPuntosVentaVO(List<ArticulosXPuntoVenta> articulosXPuntoVenta){

		if(articulosXPuntoVenta==null || articulosXPuntoVenta.isEmpty())
			return null;
		
		List<ArticulosXPuntoVentaVO> articulosXPuntoVentaVO = new ArrayList<ArticulosXPuntoVentaVO>();
		
		for (ArticulosXPuntoVenta articuloXPuntoVenta : articulosXPuntoVenta) {
			articulosXPuntoVentaVO.add(ArticuloXPuntoVentaAssembler.getArticuloXPuntoVentaVO(articuloXPuntoVenta));
		}

		return articulosXPuntoVentaVO;
	}

}
