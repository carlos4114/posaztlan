package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

public class TipoAutorizacionVO {
	private Integer idTipoAutorizacion;
	private String nombre;
	private boolean activo;
	
	public Integer getIdTipoAutorizacion() {
		return idTipoAutorizacion;
	}
	public void setIdTipoAutorizacion(Integer idTipoAutorizacion) {
		this.idTipoAutorizacion = idTipoAutorizacion;
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
