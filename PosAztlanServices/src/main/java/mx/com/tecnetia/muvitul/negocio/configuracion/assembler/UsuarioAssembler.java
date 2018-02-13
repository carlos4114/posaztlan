package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public class UsuarioAssembler {
	
	public static Usuario getUsuario(Integer idUsuario){

		if(idUsuario==null)
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		
		return usuario;
	}
	

}