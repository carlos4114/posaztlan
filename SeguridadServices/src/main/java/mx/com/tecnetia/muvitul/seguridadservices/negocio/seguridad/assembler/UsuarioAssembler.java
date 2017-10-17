package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.UsuarioEstatusEnum;

public class UsuarioAssembler {
	final static Log log = LogFactory.getLog(UsuarioAssembler.class);

	public static UsuarioFirmadoVO getUsuarioFirmadoVO(Usuario usuario){

		if(usuario==null)
			return null;
		
		UsuarioFirmadoVO usuarioFirmadoVO = new UsuarioFirmadoVO();
		
		usuarioFirmadoVO.setApPaterno(usuario.getPaterno());
		usuarioFirmadoVO.setUsername(usuario.getCorreo());
		usuarioFirmadoVO.setId(usuario.getIdUsuario());
		usuarioFirmadoVO.setNombre(usuario.getNombre());		
		usuarioFirmadoVO.setCineVO(CineAssembler.getCineVO(usuario.getCine()));
		usuarioFirmadoVO.setRoles(new HashSet<PerfilVO>(PerfilAssembler.getPerfilesVO(usuario.getPerfilesXUsuarios())));
		usuarioFirmadoVO.setAccountNonLocked(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		usuarioFirmadoVO.setEnabled(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		usuarioFirmadoVO.setCredentialsNonExpired(!usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));		
		
		return usuarioFirmadoVO;
	}


	public static UsuarioVO getUsuarioVO(Usuario usuario) {

		if(usuario==null)
			return null;

		UsuarioVO usuarioVO =  new UsuarioVO();

		usuarioVO.setCorreo(usuario.getCorreo()==null?"":usuario.getCorreo());
		usuarioVO.setContrasenia(usuario.getContrasenia()==null?"":usuario.getContrasenia());

		return usuarioVO;
	}

	public static UserDetailsVO getUserDetailsVO(Usuario usuario) {

		if(usuario==null)
			return new UserDetailsVO();

		UserDetailsVO userDetailsVO =  new UserDetailsVO();

		userDetailsVO.setId(usuario.getIdUsuario());
		userDetailsVO.setUsername(usuario.getCorreo());
		userDetailsVO.setPassword(usuario.getContrasenia());
		
		userDetailsVO.setRoles(new HashSet<PerfilVO>(PerfilAssembler.getPerfilesVO(usuario.getPerfilesXUsuarios())));
				
		/*TODO corregir esto por el estatus de Activo e Inactivo*/
		userDetailsVO.setAccountNonLocked(!usuario.getEstatusUsuario().getIdEstatus().equals(-1));
		userDetailsVO.setEnabled(!usuario.getEstatusUsuario().getIdEstatus().equals(-1));
		userDetailsVO.setCredentialsNonExpired(!usuario.getEstatusUsuario().getIdEstatus().equals(-1));		
		
		return userDetailsVO;
	}

	
	public static void getUsuarios(List<Usuario> usuarios,StandardPBEStringEncryptor stringEncryptor){
		
		for(Usuario usuario2: usuarios){
			log.debug("Usuario Ibatis Paterno: "+stringEncryptor.decrypt(usuario2.getPaterno()));
			log.debug("Usuario Ibatis Correo: "+usuario2.getCorreo());
			log.debug("Usuario Ibatis Contraseña: "+usuario2.getContrasenia());			
		}
	}
	
	public static Usuario getUsuario(UsuarioVO usuarioVO) {

		if(usuarioVO==null)
			return null;

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(null);
		usuario.setContrasenia(usuarioVO.getContrasenia());
		usuario.setCorreo(usuarioVO.getCorreo());
		usuario.getEstatusUsuario().setIdEstatus(usuarioVO.getIdEstatus());
		usuario.setMaterno(usuarioVO.getMaterno());
		usuario.setPaterno(usuarioVO.getPaterno());
		usuario.setNombre(usuarioVO.getNombre());
		
		return usuario;
	}

}
