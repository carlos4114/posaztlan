package mx.com.aztlan.pos.servicios.facade;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.caja.vo.CorteCajaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/caja")
public interface CajaFacadeI {

	@RequestMapping(value = "/guardarCorte", method = RequestMethod.POST)
	HttpResponseVO guardarCorte(@RequestBody CorteCajaVO corteCajaVO,HttpServletRequest request) throws BusinessGlobalException;
	
	@RequestMapping(value = "/obtenerEfectivo", method = RequestMethod.GET)
	BigDecimal obtenerEfectivo(HttpServletRequest request) throws BusinessGlobalException, Exception;
	
	@RequestMapping(value = "/obtenerUltimosCortes", method = RequestMethod.GET)
	List<CorteCajaVO> obtenerUltimosCortes(HttpServletRequest request) throws BusinessGlobalException, Exception;
}
