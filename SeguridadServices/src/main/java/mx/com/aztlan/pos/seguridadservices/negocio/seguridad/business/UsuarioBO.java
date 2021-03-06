package mx.com.aztlan.pos.seguridadservices.negocio.seguridad.business;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.RecursoVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoAutorizacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Perfil;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ErroresSeguridadEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusEmpresaEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.TipoAutorizacionEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.UsuarioEstatusEnum;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.GlobalService;
import mx.com.aztlan.pos.seguridadservices.negocio.seguridad.assembler.PerfilAssembler;
import mx.com.aztlan.pos.seguridadservices.negocio.seguridad.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao.RecursoDAOI;
import mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao.RecursoIbatisDAOI;
import mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao.UsuarioDAOI;
import mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao.UsuarioIbatisDAOI;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Configuration
@PropertySource({"classpath:config/${ENV_VAR}/global.properties","classpath:config/aplicacion/aplicacion.properties"})
public class UsuarioBO extends GlobalService{
 
	@Autowired
	UsuarioDAOI usuarioDAO;		
	@Autowired
	UsuarioIbatisDAOI usuarioIbatisDAO;		
	@Autowired
	StandardPBEStringEncryptor stringEcryptor;
	@Autowired
    Environment env;
	@Autowired
	RecursoIbatisDAOI recursoIbatisDAO;
	@Autowired
	RecursoDAOI recursoDAO;	
	@Autowired
	TipoAutorizacionDAOI tipoAutorizacionDAO;
	
