package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.FormaPagoVO;

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
	
	public static FormaPago getFormaPago(Integer idFormaPago){

		if(idFormaPago==null)
			return null;
		
		FormaPago formaPago = new FormaPago();
		formaPago.setIdFormaPago(idFormaPago);

		return formaPago;
	}
	
	
}
