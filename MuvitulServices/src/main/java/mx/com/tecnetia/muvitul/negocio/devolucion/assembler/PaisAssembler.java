package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pais;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.PaisVO;

public class PaisAssembler {

	public static PaisVO getPaisVO(Pais pais){

		if(pais==null )
			return null;

		PaisVO paisVO = new PaisVO();
		paisVO.setIdPais(pais.getIdPais());
		paisVO.setNombre(pais.getNombre());
		
		return paisVO;
	}
	
}
