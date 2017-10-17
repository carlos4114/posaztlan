package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Distribuidora;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.DistribuidoraVO;

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
	
}
