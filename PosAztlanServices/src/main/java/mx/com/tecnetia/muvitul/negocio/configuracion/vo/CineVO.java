package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class CineVO {
	private Integer idCine;
	private String nombre;
	private boolean activo;
	private boolean cineUsuario;
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCineUsuario() {
		return cineUsuario;
	}
	public void setCineUsuario(boolean cineUsuario) {
		this.cineUsuario = cineUsuario;
	}
}
