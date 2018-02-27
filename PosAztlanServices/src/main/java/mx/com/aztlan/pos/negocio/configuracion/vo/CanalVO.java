package mx.com.aztlan.pos.negocio.configuracion.vo;

public class CanalVO {
	private Integer idCanal;
	private String nombre;
	private boolean activo;
	private boolean canalUsuario;
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
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
	public boolean isCanalUsuario() {
		return canalUsuario;
	}
	public void setCanalUsuario(boolean canalUsuario) {
		this.canalUsuario = canalUsuario;
	}
	
	
}
