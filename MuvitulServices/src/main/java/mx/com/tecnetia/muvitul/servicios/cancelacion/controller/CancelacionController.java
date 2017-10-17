package mx.com.tecnetia.muvitul.servicios.cancelacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.negocio.cancelacion.business.CancelacionBO;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.CancelacionPagoVO;
import mx.com.tecnetia.muvitul.negocio.devolucion.business.DevolucionBO;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.TicketVentaVO;

@Service
public class CancelacionController {

	@Autowired
	private CancelacionBO cancelacionBO;

	@Autowired
	private DevolucionBO devolucionBO;

	public TicketVentaVO createCancelacionPago(Integer idCine,Integer idUsuario, CancelacionPagoVO cancelacionPagoVO) {
		cancelacionBO.createCancelacionPago(idUsuario, cancelacionPagoVO);
		
		return devolucionBO.getTicketVenta(cancelacionPagoVO.getIdTicketVenta());
	}

	public TicketVentaVO getTicketVenta(Integer idCine, Integer idTicket, String clavePuntoVenta) {
		return devolucionBO.getTicketVenta(idCine, idTicket, clavePuntoVenta);
	}

}
