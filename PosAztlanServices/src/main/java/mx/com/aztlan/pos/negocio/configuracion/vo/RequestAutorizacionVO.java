package mx.com.aztlan.pos.negocio.configuracion.vo;

public class RequestAutorizacionVO {
	private String correo;
	private String contrasenia;
	private Integer idTipoAutorizacion;
	private String comentarios;
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Integer getIdTipoAutorizacion() {
		return idTipoAutorizacion;
	}
	public void setIdTipoAutorizacion(Integer idTipoAutorizacion) {
		this.idTipoAutorizacion = idTipoAutorizacion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
