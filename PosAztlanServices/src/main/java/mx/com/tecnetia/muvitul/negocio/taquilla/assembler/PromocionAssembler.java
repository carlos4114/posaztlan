package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Promocion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;

public class PromocionAssembler {
	
	public static PromocionVO getPromocionVO(Promocion promocion){

		if(promocion==null )
			return null;
		
		PromocionVO promocionVO = new PromocionVO();
		promocionVO.setIdPromocion(promocion.getIdPromocion());
		promocionVO.setCineVO(CineAssembler.getCineVO(promocion.getCine()));
		promocionVO.setPromocionParaVO(PromocionParaAssembler.getPromocionPara(promocion.getPromocionPara()));
		promocionVO.setTipoPromocionVO(TipoPromocionAssembler.getTipoPromocion(promocion.getTipoPromocion()));
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
	
	public static Promocion getPromocion(Integer idPromocion){

		if(idPromocion==null )
			return null;
		
		Promocion promocion = new Promocion();
		promocion.setIdPromocion(idPromocion);

		return promocion;
	}
	
	
}
