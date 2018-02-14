package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;
import mx.com.aztlan.pos.negocio.configuracion.vo.FormaPagoVO;

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
	
	public static List<FormaPagoVO> getFormasPagosVO(List<FormaPago> formasPagos){

		if(formasPagos==null || formasPagos.isEmpty())
			return null;
		
		List<FormaPagoVO> formasPagosVO = new ArrayList<FormaPagoVO>();
		
		for (FormaPago formaPago : formasPagos) {
			formasPagosVO.add(FormaPagoAssembler.getFormaPagoVO(formaPago));
		}

		return formasPagosVO;
	}

}
