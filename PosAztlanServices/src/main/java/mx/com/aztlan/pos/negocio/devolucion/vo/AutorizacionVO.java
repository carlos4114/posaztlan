package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.util.Date;

public class AutorizacionVO {
	private Integer idAutorizacion;
	private TipoAutorizacionVO tipoAutorizacionVO;
	private UsuarioVO usuarioVO;
	private Date fecha;
	private String comentarios;
	
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public TipoAutorizacionVO getTipoAutorizacionVO() {
		return tipoAutorizacionVO;
	}
	public void setTipoAutorizacionVO(TipoAutorizacionVO tipoAutorizacionVO) {
		this.tipoAutorizacionVO = tipoAutorizacionVO;
	}
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
