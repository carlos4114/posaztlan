package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Promocion;
import mx.com.aztlan.pos.negocio.configuracion.vo.PromocionVO;

public class PromocionAssembler {

	
	public static Promocion getPromocion(PromocionVO promocionVO){

		if(promocionVO==null )
			return null;
		
		Promocion promocion = new Promocion();
		promocion.setCine(CineAssembler.getCine(promocionVO.getCineVO().getIdCine()));
		promocion.setPromocionPara(PromocionParaAssembler.getPromocionPara(promocionVO.getPromocionParaVO().getIdPromocionPara()));
		promocion.setTipoPromocion(TipoPromocionAssembler.getTipoPromocion(promocionVO.getTipoPromocionVO().getIdTipoPromocion()));
		promocion.setNombre(promocionVO.getNombre());
		promocion.setDescripcion(promocionVO.getDescripcion());
		promocion.setFechaInicio(promocionVO.getFechaInicio());
		promocion.setFechaFin(promocionVO.getFechaFin());
		promocion.setActivo(promocionVO.isActivo());
		promocion.setDetallePromocion(DetallePromocionAssembler.getDetallePromocion(promocionVO.getDetallePromocionVO()));
		//promocion.setDetallePromoXPromos(DetallePromocionAssembler.getDetallePromoXPromos(promocionVO.getDetallePromocionesVO()));
		
		return promocion;
	}
	
	
	public static PromocionVO getPromocionVO(Promocion promocion){

		if(promocion==null )
			return null;
		
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(promocion.getIdPromocion());
		promocionVO.setCineVO(CineAssembler.getCineVO(promocion.getCine()));
		promocionVO.setPromocionParaVO(PromocionParaAssembler.getPromocionParaVO(promocion.getPromocionPara()));
		promocionVO.setTipoPromocionVO(TipoPromocionAssembler.getTipoPromocionVO(promocion.getTipoPromocion()));
		promocionVO.setNombre(promocion.getNombre());
		promocionVO.setDescripcion(promocion.getDescripcion());
		promocionVO.setFechaInicio(promocion.getFechaInicio());
		promocionVO.setFechaFin(promocion.getFechaFin());
		promocionVO.setActivo(promocion.isActivo());
		promocionVO.setDetallePromocionVO(DetallePromocionAssembler.getDetallePromocionVO(promocion.getDetallePromocion()));
		
		return promocionVO;
	}
	
	
	public static List<PromocionVO> getPromocionesVO(List<Promocion> promociones){

		if(promociones==null || promociones.isEmpty())
			return null;
		
		List<PromocionVO> promocionesVO = new ArrayList<PromocionVO>();
		
		for (Promocion promocion : promociones) {
			promocionesVO.add(PromocionAssembler.getPromocionVO(promocion));
		}

		return promocionesVO;
	}
	
}
