
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PerfilVO implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	private Integer idPerfil;
	private String nombre;	
	
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAuthority() {
		return nombre;
	}
	
}
