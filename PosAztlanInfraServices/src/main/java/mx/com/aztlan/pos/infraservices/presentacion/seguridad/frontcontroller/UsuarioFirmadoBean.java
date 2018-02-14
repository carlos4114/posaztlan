package mx.com.aztlan.pos.infraservices.presentacion.seguridad.frontcontroller;

import org.springframework.stereotype.Component;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;

@Component
 public class UsuarioFirmadoBean  {
	private UsuarioFirmadoVO usuario;

	public UsuarioFirmadoVO getUser() {
		return usuario;
	}

	public void setUser(UsuarioFirmadoVO usuario) {
		this.usuario = usuario;
	}
	 
	
}
