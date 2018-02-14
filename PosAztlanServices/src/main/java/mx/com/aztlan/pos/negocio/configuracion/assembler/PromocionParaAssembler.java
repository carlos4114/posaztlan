package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionPara;
import mx.com.aztlan.pos.negocio.configuracion.vo.PromocionParaVO;


public class PromocionParaAssembler {

	public static PromocionParaVO getPromocionParaVO(PromocionPara promocionPara){

		if(promocionPara==null)
			return null;
		
		PromocionParaVO promocionParaVO = new PromocionParaVO();
		promocionParaVO.setIdPromocionPara(promocionPara.getIdPromocionPara());
		promocionParaVO.setNombre(promocionPara.getNombre());
		promocionParaVO.setClave(promocionPara.getClave());
		
		return promocionParaVO;
	}

	
	public static List<PromocionParaVO> getPromocionParaVO(List<PromocionPara> promocionesPara) {

		if (promocionesPara == null || promocionesPara.isEmpty())
			return null;

		List<PromocionParaVO> promocionesParaVO = new ArrayList<PromocionParaVO>();

		for (PromocionPara promocionPara : promocionesPara) {
			promocionesParaVO.add(PromocionParaAssembler.getPromocionParaVO(promocionPara));
		}

		return promocionesParaVO;
	}
	
	public static PromocionPara getPromocionPara(Integer idPromocionPara){

		if(idPromocionPara==null)
			return null;
		
		PromocionPara promocionPara = new PromocionPara();
		promocionPara.setIdPromocionPara(idPromocionPara);

		
		return promocionPara;
	}

	
	
}
