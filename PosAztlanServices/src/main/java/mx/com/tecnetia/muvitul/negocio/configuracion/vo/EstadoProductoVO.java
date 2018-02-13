package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class EstadoProductoVO {
	private Integer idEstadoProducto;
	private String nombre;
	private boolean activo;
	private String clave;
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getIdEstadoProducto() {
		return idEstadoProducto;
	}
	public void setIdEstadoProducto(Integer idEstadoProducto) {
		this.idEstadoProducto = idEstadoProducto;
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
