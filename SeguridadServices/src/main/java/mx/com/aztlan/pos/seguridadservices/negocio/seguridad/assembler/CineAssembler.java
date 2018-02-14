package mx.com.aztlan.pos.seguridadservices.negocio.seguridad.assembler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.aztlan.pos.infraservices.negocio.posaztlanbd.vo.CineVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;

public class CineAssembler {
	final static Log log = LogFactory.getLog(CineAssembler.class);

	public static CineVO getCineVO(Cine cine){

		if(cine==null)
			return null;
		
		CineVO cineVO = new CineVO();
		cineVO.setIdCine(cine.getIdCine());
		cineVO.setNombre(cine.getNombre());
		 
		return cineVO;
	}

 

}
