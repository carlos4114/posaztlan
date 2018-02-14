package mx.com.aztlan.pos.negocio.cancelacion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;

public class AutorizacionAssembler {
	
	public static Autorizacion getAutorizacion(Integer idAutorizacion){
		
		if(idAutorizacion ==null  )
			return null;
		
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setIdAutorizacion(idAutorizacion);
		
		return autorizacion;
		
	}
	
}
