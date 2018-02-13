
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CambioContraseniaVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String contraseniaActual;
	private String contraseniaNueva;

	public String getContraseniaActual() {
		return contraseniaActual;
	}
	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}
	public String getContraseniaNueva() {
		return contraseniaNueva;
	}
	public void setContraseniaNueva(String contraseniaNueva) {
		this.contraseniaNueva = contraseniaNueva;
	}
	
	
}
