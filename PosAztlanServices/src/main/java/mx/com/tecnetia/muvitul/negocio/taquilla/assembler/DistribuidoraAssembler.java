package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Distribuidora;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DistribuidoraVO;

public class DistribuidoraAssembler {

	public static DistribuidoraVO getDistribuidoraVO(Distribuidora distribuidora){

		if(distribuidora==null )
			return null;

		DistribuidoraVO distribuidoraVO = new DistribuidoraVO();
		distribuidoraVO.setIdDistribuidora(distribuidora.getIdDistribuidora());
		distribuidoraVO.setNombre(distribuidora.getNombre());
		distribuidoraVO.setActivo(distribuidora.isActivo());
		

		return distribuidoraVO;
	}
	
	public static Distribuidora getDistribuidora(Integer idDistribuidora){
		
		if(idDistribuidora==null)
			return null;
		
		Distribuidora distribuidora = new Distribuidora();
		distribuidora.setIdDistribuidora(idDistribuidora);

		return distribuidora;
	}
}
