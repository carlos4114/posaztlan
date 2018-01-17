package mx.com.tecnetia.muvitul.seguridadservices.servicios.seguridad.controller;


import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.CambioContraseniaVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.EstatusUsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.OpcionMenuVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusUsuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.UsuarioEstatusEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.EstatusUsuarioAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business.SeguridadBO;
import mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business.UsuarioBO;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.EstatusUsuarioDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoIbatisDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.UsuarioDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.servicios.exception.ContraseniaActualIncorrectaException;

import java.util.List;

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
	@Autowired
	EstatusUsuarioDAOI estatusUsuarioDAO;	
	
	/**
     * Servicio para obtener catalogo de estatus de usuario
     */
	@Transactional (readOnly = true)
	public List<EstatusUsuarioVO> getEstatusUsuario() throws BusinessGlobalException{
	
		 return EstatusUsuarioAssembler.getListaVO(this.estatusUsuarioDAO.findAll());
	}
	
	/**
     * Servicio para cambiar la contraseña del usuario
     */
	@Transactional (readOnly = false)
	public void cambiarContrasenia(CambioContraseniaVO contraseniaVO, Claims claims) throws BusinessGlobalException, Exception{
		 if (contraseniaVO == null) 
            throw new BusinessGlobalException("Error al cambiar la contrasenia del usuario. ContraseniaVO no puede ser nulo.");
		 if (claims == null) 
	            throw new BusinessGlobalException("Error al cambiar la contrasenia del usuario. Claims no puede ser nulo.");
		 String correo = claims.getSubject();
		 if (correo == null) 
	            throw new BusinessGlobalException("Error al cambiar la contrasenia del usuario. Correo no puede ser nulo.");

		//Primero encriptamos la contrasenia
		 UsuarioLoginVO usuarioVO = new UsuarioLoginVO(correo, this.seguridadBO.encriptarConSHA1(contraseniaVO.getContraseniaActual()));

		 //validamos si es correcta la contrasenia actual
		 if(!this.usuarioBO.contraseniaActualValida(usuarioVO))
	          throw new ContraseniaActualIncorrectaException("Error al cambiar la contraseña. La contraseña actual no es correcta.");

		 //cambiamos contrasenia actual por nueva
		 usuarioVO.setContrasenia(this.seguridadBO.encriptarConSHA1(contraseniaVO.getContraseniaNueva()));
		 this.usuarioBO.cambiarContrasenia(usuarioVO);
	}
	
	/**
     * Servicio para enviar un correo con la contraseña al usuario
     */
	@Transactional (readOnly = false)
	public void recuperarContrasenia(UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception{
		 if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al recuperar la contrasenia del usuario. El request no puede ser nulo.");

		 //primero obtenermos la contrasenia nueva y la encriptamos
		  String nuevaContrasenia = this.seguridadBO.obtenerContraseniaAleatoria();
		  usuarioVO.setContrasenia(this.seguridadBO.encriptarConSHA1(nuevaContrasenia));
		  		  
		  //cambiamos la contrasenia actual
		  this.usuarioBO.cambiarContrasenia(usuarioVO);

		  //enviamos el mail de la contrasenia nueva
		  usuarioVO.setContrasenia(nuevaContrasenia);
		  this.seguridadBO.enviarMailContrasenia(usuarioVO);
	}

	@Transactional(readOnly = true)
	public List<OpcionMenuVO> obtenerMenu(Claims claims) throws BusinessGlobalException, Exception{
		 if (claims == null) 
	            throw new BusinessGlobalException("Error al obtener el menú. Claims no puede ser nulo.");
		 String correo = claims.getSubject();
		 if (correo == null) 
	            throw new BusinessGlobalException("Error al obtener el menú. Correo no puede ser nulo.");

		 // se obtiene el menú del usuario firmado
		return this.seguridadBO.obtenerMenuParaUsuario(correo);
	}

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
	public List<UsuarioVO> obtenerUsuarios(Integer idCine) throws BusinessGlobalException, Exception{
		
		return UsuarioAssembler.getUsuariosListVO(this.usuarioDAO.getUsuarios(idCine));
	}
	
	@Transactional(readOnly = true)
	public UsuarioVO obtenerUsuario(Integer idUsuario) throws BusinessGlobalException, Exception{
		
		return UsuarioAssembler.getUsuarioVO(this.usuarioDAO.getById(idUsuario));
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO actualizarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al guardar el usuario. El usuario no puede ser nulo.");
		
		HttpResponseVO responseVO = new HttpResponseVO();
		
		//validar que el usuario no exista por correo electrónico
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getCorreo());		
		if(usuario!=null){	
			if(!usuario.getIdUsuario().equals(usuarioVO.getIdUsuario())){
	            	responseVO.setErrorCode(1);
	            	responseVO.setMessage("El correo electrónico ya existe.");
	
	            	return responseVO;
			}
		}else{
			usuario = this.usuarioDAO.getById(usuarioVO.getIdUsuario());
		}
				
		//se guarda el usuario 
		this.usuarioDAO.save(UsuarioAssembler.getUsuarioActualizado(usuarioVO,usuario));

		return responseVO;
	}
	
	@Transactional(readOnly = false)
	public HttpResponseVO guardarUsuarioNuevo(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al guardar el usuario. El usuario no puede ser nulo.");
		HttpResponseVO responseVO = new HttpResponseVO();
		
		//validar que el usuario no exista por correo electrónico
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getCorreo());		
		if(usuario!=null){
	            	responseVO.setErrorCode(1);
	            	responseVO.setMessage("El correo electrónico ya existe.");
	
	            	return responseVO;
		}
		
		//obtenemos nueva contraseña de usuario
		String nuevaContrasenia = this.seguridadBO.obtenerContraseniaAleatoria();
		usuarioVO.setContrasenia(this.seguridadBO.encriptarConSHA1(nuevaContrasenia));
				
		//se guarda el usuario 
		usuarioVO.setIdUsuario(null);
		usuarioVO.setIdEstatus(UsuarioEstatusEnum.ACTIVO);
		usuario = UsuarioAssembler.getUsuario(usuarioVO);
		this.usuarioDAO.save(usuario);
				
		//enviamos el mail de la contrasenia nueva
		this.seguridadBO.enviarMailContrasenia(new UsuarioLoginVO(usuarioVO.getCorreo(),nuevaContrasenia));
    	
		return responseVO;
	}
	
	@Transactional(readOnly = false)
	public void realizarBajaUsuario(Integer idUsuario) throws BusinessGlobalException, Exception{
	
		//se obtiene el usuario 
		Usuario usuario = this.usuarioDAO.getById(idUsuario);

		//se guarda el usuario con estatus nuevo
		usuario.setEstatusUsuario(new EstatusUsuario(UsuarioEstatusEnum.INACTIVO));
		this.usuarioDAO.update(usuario);
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