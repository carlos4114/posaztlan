package mx.com.aztlan.pos.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.cancelacion.vo.CancelacionPagoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaVO;
import mx.com.aztlan.pos.servicios.cancelacion.controller.CancelacionController;

@Service
public class CancelacionFacade implements CancelacionFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(CancelacionFacade.class);

	@Autowired
	private CancelacionController cancelacionController;

	@Override
	public ResponseEntity<TicketVentaVO> getTicketsVenta(HttpServletRequest request, Integer idTicket, String clavePuntoVenta)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketVenta:::IdUsuario[{}]:::IdCanal[{}]", idUsuario, idCanal);

		TicketVentaVO ticketVentaVO = cancelacionController.getTicketVenta(idCanal, idTicket, clavePuntoVenta);
		
		if (ticketVentaVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<TicketVentaVO> createCancelacionPago(HttpServletRequest request,
			@RequestBody CancelacionPagoVO cancelacionPagoVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("CreateDevolucionProducto:::IdUsuario[{}]:::IdCanal[{}]", idUsuario, idCanal);

		TicketVentaVO ticketVentaVO = cancelacionController.createCancelacionPago(idCanal, idUsuario, cancelacionPagoVO);
		
		if (ticketVentaVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);
	}

}
