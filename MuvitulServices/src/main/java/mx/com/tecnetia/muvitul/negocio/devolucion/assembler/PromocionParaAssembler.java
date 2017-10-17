package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionPara;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.PromocionParaVO;


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
