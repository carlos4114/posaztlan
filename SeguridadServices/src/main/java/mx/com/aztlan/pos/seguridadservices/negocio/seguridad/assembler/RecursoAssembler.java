package mx.com.aztlan.pos.seguridadservices.negocio.seguridad.assembler;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Recurso;

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
