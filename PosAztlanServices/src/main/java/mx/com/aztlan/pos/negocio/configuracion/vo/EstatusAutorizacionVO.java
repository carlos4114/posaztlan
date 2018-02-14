package mx.com.aztlan.pos.negocio.configuracion.vo;

public class EstatusAutorizacionVO {
	private Integer idAutorizacion;
	private int status;
	private String descripcion;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
}
