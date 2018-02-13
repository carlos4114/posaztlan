package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;

public class EstatusPagoAssembler {

	public static EstatusPago getEstatusPago(Integer idEstatus){

		if(idEstatus==null )
			return null;

		EstatusPago estatusPago= new EstatusPago();
		estatusPago.setIdEstatus(idEstatus);
		
		return estatusPago;
	}
	
}
