package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.FormaPagoVO;

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
