
package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.PerfilVO;

@Component
@Scope("prototype")
public class RecursoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idRecurso;
	private String nombre;
	private String url;
	private Boolean permitirATodos;
	private Boolean activo;
	
	private List<PerfilVO> perfilesVO;
	
	public RecursoVO(){
		
	}
	public RecursoVO(String url){
		this.url = url;
	}
	
	public Integer getIdRecurso() {
		return idRecurso;
	}
	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getPermitirATodos() {
		return permitirATodos;
	}
	public void setPermitirATodos(Boolean permitirATodos) {
		this.permitirATodos = permitirATodos;
	}
	public List<PerfilVO> getPerfilesVO() {
		return perfilesVO;
	}
	public void setPerfilesVO(List<PerfilVO> perfilesVO) {
		this.perfilesVO = perfilesVO;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
