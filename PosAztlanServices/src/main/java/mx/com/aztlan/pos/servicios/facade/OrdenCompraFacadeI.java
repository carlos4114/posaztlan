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
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.reportes.vo.HttpResponseOcVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ordenesCompra")
public interface OrdenCompraFacadeI {
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<List<ProductoVO>> buscar(@RequestBody FiltrosVO filtrosVO) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<HttpResponseOcVO> guardar(@RequestBody OrdenCompraVO ordenCompraVO, HttpServletRequest request) throws BusinessGlobalException, Exception;
}
