package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;
import mx.com.aztlan.pos.negocio.devolucion.vo.FormaPagoVO;

public class FormaPagoAssembler {

	public static FormaPagoVO getFormaPagoVO(FormaPago formaPago){

		if(formaPago==null )
			return null;
		
		FormaPagoVO formaPagoVO = new FormaPagoVO();
		formaPagoVO.setIdFormaPago(formaPago.getIdFormaPago());
		formaPagoVO.setNombre(formaPago.getNombre());
		formaPagoVO.setRequiereNumCuenta(formaPago.isRequiereNumCuenta());
		formaPagoVO.setActivo(formaPago.isActivo());

		return formaPagoVO;
	}
	
}
