package mx.com.tecnetia.muvitul.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.cancelacion.vo.CancelacionPagoVO;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.TicketVentaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cancelacion")
public interface CancelacionFacadeI {

	@RequestMapping(value = "/ticketsVenta", method = RequestMethod.GET)
	public ResponseEntity<TicketVentaVO> getTicketsVenta(HttpServletRequest request, Integer idTicket, String clavePuntoVenta)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/pagos", method = RequestMethod.POST)
	public ResponseEntity<TicketVentaVO> createCancelacionPago(HttpServletRequest request, @RequestBody CancelacionPagoVO cancelacionPagoVO)
			throws BusinessGlobalException, NotFoundException;

}
