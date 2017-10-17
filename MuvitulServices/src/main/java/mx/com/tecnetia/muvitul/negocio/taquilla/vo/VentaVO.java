package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.util.List;

public class VentaVO {
	private Integer idUsuario;
	private Integer idPuntoVenta;
	private Integer idCine;
	private List<BoletoXTicketVO> boletosXTicketVO;
	private List<PromocionXTicketVO> promocionesXTicketVO;
	private List<PagoVO> pagosVO;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdPuntoVenta() {
		return idPuntoVenta;
	}
	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public List<BoletoXTicketVO> getBoletosXTicketVO() {
		return boletosXTicketVO;
	}
	public void setBoletosXTicketVO(List<BoletoXTicketVO> boletosXTicketVO) {
		this.boletosXTicketVO = boletosXTicketVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	public List<PromocionXTicketVO> getPromocionesXTicketVO() {
		return promocionesXTicketVO;
	}
	public void setPromocionesXTicketVO(List<PromocionXTicketVO> promocionesXTicketVO) {
		this.promocionesXTicketVO = promocionesXTicketVO;
	}
}
