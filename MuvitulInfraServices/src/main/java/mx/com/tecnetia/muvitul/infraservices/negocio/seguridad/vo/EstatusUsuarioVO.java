
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EstatusUsuarioVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String nombre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
