package mx.com.aztlan.pos.seguridadservices.servicios.facade;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.CambioContraseniaVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.EstatusUsuarioVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.OpcionMenuVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ErroresSeguridadEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.seguridadservices.servicios.exception.ContraseniaActualIncorrectaException;
import mx.com.aztlan.pos.seguridadservices.servicios.seguridad.controller.PerfilController;
import mx.com.aztlan.pos.seguridadservices.servicios.seguridad.controller.UsuarioController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SeguridadFacade implements SeguridadFacadeI,UserDetailsService{

	@Autowired
	UsuarioController usuarioController;
	@Autowired
	PerfilController perfilController;
	
	
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<List<EstatusUsuarioVO>> getEstatusUsuario() throws BusinessGlobalException {
		return new ResponseEntity<List<EstatusUsuarioVO>>(this.usuarioController.getEstatusUsuario(), HttpStatus.OK);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<PerfilVO> obtenerPerfiles(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, Exception{
		return this.perfilController.obtenerPerfiles(idEmpresa);
	}
	
	//@Override
	@Transactional(readOnly=false)
    public void realizarBajaUsuario(@PathVariable("idUsuario") Integer idUsuario) throws BusinessGlobalException, Exception{      
        this.usuarioController.realizarBajaUsuario(idUsuario);
    }
	
	@Override	
	@Transactional(readOnly=true)
    public UsuarioVO obtenerUsuario(@PathVariable("idUsuario") Integer idUsuario) throws BusinessGlobalException, Exception{      
        return this.usuarioController.obtenerUsuario(idUsuario);
    }
	
	@Override
	@Transactional(readOnly=true)
    public List<UsuarioVO> obtenerUsuarios(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException, Exception{      
        return this.usuarioController.obtenerUsuarios(idCine);
    }
	
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardarUsuarioNuevo(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{				
			return this.usuarioController.guardarUsuarioNuevo(usuarioVO);		
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizarUsuario(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{				
			return this.usuarioController.actualizarUsuario(usuarioVO);		
	}
	
	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<HttpResponseVO> cambiarContrasenia(@RequestBody CambioContraseniaVO contraseniaVO, HttpServletRequest request) throws BusinessGlobalException, Exception{				
		try{
			this.usuarioController.cambiarContrasenia(contraseniaVO,(Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));
		}catch(ContraseniaActualIncorrectaException e){			
			return new ResponseEntity<HttpResponseVO>(new HttpResponseVO(ErroresSeguridadEnum.CONTRASENIA_ACTUAL_INCORRECTA), HttpStatus.OK);
		}
		return new ResponseEntity<HttpResponseVO>(HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = false)
	public void recuperarContrasenia(@RequestBody UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception{
		this.usuarioController.recuperarContrasenia(usuarioVO);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<OpcionMenuVO> obtenerMenu(HttpServletRequest request) throws BusinessGlobalException, Exception{
		return this.usuarioController.obtenerMenu((Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public LoginResponseVO actualizarToken(HttpServletRequest request) throws BusinessGlobalException, Exception{
		return this.usuarioController.actualizarToken((Claims)request.getAttribute(ClaimsEnum.CLAIMS_ID));
	}
	
	@Override
	@Transactional(readOnly = true)
	public LoginResponseVO loginJwt(@RequestBody UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception{
		return this.usuarioController.autenticarUsuarioJwt(usuarioVO);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Boolean accesoValidoUsuario(@RequestBody HttpRequestVO requestVO) throws BusinessGlobalException, Exception{		
		return this.usuarioController.accesoValidoUsuario(requestVO);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioFirmadoVO getUsuarioFirmadoVO(@RequestBody UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		return this.usuarioController.getUsuarioFirmadoVO(usuarioVO);
	}

	
	@Override
	@Transactional(readOnly = false)
	public void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		 this.usuarioController.guardarUsuario(usuarioVO);
	}


	@Override
	@Transactional(readOnly = true)
	public UserDetailsVO loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException{
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setCorreo(username);		
		return this.usuarioController.getUserDetails(usuarioVO);
	}

}
