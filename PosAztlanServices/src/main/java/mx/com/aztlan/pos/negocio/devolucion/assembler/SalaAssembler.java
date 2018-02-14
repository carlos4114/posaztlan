package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Sala;
import mx.com.aztlan.pos.negocio.devolucion.vo.SalaVO;

public class SalaAssembler {

	
	public static SalaVO getSalaVO(Sala sala){

		if(sala==null)
			return null;
		
		SalaVO salaVO = new SalaVO();
		salaVO.setIdSala(sala.getIdSala());
		//salaVO.setCineVO(CineAssembler.getCineVO(sala.getCine()));
		salaVO.setNombre(sala.getNombre());
		salaVO.setActivo(sala.isActivo());
		return salaVO;
	}
	
}
