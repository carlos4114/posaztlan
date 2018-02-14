package mx.com.aztlan.pos.negocio.inventarios.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVentaId;
import mx.com.aztlan.pos.negocio.dulceria.assembler.ArticuloAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.PuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;

public class ArticulosXPuntoVentaAssembler {

	public static ArticulosXPuntoVenta getArticulosXPuntoVenta(Integer idArticulo,Integer idPuntoVenta){
				
		if(idArticulo == null || idPuntoVenta == null)
			return null;
		
		ArticulosXPuntoVenta articulosXPuntoVenta = new ArticulosXPuntoVenta();
		ArticulosXPuntoVentaId id = new  ArticulosXPuntoVentaId();
			id.setIdArticulo(idArticulo);
			id.setIdPuntoVenta(idPuntoVenta);
		articulosXPuntoVenta.setId(id);
		articulosXPuntoVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(idPuntoVenta));
		articulosXPuntoVenta.setArticulo(ArticuloAssembler.getArticulo(idArticulo));
		
		return articulosXPuntoVenta;
	}
	
	public static ArticulosXPuntoVenta getArticulosXPuntoVenta(ArticulosXPuntoVentaVO articulosXPuntoVentaVO){
		
		if(articulosXPuntoVentaVO == null)
			return null;
		
		ArticulosXPuntoVenta articulosXPuntoVenta = new ArticulosXPuntoVenta();
		ArticulosXPuntoVentaId id = new  ArticulosXPuntoVentaId();
			id.setIdArticulo(articulosXPuntoVentaVO.getArticulo().getIdArticulo());
			id.setIdPuntoVenta(articulosXPuntoVentaVO.getPuntoVenta().getIdPuntoVenta());
		articulosXPuntoVenta.setId(id);
		articulosXPuntoVenta.setPuntoVenta(PuntoVentaAssembler.getPuntoVenta(articulosXPuntoVentaVO.getPuntoVenta().getIdPuntoVenta()));
		articulosXPuntoVenta.setArticulo(ArticuloAssembler.getArticulo(articulosXPuntoVentaVO.getArticulo().getIdArticulo()));
		
		return articulosXPuntoVenta;
	}
	
	public static ArticulosXPuntoVentaVO getArticulosXPuntoVentaVO(ArticulosXPuntoVenta articulosXPuntoVenta){
		
		if(articulosXPuntoVenta == null)
			return null;
		
		ArticulosXPuntoVentaVO articulosXPuntoVentaVO = new ArticulosXPuntoVentaVO();
		
		articulosXPuntoVentaVO.setPuntoVenta(PuntoVentaAssembler.getPuntoVentaVO(articulosXPuntoVenta.getPuntoVenta()));
		articulosXPuntoVentaVO.setArticulo(ArticuloAssembler.getArticuloVO(articulosXPuntoVenta.getArticulo()));
		
		return articulosXPuntoVentaVO;
	}
	
	public static List<ArticulosXPuntoVentaVO> getArticulosXPuntoVentaVO(List<ArticulosXPuntoVenta> articulosXPuntoVenta){
	  if(articulosXPuntoVenta==null || articulosXPuntoVenta.isEmpty())
		return null;
	  
	  List<ArticulosXPuntoVentaVO> articulosXPuntoVentaVO = new  ArrayList<ArticulosXPuntoVentaVO>();
	  	for(ArticulosXPuntoVenta articulo : articulosXPuntoVenta){
	  		articulosXPuntoVentaVO.add(getArticulosXPuntoVentaVO(articulo));
	  	}
	  	
	  return articulosXPuntoVentaVO;
		
	}
}
