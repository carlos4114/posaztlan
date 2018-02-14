package mx.com.aztlan.pos.negocio.configuracion.vo;

public class TipoPromocionVO {
	private Integer idTipoPromocion;
	private String nombre;
	private String descripcion;
	private String clave;
//	private Set<Promocion> promocions = new HashSet<Promocion>(0);
	

	public Integer getIdTipoPromocion() {
		return idTipoPromocion;
	}
	public void setIdTipoPromocion(Integer idTipoPromocion) {
		this.idTipoPromocion = idTipoPromocion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
