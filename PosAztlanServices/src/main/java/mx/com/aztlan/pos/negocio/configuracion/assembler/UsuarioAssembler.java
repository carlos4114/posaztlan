package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

public class UsuarioAssembler {
	
	public static Usuario getUsuario(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		
		return usuario;
	}
	

}