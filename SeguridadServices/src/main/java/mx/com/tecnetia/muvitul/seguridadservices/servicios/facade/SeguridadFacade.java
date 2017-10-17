package mx.com.tecnetia.muvitul.seguridadservices.servicios.facade;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.seguridadservices.servicios.seguridad.controller.UsuarioController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SeguridadFacade implements SeguridadFacadeI,UserDetailsService{

	@Autowired
	UsuarioController usuarioController;

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
