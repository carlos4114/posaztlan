package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.tecnetia.muvitul.infraservices.negocio.muvitul.vo.CineVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;

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
