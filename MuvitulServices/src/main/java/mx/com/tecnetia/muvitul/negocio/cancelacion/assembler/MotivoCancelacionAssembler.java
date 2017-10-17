package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MotivoCancelacion;

public class MotivoCancelacionAssembler {
	
	public static MotivoCancelacion getMotivoCancelacion(Integer idMotivoCancelacion){

		if(idMotivoCancelacion==null )
			return null;
		
		MotivoCancelacion motivoCancelacion = new MotivoCancelacion();
		motivoCancelacion.setIdMotivoCancelacion(idMotivoCancelacion);
		
		return motivoCancelacion;
	}
	
}
