package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

public class DistribuidoraVO {
	private Integer idDistribuidora;
	private String nombre;
	private boolean activo;
	
	public Integer getIdDistribuidora() {
		return idDistribuidora;
	}
	public void setIdDistribuidora(Integer idDistribuidora) {
		this.idDistribuidora = idDistribuidora;
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
