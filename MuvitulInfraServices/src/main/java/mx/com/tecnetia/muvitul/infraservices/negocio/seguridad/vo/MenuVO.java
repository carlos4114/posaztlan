
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MenuVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMenu;
	private Integer idRecurso;
	private Integer idRecursoPadre;
	private String icono; 
	
	public Integer getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	public Integer getIdRecurso() {
		return idRecurso;
	}
	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}
	public Integer getIdRecursoPadre() {
		return idRecursoPadre;
	}
	public void setIdRecursoPadre(Integer idRecursoPadre) {
		this.idRecursoPadre = idRecursoPadre;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
		
}
