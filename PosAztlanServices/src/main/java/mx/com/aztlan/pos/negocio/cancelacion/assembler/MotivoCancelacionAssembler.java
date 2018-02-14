package mx.com.aztlan.pos.negocio.cancelacion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MotivoCancelacion;

public class MotivoCancelacionAssembler {
	
	public static MotivoCancelacion getMotivoCancelacion(Integer idMotivoCancelacion){

		if(idMotivoCancelacion==null )
			return null;
		
		MotivoCancelacion motivoCancelacion = new MotivoCancelacion();
		motivoCancelacion.setIdMotivoCancelacion(idMotivoCancelacion);
		
		return motivoCancelacion;
	}
	
}
