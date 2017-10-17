package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.VentaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ventaProducto")
public interface VentaProductoFacadeI {
	@RequestMapping(value = "/paquetes", method = RequestMethod.GET)
	public ResponseEntity<List<PaqueteVO>> getPaquetes(HttpServletRequest request) throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ResponseEntity<List<ArchivoPdfVO>> getTicketPdf(HttpServletRequest request, Integer idTicket,BigDecimal pagoCon, BigDecimal cambio)
			throws BusinessGlobalException, NotFoundException;
	
}
