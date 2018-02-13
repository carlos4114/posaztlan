package mx.com.tecnetia.muvitul.negocio.cancelacion.vo;

import java.util.List;

public class CancelacionPagoVO {
	private Integer idCancelacionPago;
	private Integer idAutorizacion;
	private Integer idTicketVenta;
	private MotivoCancelacionVO motivoCancelacionVO;
	private List<PagoVO> pagosVO;
	private String comentarios;
	
	public Integer getIdCancelacionPago() {
		return idCancelacionPago;
	}
	public void setIdCancelacionPago(Integer idCancelacionPago) {
		this.idCancelacionPago = idCancelacionPago;
	}
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public Integer getIdTicketVenta() {
		return idTicketVenta;
	}
	public void setIdTicketVenta(Integer idTicketVenta) {
		this.idTicketVenta = idTicketVenta;
	}
	public MotivoCancelacionVO getMotivoCancelacionVO() {
		return motivoCancelacionVO;
	}
	public void setMotivoCancelacionVO(MotivoCancelacionVO motivoCancelacionVO) {
		this.motivoCancelacionVO = motivoCancelacionVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
