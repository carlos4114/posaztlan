package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import mx.com.tecnetia.muvitul.servicios.util.Constantes;

public class DevolucionVO {
	private Integer idDevolucion;
	private AutorizacionVO autorizacionVO;
	private MotivoDevolucionVO motivoDevolucionVO;
//	private TicketVenta ticketVenta;
	private TipoDevolucionVO tipoDevolucionVO;
//	private Usuario usuario;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern=Constantes.FORMAT_DD_MM_YYYY_HH_MM_SS)
	private Date fechaHora;
	private Integer folio;
	private String comentarios;
	
	public Integer getIdDevolucion() {
		return idDevolucion;
	}
	public void setIdDevolucion(Integer idDevolucion) {
		this.idDevolucion = idDevolucion;
	}
	public AutorizacionVO getAutorizacionVO() {
		return autorizacionVO;
	}
	public void setAutorizacionVO(AutorizacionVO autorizacionVO) {
		this.autorizacionVO = autorizacionVO;
	}
	public MotivoDevolucionVO getMotivoDevolucionVO() {
		return motivoDevolucionVO;
	}
	public void setMotivoDevolucionVO(MotivoDevolucionVO motivoDevolucionVO) {
		this.motivoDevolucionVO = motivoDevolucionVO;
	}
	public TipoDevolucionVO getTipoDevolucionVO() {
		return tipoDevolucionVO;
	}
	public void setTipoDevolucionVO(TipoDevolucionVO tipoDevolucionVO) {
		this.tipoDevolucionVO = tipoDevolucionVO;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