	/**
     * Servicio para validar la contrase�a actual de un usuario
     */
	@Transactional (readOnly=true)
	public boolean contraseniaActualValida(UsuarioLoginVO usuarioVO) throws Exception{
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. El objeto de usuario no puede ser nulo.");
		 if (usuarioVO.getUsuario() == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. El usuario no puede ser nulo.");
		 if (usuarioVO.getContrasenia() == null) 
	            throw new BusinessGlobalException("Error al validar contrasenia. La contrasenia no puede ser nulo.");
			
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		if(usuario==null)
            throw new BusinessGlobalException("Error al validar contrasenia. No se encontr� el usuario actual.");
			
		 //Este metodo asume que la contrasenia viene encriptada con SHA1
		if(!usuarioVO.getContrasenia().equals(usuario.getContrasenia()))
			return false;
		
		return true;
	}
	
	/**
     * Servicio para cambiar la cotrase�a de un usuario
     */
	@Transactional (readOnly=false)
	public void cambiarContrasenia(UsuarioLoginVO usuarioVO) throws Exception{
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al cambiar contrasenia. El objeto de usuario no puede ser nulo.");
	
		Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		usuario.setContrasenia(usuarioVO.getContrasenia());
		this.usuarioDAO.update(usuario);
	}
	
	@Transactional(readOnly = true)
	public LoginResponseVO autenticarConJwt(UsuarioLoginVO usuarioVO) throws BusinessGlobalException, Exception {
		 if (usuarioVO == null) 
	            throw new BusinessGlobalException("Error al autenticarse. El objeto de usuario no puede ser nulo.");
		 if (usuarioVO.getUsuario() == null) 
	            throw new BusinessGlobalException("Error al autenticarse. El usuario no puede ser nulo.");
		 if (usuarioVO.getContrasenia() == null) 
	            throw new BusinessGlobalException("Error al autenticarse. La contrase�a no puede ser nula.");
		 	     
		 //Buscamos al usuario. Que exista...
		 Usuario usuario = this.usuarioDAO.getUsuario(usuarioVO.getUsuario());
		 if (usuario==null)
		        return new LoginResponseVO(ErroresSeguridadEnum.USUARIO_NO_EXISTE);	

		 //Este metodo asume que la contrasenia viene encriptada con SHA1
		 if(!usuarioVO.getContrasenia().equals(usuario.getContrasenia()))
		        return new LoginResponseVO(ErroresSeguridadEnum.CONTRASENIA_INCORRECTA);	

		 // Validamos que la empresa a la que pertenece el usuario est� en un estatus v�lido para entrar
		 if (EstatusEmpresaEnum.EN_DEUDA == (usuario.getEmpresa() == null ? -1 : usuario.getEmpresa().getEstatusEmpresa().getIdEstatus()))
		        return new LoginResponseVO(ErroresSeguridadEnum.EMPRESA_EN_DEUDA);	
		 if (EstatusEmpresaEnum.BAJA_DECISION_PROPIA ==(usuario.getEmpresa() == null ? -1 : usuario.getEmpresa().getEstatusEmpresa().getIdEstatus()))
		        return new LoginResponseVO(ErroresSeguridadEnum.EMPRESA_INACTIVA);	
		 
		 // Validamos que el usuario est� activo
		 if (UsuarioEstatusEnum.INACTIVO == usuario.getEstatusUsuario().getIdEstatus())
		        return new LoginResponseVO(ErroresSeguridadEnum.USUARIO_INACTIVO);	
		 
		 List<Integer> roles = PerfilAssembler.getPerfilesId(usuario.getPerfils());
		 Long contTipoAutorizacion = this.tipoAutorizacionDAO.countAutorizacionUsrPorTipo(usuario.getIdUsuario(), TipoAutorizacionEnum.AJUSTE_CONTEO_INVENTARIO);
		 
		 boolean isAdminGral = usuario.getEmpresa()==null;
		 boolean isAdminEmpresa = usuario.getEmpresa()!=null&&usuario.getCanal()==null;
		 boolean isAdminCanal = usuario.getEmpresa()!=null&&usuario.getCanal()!=null&&usuario.getAlmacen()==null;
		 boolean isAutorizadorConteo = contTipoAutorizacion != 0;
		 
		 String pwdEncryptor = env.getProperty("jwt.password");
		 Integer expirationMinutes = new Integer(env.getProperty("jwt.expiration.minutes"));
		 
		 Date fechaActual = FechasUtilsBO.getCurrentDate();
		 Date fechaExpriacion = FechasUtilsBO.addMinutesToDate(fechaActual, expirationMinutes);
		 		 
		 return new LoginResponseVO(
				       usuario.getEmpresa()==null?null:usuario.getEmpresa().getIdEmpresa(),
				       usuario.getCanal()==null?null:usuario.getCanal().getIdCanal(),		   
					   usuario.getAlmacen()==null?null:usuario.getAlmacen().getIdAlmacen(),		   
			       	   usuario.getNombre(),
				       Jwts.builder().setSubject(usuarioVO.getUsuario())
				       	  			 .claim(ClaimsEnum.ROLES, roles)
				       	  			 .claim(ClaimsEnum.USUARIO, usuario.getIdUsuario())
				       	  			 .claim(ClaimsEnum.CANAL, usuario.getCanal()==null?null:usuario.getCanal().getIdCanal())
				       	  			 .claim(ClaimsEnum.ALMACEN, usuario.getAlmacen()==null?null:usuario.getAlmacen().getIdAlmacen())
				       	  			 .claim(ClaimsEnum.CAJA, usuario.getCaja()==null?null:usuario.getCaja().getIdCaja())
				       	  			 .claim(ClaimsEnum.NOMBRE_COMPLETO_USR, usuario.getNombre())
				       	  			 .claim(ClaimsEnum.IS_ADMIN_GRAL, isAdminGral)
				       	  			 .claim(ClaimsEnum.IS_ADMIN_GRAL_EMPRESA, isAdminEmpresa)
				       	  			 .claim(ClaimsEnum.IS_ADMIN_CANAL, isAdminCanal)			       	  			 
				       	  			 .setIssuedAt(fechaActual)
				       	  			 .setExpiration(fechaExpriacion)
				       	  			 .signWith(SignatureAlgorithm.HS256, pwdEncryptor)
				       	  			 .compact()
				       ,usuario.getEmpresa()==null?null:usuario.getEmpresa().getIcono()
				       ,isAdminGral
				       ,isAdminEmpresa
				       ,isAdminCanal
				       ,isAutorizadorConteo
				 );
	}
	
	@Transactional(readOnly = true)
	private Boolean contieneRol(final Set<Perfil> rolesRecurso, final List<Integer> rolesUsr) throws BusinessGlobalException, Exception{
		if (rolesRecurso == null) 
            return false;
		if (rolesUsr == null) 
			return false;
		
		Iterator<Perfil> perfilesRecursoItr = rolesRecurso.iterator();
		while(perfilesRecursoItr.hasNext()){
			Perfil perfilRec = perfilesRecursoItr.next();
			if(rolesUsr.contains(perfilRec.getIdPerfil()))
				return true;
		}
		
		return false;
	}
	
	@Transactional(readOnly = true)
	public Boolean autorizaAccesoRecurso(RecursoVO recursoVO, List<Integer> roles) throws BusinessGlobalException, Exception{
		if (roles == null) 
            throw new BusinessGlobalException("Error al autorizar. El objeto claims no puede ser nulo.");
		if (recursoVO == null) 
            throw new BusinessGlobalException("Error al autorizar. El objeto recurso no puede ser nulo.");
		if (recursoVO.getUrl() == null) 
            throw new BusinessGlobalException("Error al autorizar. La url no puede ser nula.");

		//buscamos recursos activos para la aplicacion determinada
		recursoVO = this.recursoIbatisDAO.getRecursoPorUrl(recursoVO.getUrl(),true);
		if(recursoVO==null){
			//no existe ese recurso o no tiene permiso
		    return false;
		}
		
		if(!recursoVO.getPermitirATodos()){
			//validamos si tiene permiso el usuario, para ese recurso
			//return this.contieneRol(this.recursoDAO.findById(recursoVO.getIdRecurso()).getPerfils(), roles);
		}	
			
		return true;
	}
		

	@Transactional(readOnly = true)
	public UserDetailsVO getUserDetails(UsuarioVO usuarioVO) throws UsernameNotFoundException, DataAccessException{		
		if (usuarioVO == null) {
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails el objeto de UsuarioVO no puede ser nulo");
		}
		if (usuarioVO.getCorreo() == null) {
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails el correo no puede ser nulo");
		}
		
		Usuario usuario;
		try{
			usuario = this.usuarioDAO.getUsuario(usuarioVO.getCorreo());
		}catch(Exception e){
			throw new UsernameNotFoundException("Error en el servicio UsuarioController.getUserDetails no se puede obtener el usuario",e);			
		}
				
		UserDetailsVO userDetailsVO = UsuarioAssembler.getUserDetailsVO(usuario);
		if(userDetailsVO!=null && usuario!=null)
			userDetailsVO.setEnabled(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		
		return userDetailsVO;	
	}

	@Transactional(readOnly = false)
	public void guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		if (usuarioVO == null) 
            throw new BusinessGlobalException("Error al guardar usuario. El usuario no puede ser nulo.");
		
		this.usuarioDAO.save(UsuarioAssembler.getUsuario(usuarioVO));
	}
	
	/*@Transactional(readOnly = false)	
	public Boolean guardarUsuario(UsuarioVO usuarioVO) throws BusinessGlobalException, Exception{
		
		Usuario u1 =  new Usuario();
		EncripcionBO encripcionBO = new EncripcionBO();

		u1.setContrasenia(encripcionBO.encriptarConSHA1("ruiz"));
		u1.setCorreo("carlos.ruiz@unitis.com.mx");
		u1.setIdEstatus(1);
		u1.setMaterno("Perez");
		u1.setNombre("Fernando");
		u1.setPaterno("Perez");
		
		this.usuarioDAO.save(u1);

		
		//// BUSCAMOS POR IBATIS
		List<Usuario> usuarios = usuarioIbatisDAO.obtenerListaUsuarios();
		UsuarioAssembler.getUsuarios(usuarios, this.stringEcryptor);
			
		return true;	
	}*/
 
}