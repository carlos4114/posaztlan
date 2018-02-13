package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoAutorizacion;

public class TipoAutorizacionAssembler {
	
	public static TipoAutorizacion getTipoAutorizacion(Integer idTipoAutorizacion){

		if(idTipoAutorizacion==null)
			return null;
		
		TipoAutorizacion tipoAutorizacion = new TipoAutorizacion();
		tipoAutorizacion.setIdTipoAutorizacion(idTipoAutorizacion);

		return tipoAutorizacion;
	}

	
}
