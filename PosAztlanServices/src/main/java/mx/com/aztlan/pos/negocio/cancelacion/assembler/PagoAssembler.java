package mx.com.aztlan.pos.negocio.cancelacion.assembler;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.cancelacion.vo.PagoVO;


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
