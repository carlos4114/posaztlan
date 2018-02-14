package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

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
import mx.com.aztlan.pos.negocio.devolucion.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionResponseVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaProductoVO;
import mx.com.aztlan.pos.servicios.devolucion.controller.DevolucionController;

@Service
public class DevolucionFacade implements DevolucionFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(DevolucionFacade.class);

	@Autowired
	private DevolucionController devolucionController;

	
	@Override
	public ResponseEntity<TicketVentaBoletoVO>  getTicketVentaBoletos(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketVentaBoletos:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		TicketVentaBoletoVO ticketVentaVO = devolucionController.getTicketVentaBoletos(idCine, idTicket);
		
		if (ticketVentaVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<TicketVentaBoletoVO>(ticketVentaVO, HttpStatus.OK);
		
	}


	@Override
	public ResponseEntity<DevolucionResponseVO> createDevolucionBoleto(HttpServletRequest request,
			@RequestBody DevolucionBoletoVO devolucionBoletoVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("CreateDevolucionBoleto:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		DevolucionResponseVO devolucionResponseVO= devolucionController.createDevolucionBoleto(idUsuario, devolucionBoletoVO);
		
		if (devolucionResponseVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<DevolucionResponseVO>(devolucionResponseVO, HttpStatus.CREATED);
	}


	
	@Override
	public ResponseEntity<TicketVentaProductoVO>  getTicketVentaProductos(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketVentaBoletos:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		TicketVentaProductoVO ticketVentaVO = devolucionController.getTicketVentaProductos(idCine,idTicket);
		
		if (ticketVentaVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<TicketVentaProductoVO>(ticketVentaVO, HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<DevolucionResponseVO> createDevolucionProducto(HttpServletRequest request,
			@RequestBody  DevolucionProductoVO devolucionProductoVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		devolucionProductoVO.setIdPuntoVenta(idPuntoVenta);
		
		logger.info("CreateDevolucionProducto:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		DevolucionResponseVO devolucionResponseVO= devolucionController.createDevolucionProducto(idUsuario, idCine, devolucionProductoVO);
				
		if (devolucionResponseVO == null ) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<DevolucionResponseVO>(devolucionResponseVO, HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<List<ArchivoPdfVO>> getCortesiaPdf(HttpServletRequest request, Integer idTicket, Integer idDevolucion) throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetCortesiaPdf:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		List<ArchivoPdfVO> archivosPdfVO = devolucionController.generarCortesiaPdf(idUsuario,idTicket,idDevolucion);
		
		if (archivosPdfVO == null || archivosPdfVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}
		
		return new ResponseEntity<List<ArchivoPdfVO>>(archivosPdfVO, HttpStatus.OK);
	}

}
