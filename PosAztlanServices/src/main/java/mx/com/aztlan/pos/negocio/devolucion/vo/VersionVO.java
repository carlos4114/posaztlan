package mx.com.aztlan.pos.negocio.devolucion.vo;

public class VersionVO {
	private Integer idVersion;
	private String nombre;
	private boolean activo;
//	private Set<Programacion> programacions = new HashSet<Programacion>(0);
	
	public Integer getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(Integer idVersion) {
		this.idVersion = idVersion;
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
