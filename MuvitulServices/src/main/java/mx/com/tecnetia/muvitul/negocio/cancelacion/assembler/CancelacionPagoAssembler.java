package mx.com.tecnetia.muvitul.negocio.cancelacion.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CancelacionPago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.CancelacionPagoVO;

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
