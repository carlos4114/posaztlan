package mx.com.aztlan.pos.negocio.dulceria.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.negocio.dulceria.vo.CineVO;

public class CineAssembler {

	public static CineVO getCineVO(Cine cine){
		if(cine==null)
			return null;
		
		CineVO cineVO = new CineVO();
		cineVO.setIdCine(cine.getIdCine());
		cineVO.setNombre(cine.getNombre());
		cineVO.setActivo(cine.isActivo());
		
		return cineVO;
	}
	
}
