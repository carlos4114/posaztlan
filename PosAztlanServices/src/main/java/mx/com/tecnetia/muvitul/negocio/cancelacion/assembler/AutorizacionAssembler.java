package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Autorizacion;

public class AutorizacionAssembler {
	
	public static Autorizacion getAutorizacion(Integer idAutorizacion){
		
		if(idAutorizacion ==null  )
			return null;
		
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setIdAutorizacion(idAutorizacion);
		
		return autorizacion;
		
	}
	
}
