package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;


public class FormaPagoAssembler {
	
	public static FormaPago getFormaPago(Integer idFormaPago){

		if(idFormaPago==null)
			return null;
		
		FormaPago formaPago = new FormaPago();
		formaPago.setIdFormaPago(idFormaPago);

		return formaPago;
	}
	
	
}
