package mx.com.aztlan.pos.negocio.cancelacion.vo;

public class MotivoCancelacionVO {
	private Integer idMotivoCancelacion;
	private String nombre;
	private boolean activo;
	
	public Integer getIdMotivoCancelacion() {
		return idMotivoCancelacion;
	}
	public void setIdMotivoCancelacion(Integer idMotivoCancelacion) {
		this.idMotivoCancelacion = idMotivoCancelacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
