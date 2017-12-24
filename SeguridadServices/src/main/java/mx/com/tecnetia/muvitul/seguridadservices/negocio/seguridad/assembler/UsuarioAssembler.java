package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UserDetailsVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusUsuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
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
		
		usuarioFirmadoVO.setRoles(new HashSet<PerfilVO>(PerfilAssembler.getPerfilesVO(usuario.getPerfils())));
		usuarioFirmadoVO.setAccountNonLocked(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		usuarioFirmadoVO.setEnabled(usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));
		usuarioFirmadoVO.setCredentialsNonExpired(!usuario.getEstatusUsuario().getIdEstatus().equals(UsuarioEstatusEnum.ACTIVO));		
		
		return usuarioFirmadoVO;
	}

	public static List<UsuarioVO> getUsuariosListVO(List<Usuario> usuarios) {
		List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();
		for(Usuario usuario: usuarios){
			usuariosVO.add(getUsuarioVO(usuario));
		}
		
		return usuariosVO;
	}

	public static UsuarioVO getUsuarioVO(Usuario usuario) {

		if(usuario==null)
			return null;

		UsuarioVO usuarioVO =  new UsuarioVO();

		usuarioVO.setCorreo(usuario.getCorreo()==null?"":usuario.getCorreo());
		usuarioVO.setContrasenia(usuario.getContrasenia()==null?"":usuario.getContrasenia());
		usuarioVO.setFoto(null);
		usuarioVO.setIdCine(usuario.getCine()==null?null:usuario.getCine().getIdCine());
		usuarioVO.setIdEstatus(usuario.getEstatusUsuario()==null?null:usuario.getEstatusUsuario().getIdEstatus());
		usuarioVO.setEstatus(usuario.getEstatusUsuario()==null?null:usuario.getEstatusUsuario().getNombre());
		usuarioVO.setIdPerfil(usuario.getPerfils()==null?null:usuario.getPerfils().toArray(new Perfil[usuario.getPerfils().size()])[0].getIdPerfil());
		usuarioVO.setPerfil(usuario.getPerfils()==null?null:usuario.getPerfils().toArray(new Perfil[usuario.getPerfils().size()])[0].getNombre());
		usuarioVO.setIdPuntoVenta(usuario.getPuntoVenta()==null?null:usuario.getPuntoVenta().getIdPuntoVenta());
		usuarioVO.setPuntoVenta(usuario.getPuntoVenta()==null?null:usuario.getPuntoVenta().getNombre());
		usuarioVO.setIdUsuario(usuario.getIdUsuario());
		usuarioVO.setMaterno(usuario.getMaterno());
		usuarioVO.setNombre(usuario.getNombre());
		usuarioVO.setPaterno(usuario.getPaterno());
		
		return usuarioVO;
	}

	public static UserDetailsVO getUserDetailsVO(Usuario usuario) {

		if(usuario==null)
			return new UserDetailsVO();

		UserDetailsVO userDetailsVO =  new UserDetailsVO();

		userDetailsVO.setId(usuario.getIdUsuario());
		userDetailsVO.setUsername(usuario.getCorreo());
		userDetailsVO.setPassword(usuario.getContrasenia());
		
		userDetailsVO.setRoles(new HashSet<PerfilVO>(PerfilAssembler.getPerfilesVO(usuario.getPerfils())));
				
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
		usuario.setIdUsuario(usuarioVO.getIdUsuario());
		usuario.setContrasenia(usuarioVO.getContrasenia());
		usuario.setCorreo(usuarioVO.getCorreo());
		usuario.setEstatusUsuario(new EstatusUsuario(usuarioVO.getIdEstatus()));
		usuario.setMaterno(usuarioVO.getMaterno());
		usuario.setPaterno(usuarioVO.getPaterno());
		usuario.setNombre(usuarioVO.getNombre());
		usuario.setFoto(null);
		usuario.setCine(new Cine(usuarioVO.getIdCine()));
		usuario.setPuntoVenta(new PuntoVenta(usuarioVO.getIdPuntoVenta()));				
		
		Set<Perfil> perfiles = new HashSet<Perfil>();
		perfiles.add(new Perfil(usuarioVO.getIdPerfil()));
		usuario.setPerfils(perfiles);
		
		return usuario;
	}
	
	public static Usuario getUsuarioActualizado(UsuarioVO usuarioVO, Usuario usuario) {

		if(usuarioVO==null)
			return null;

		//usuario.setIdUsuario(usuarioVO.getIdUsuario());
		//usuario.setContrasenia(usuarioVO.getContrasenia());
		usuario.setCorreo(usuarioVO.getCorreo());
		usuario.getEstatusUsuario().setIdEstatus(usuarioVO.getIdEstatus());
		usuario.setMaterno(usuarioVO.getMaterno());
		usuario.setPaterno(usuarioVO.getPaterno());
		usuario.setNombre(usuarioVO.getNombre());
		usuario.setFoto(null);
		usuario.setCine(new Cine(usuarioVO.getIdCine()));
		usuario.setPuntoVenta(new PuntoVenta(usuarioVO.getIdPuntoVenta()));
		
		Set<Perfil> perfiles = new HashSet<Perfil>();
		perfiles.add(new Perfil(usuarioVO.getIdPerfil()));
		usuario.setPerfils(perfiles);
		
		return usuario;
	}

}
