package mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller;

import org.springframework.stereotype.Component;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;

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
