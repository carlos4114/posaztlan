package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.SalaVO;

public class SalaAssembler {

	
	public static SalaVO getSalaVO(Sala sala){

		if(sala==null)
			return null;
		
		SalaVO salaVO = new SalaVO();
		salaVO.setIdSala(sala.getIdSala());
		salaVO.setCineVO(CineAssembler.getCineVO(sala.getCine()));
		salaVO.setNombre(sala.getNombre());
		salaVO.setActivo(sala.isActivo());
		return salaVO;
	}
	
}
