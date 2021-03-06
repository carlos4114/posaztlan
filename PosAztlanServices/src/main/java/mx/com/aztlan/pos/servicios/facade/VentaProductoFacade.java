package mx.com.aztlan.pos.servicios.facade;

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
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.VentaManualVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteAgotadoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TicketVentaVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.VentaVO;
import mx.com.aztlan.pos.negocio.reportes.vo.HttpResponseOcVO;
import mx.com.aztlan.pos.servicios.dulceria.controller.VentaProductoController;

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
	public ResponseEntity<PaqueteAgotadoVO> validarPaquete(HttpServletRequest request, @RequestBody List<PaqueteVO> paquetesVO)
			throws BusinessGlobalException, NotFoundException {

		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("ValidarPaquete:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		PaqueteAgotadoVO paqueteAgotado = ventaProductoController.validarPaquete(paquetesVO, idPuntoVenta);
		
		return new ResponseEntity<PaqueteAgotadoVO>(paqueteAgotado, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen=(Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idCaja=(Integer) claims.get(ClaimsEnum.CAJA);
		
		ventaVO.setIdUsuario(idUsuario);
		ventaVO.setIdCanal(idCanal);
		ventaVO.setIdAlmacen(idAlmacen);
		ventaVO.setIdCaja(idCaja);
		
		logger.info("CreateVenta:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]",idUsuario,idCanal,idAlmacen);
		
		TicketVentaVO ticketVentaVO = ventaProductoController.createVenta(ventaVO);
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<HttpResponseOcVO> createVentaManual(HttpServletRequest request, @RequestBody VentaManualVO ventaManualVO) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL) == null ? ventaManualVO.getIdCanal() : (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen=(Integer) claims.get(ClaimsEnum.ALMACEN)==null? ventaManualVO.getIdAlmacen() : (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idCaja=(Integer) claims.get(ClaimsEnum.CAJA);
		
		VentaVO ventaVO  = new VentaVO();
		ventaVO.setIdEmpresa(ventaManualVO.getIdEmpresa());
		ventaVO.setIdUsuario(idUsuario);
		ventaVO.setIdCanal(idCanal);
		ventaVO.setIdAlmacen(idAlmacen);
		ventaVO.setIdCaja(idCaja);
		
		logger.info("CreateVentaManual:::IdUsuario[{}]:::IdCanal[{}]:::IdAlmacen[{}]",idUsuario,idCanal,idAlmacen);
		
		HttpResponseOcVO responseVO = ventaProductoController.createVentaManual(ventaManualVO, ventaVO);
		return new ResponseEntity<HttpResponseOcVO>(responseVO, HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<List<ArchivoPdfVO>>  getTicketPdf(HttpServletRequest request, Integer idTicket, BigDecimal pagoCon, BigDecimal cambio)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketPdf:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		List<ArchivoPdfVO> archivosPdfVO = ventaProductoController.getTicketPdf(idTicket, pagoCon, cambio,idCine);
		
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
