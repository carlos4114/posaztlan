package mx.com.tecnetia.muvitul.seguridadservices.servicios.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/seguridad")
public interface SeguridadFacadeI {
	@RequestMapping(value = "autenticar", method = RequestMethod.POST)
    LoginResponseVO loginJwt(@RequestBody UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "autorizar", method = RequestMethod.POST)
	Boolean accesoValidoUsuario(@RequestBody HttpRequestVO requestVO) throws BusinessGlobalException, Exception;
	@RequestMapping(value = "actualizarTk", method = RequestMethod.GET)
    LoginResponseVO actualizarToken(HttpServletRequest request) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "firmado", method = RequestMethod.POST)
	UsuarioFirmadoVO getUsuarioFirmadoVO(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;
	void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;
}
