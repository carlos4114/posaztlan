package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

public class MotivoDevolucionVO {
	private Integer idMotivoDevolucion;
	private String nombre;
	private boolean activo;
	
	public Integer getIdMotivoDevolucion() {
		return idMotivoDevolucion;
	}
	public void setIdMotivoDevolucion(Integer idMotivoDevolucion) {
		this.idMotivoDevolucion = idMotivoDevolucion;
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
