package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacion;

public class TipoAutorizacionAssembler {
	
	public static TipoAutorizacion getTipoAutorizacion(Integer idTipoAutorizacion){

		if(idTipoAutorizacion==null)
			return null;
		
		TipoAutorizacion tipoAutorizacion = new TipoAutorizacion();
		tipoAutorizacion.setIdTipoAutorizacion(idTipoAutorizacion);

		return tipoAutorizacion;
	}

	
}
