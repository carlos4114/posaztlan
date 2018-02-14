package mx.com.aztlan.pos.negocio.cancelacion.assembler;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CancelacionPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.cancelacion.vo.CancelacionPagoVO;

public class CancelacionPagoAssembler {
	
	public static CancelacionPago getCancelacionPago(Pago pago, TicketVenta ticketVenta, CancelacionPagoVO cancelacionPagoVO,Integer idUsuario ){
		
		if(idUsuario==null)
			return null;
		
		CancelacionPago cancelacionPago = new CancelacionPago();
		cancelacionPago.setAutorizacion(AutorizacionAssembler.getAutorizacion(cancelacionPagoVO.getIdAutorizacion()));
		cancelacionPago.setMotivoCancelacion(MotivoCancelacionAssembler.getMotivoCancelacion(cancelacionPagoVO.getMotivoCancelacionVO().getIdMotivoCancelacion()));
		cancelacionPago.setPago(pago);
		cancelacionPago.setTicketVenta(ticketVenta);
		cancelacionPago.setUsuario(UsuarioAssembler.getUsuario(idUsuario));
		cancelacionPago.setFecha(new Date());
		cancelacionPago.setComentarios(cancelacionPagoVO.getComentarios());
		
		return cancelacionPago;
	}
	

	
}
