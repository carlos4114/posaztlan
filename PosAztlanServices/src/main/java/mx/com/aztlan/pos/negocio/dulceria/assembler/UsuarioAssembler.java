package mx.com.aztlan.pos.negocio.dulceria.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

public class UsuarioAssembler {
	
	public static Usuario getUsuario(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		
		return usuario;
	}
	
	public static mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO getUsuarioVO(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO usuarioVO = new mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO();
		usuarioVO.setIdUsuario(idUsuario);
		
		return usuarioVO;
	}
	
}