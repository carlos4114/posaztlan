package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionResponseVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaProductoVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/devolucion")
public interface DevolucionFacadeI {
	@RequestMapping(value = "/boletos", method = RequestMethod.GET)
	public ResponseEntity<TicketVentaBoletoVO> getTicketVentaBoletos(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/boletos", method = RequestMethod.POST)
	public ResponseEntity<DevolucionResponseVO> createDevolucionBoleto(HttpServletRequest request, @RequestBody DevolucionBoletoVO devolucionBoletoVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public ResponseEntity<TicketVentaProductoVO> getTicketVentaProductos(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productos", method = RequestMethod.POST)
	public ResponseEntity<DevolucionResponseVO> createDevolucionProducto(HttpServletRequest request, @RequestBody DevolucionProductoVO pevolucionProductoVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/cortesias", method = RequestMethod.GET)
	public ResponseEntity<List<ArchivoPdfVO>> getCortesiaPdf(HttpServletRequest request, Integer idTicket, Integer idDevolucion)
			throws BusinessGlobalException, NotFoundException;
}
