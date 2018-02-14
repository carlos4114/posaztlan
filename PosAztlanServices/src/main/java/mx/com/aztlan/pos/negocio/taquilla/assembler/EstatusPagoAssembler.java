package mx.com.aztlan.pos.negocio.taquilla.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;

public class EstatusPagoAssembler {

	public static EstatusPago getEstatusPago(Integer idEstatus){

		if(idEstatus==null )
			return null;

		EstatusPago estatusPago= new EstatusPago();
		estatusPago.setIdEstatus(idEstatus);
		
		return estatusPago;
	}
	
}
