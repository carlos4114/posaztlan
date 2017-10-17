package mx.com.tecnetia.muvitul.seguridadservices.servicios.seguridad.controller;


import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business.SeguridadBO;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business.UsuarioBO;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoIbatisDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.UsuarioDAOI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioController extends GlobalService{
 
	@Autowired
	UsuarioBO usuarioBO;
	@Autowired
	SeguridadBO seguridadBO;		

	@Autowired
	RecursoIbatisDAOI recursoIbatisDAO;		
	@Autowired
	RecursoDAOI recursoDAO;		
	@Autowired
	UsuarioDAOI usuarioDAO;		

	@Transactional(readOnly = true)
	public LoginResponseVO actualizarToken(Claims claims) throws BusinessGlobalException, Exception{
		//Ahora actualizamos el token
		return this.seguridadBO.actualizarToken(claims);
	}
	
	@Transactional(readOnly = true)
	public LoginResponseVO autenticarUsuarioJwt(UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception{
		//Primero encriptamos la contrasenia
		usuarioVO.setContrasenia(this.seguridadBO.encriptarConSHA1(usuarioVO.getContrasenia()));
		
		//Ahora autenticamos
		return this.usuarioBO.autenticarConJwt(usuarioVO);
	}
	
	@Transactional(readOnly = true)
	public Boolean accesoValidoUsuario(HttpRequestVO requestVO) throws BusinessGlobalException, Exception{
		if (requestVO == null) 
            throw new BusinessGlobalException("Error al validar el acceso. El request no puede ser nulo.");

		RecursoVO recursoVO = new RecursoVO(requestVO.getPathInfo());
		
		//Validamos que el token sea valido aun (vigente)
		if(!this.seguridadBO.esTokenVigente(requestVO.getExpiration())){
			return false;
		}
		
		//Validamos que el recurso al que se quiere entrar sea correcto
		if(!this.usuarioBO.autorizaAccesoRecurso(recursoVO, requestVO.getRoles())){
			return false;
		}
		
		//validamos que no haya inyeccion sql en el request
		if(!this.seguridadBO.contieneParametrosValidos(requestVO, recursoVO.getUrl())){
			return false;
		}
			
		//validamos que no haya inyeccion sql en caso de que venga un JSON
		if(this.seguridadBO.contieneInyeccionSqlJson(requestVO.getBody())){
			return false;
		}
		
		return true;
	}
		
	@Transactional(readOnly = false)
	public void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al guardar el usuario. El usuario no puede ser nulo.");
		
		this.usuarioBO.guardarUsuario(usuarioVO);	
	}
	
	@Transactional(readOnly = true)
	public UserDetailsVO getUserDetails(UsuarioVO usuarioVO) throws UsernameNotFoundException, DataAccessException{
		if (usuarioVO == null) 
            throw new UsernameNotFoundException("Error al obtener userDetails. El usuario no puede ser nulo.");

		return this.usuarioBO.getUserDetails(usuarioVO);	
	}
	
	@Transactional(readOnly = true)
	public UsuarioFirmadoVO getUsuarioFirmadoVO(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al obtener usuario Firmado. El usuario no puede ser nulo.");
		
		return UsuarioAssembler.getUsuarioFirmadoVO(this.usuarioDAO.getUsuario(usuarioVO.getCorreo()));
	}
 
}