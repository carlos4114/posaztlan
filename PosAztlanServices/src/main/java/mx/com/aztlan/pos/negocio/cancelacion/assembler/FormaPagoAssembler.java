package mx.com.aztlan.pos.negocio.cancelacion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;


public class FormaPagoAssembler {
	
	public static FormaPago getFormaPago(Integer idFormaPago){

		if(idFormaPago==null)
			return null;
		
		FormaPago formaPago = new FormaPago();
		formaPago.setIdFormaPago(idFormaPago);

		return formaPago;
	}
	
	
}
