package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.PagoVO;


public class PagoAssembler {

	public static Pago getPago(TicketVenta ticketVenta,EstatusPago estatusPago, PagoVO pagoVO){

		if(ticketVenta==null )
			return null;

		Pago pago= new Pago();
		pago.setEstatusPago(estatusPago);
		pago.setFormaPago(FormaPagoAssembler.getFormaPago(pagoVO.getFormaPagoVO().getIdFormaPago()));
		pago.setTicketVenta(ticketVenta);
		pago.setNoCuenta(pagoVO.getNoCuenta());
		pago.setImporte(pagoVO.getImporte());
		pago.setFecha(new Date());
		
		return pago;
	}

}
