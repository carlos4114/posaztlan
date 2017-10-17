package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Recurso;

public class RecursoAssembler {


	public static RecursoVO getRecursoVO(Recurso recurso) {

		if(recurso==null)
			return null;

		RecursoVO recursoVO =  new RecursoVO();

		recursoVO.setIdRecurso(recurso.getIdRecurso());
		recursoVO.setNombre(recurso.getNombre());
		recursoVO.setUrl(recurso.getRecursoUrl());
		recursoVO.setPermitirATodos(recurso.isPermitirATodos());
		
		return recursoVO;
	}

}
