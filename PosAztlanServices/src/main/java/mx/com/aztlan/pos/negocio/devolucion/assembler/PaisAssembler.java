package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pais;
import mx.com.aztlan.pos.negocio.devolucion.vo.PaisVO;

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
