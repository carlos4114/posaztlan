package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.dulceria.controller.VentaProductoController;

@Service
public class VentaProductoFacade implements VentaProductoFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);

	@Autowired
	VentaProductoController ventaProductoController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("GetPaquetes:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		List<PaqueteVO> paquetes = ventaProductoController.getPaquetes(idPuntoVenta);

		if (paquetes == null || paquetes.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PaqueteVO>>(paquetes, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		ventaVO.setIdUsuario(idUsuario);
		ventaVO.setIdCine(idCine);
		ventaVO.setIdPuntoVenta(idPuntoVenta);
		
		logger.info("CreateVenta:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]",idUsuario,idCine,idPuntoVenta);
		
		TicketVentaVO ticketVentaVO = ventaProductoController.createVenta(ventaVO);
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<List<ArchivoPdfVO>>  getTicketPdf(HttpServletRequest request, Integer idTicket, BigDecimal pagoCon, BigDecimal cambio)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketPdf:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		List<ArchivoPdfVO> archivosPdfVO = ventaProductoController.getTicketPdf(idUsuario,idTicket, pagoCon, cambio);
		
		if (archivosPdfVO == null || archivosPdfVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

//		byte[] ticketPdf = ventaProductoController.getTicketPdf(idUsuario, idTicket, pagoCon, cambio).get(0);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.parseMediaType("application/pdf"));
//		headers.add("Content-Disposition", "attachmnt; filename ='test'");
//		headers.add("filename", "s");
//		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//		headers.setContentLength(ticketPdf.length);
		
		return new ResponseEntity<List<ArchivoPdfVO>>(archivosPdfVO, HttpStatus.OK);
		
	}

}
