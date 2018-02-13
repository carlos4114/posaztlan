
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OpcionMenuVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String liga;
	private String nombre;
	private String icono;
	private List<OpcionMenuVO> submenus;
	
	public OpcionMenuVO(Integer id, String liga, String nombre, String icono, List<OpcionMenuVO> submenus){
		this.id = id;
		this.liga = liga;
		this.nombre= nombre;
		this.icono = icono;
		this.submenus = submenus;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLiga() {
		return liga;
	}
	public void setLiga(String liga) {
		this.liga = liga;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public List<OpcionMenuVO> getSubmenus() {
		return submenus;
	}
	public void setSubmenus(List<OpcionMenuVO> submenus) {
		this.submenus = submenus;
	}
	
	
}
