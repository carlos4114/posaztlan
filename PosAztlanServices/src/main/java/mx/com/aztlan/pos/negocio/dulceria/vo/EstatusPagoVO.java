package mx.com.aztlan.pos.negocio.dulceria.vo;

public class EstatusPagoVO {
	private Integer idEstatus;
	private String nombre;
	private String clave;
	
	public EstatusPagoVO(){
		
	}
	public EstatusPagoVO(Integer idEstatus){
		this.idEstatus = idEstatus;
	}
	
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
}
