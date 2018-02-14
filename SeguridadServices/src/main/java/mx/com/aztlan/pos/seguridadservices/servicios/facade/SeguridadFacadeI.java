package mx.com.aztlan.pos.seguridadservices.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.CambioContraseniaVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.EstatusUsuarioVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.OpcionMenuVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/seguridad")
public interface SeguridadFacadeI {
	
	@RequestMapping(value = "estatusUsuario", method = RequestMethod.GET)
	ResponseEntity<List<EstatusUsuarioVO>> getEstatusUsuario() throws BusinessGlobalException;
	@RequestMapping(value = "autenticar", method = RequestMethod.POST)
    LoginResponseVO loginJwt(@RequestBody UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "autorizar", method = RequestMethod.POST)
	Boolean accesoValidoUsuario(@RequestBody HttpRequestVO requestVO) throws BusinessGlobalException, Exception;
	@RequestMapping(value = "actualizarTk", method = RequestMethod.GET)
    LoginResponseVO actualizarToken(HttpServletRequest request) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "firmado", method = RequestMethod.POST)
	UsuarioFirmadoVO getUsuarioFirmadoVO(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;
	void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;
	@RequestMapping(value = "obtenerMenu", method = RequestMethod.GET)
    List<OpcionMenuVO> obtenerMenu(HttpServletRequest request) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "recuperarContrasenia", method = RequestMethod.POST)
	void recuperarContrasenia(@RequestBody UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "cambiarContrasenia", method = RequestMethod.POST)
	ResponseEntity<HttpResponseVO> cambiarContrasenia(@RequestBody CambioContraseniaVO contraseniaVO,HttpServletRequest request) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "actualizarUsuario", method = RequestMethod.POST)
	HttpResponseVO actualizarUsuario(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "guardarUsuarioNuevo", method = RequestMethod.POST)
	HttpResponseVO guardarUsuarioNuevo(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception;		
	//@RequestMapping(value = "realizarBajaUsuario/{idUsuario}", method = RequestMethod.GET)
	//void realizarBajaUsuario(@PathVariable("idUsuario") Integer idUsuario) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "obtenerUsuario/{idUsuario}", method = RequestMethod.GET)
	UsuarioVO obtenerUsuario(@PathVariable("idUsuario") Integer idUsuario) throws BusinessGlobalException, Exception;		
	@RequestMapping(value = "obtenerUsuarios/{idCine}", method = RequestMethod.GET)
	List<UsuarioVO> obtenerUsuarios(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException, Exception;	
	@RequestMapping(value = "obtenerPerfiles/{idEmpresa}", method = RequestMethod.GET)
	List<PerfilVO> obtenerPerfiles(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, Exception;	
	

}
