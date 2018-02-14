package mx.com.aztlan.pos.negocio.taquilla.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionPara;
import mx.com.aztlan.pos.negocio.taquilla.vo.PromocionParaVO;

public class PromocionParaAssembler {

	public static PromocionParaVO getPromocionPara(PromocionPara promocionPara){

		if(promocionPara==null)
			return null;
		
		PromocionParaVO promocionParaVO = new PromocionParaVO();
		promocionParaVO.setIdPromocionPara(promocionPara.getIdPromocionPara());
		promocionParaVO.setNombre(promocionPara.getNombre());
		promocionParaVO.setClave(promocionPara.getClave());
		
		return promocionParaVO;
	}
	
}
