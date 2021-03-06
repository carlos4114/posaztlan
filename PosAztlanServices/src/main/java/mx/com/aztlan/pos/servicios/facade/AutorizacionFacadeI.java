package mx.com.aztlan.pos.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.RequestAutorizacionVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/autorizacion")
public interface AutorizacionFacadeI {
	@RequestMapping(value = "/movimientos", method = RequestMethod.POST)
	public ResponseEntity<EstatusAutorizacionVO> createAutorizacion(HttpServletRequest request,
			@RequestBody RequestAutorizacionVO requestAutorizacionVO) throws BusinessGlobalException, NotFoundException;

}
