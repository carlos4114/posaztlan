package mx.com.aztlan.pos.negocio.taquilla.vo;

import java.util.List;

import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;

public class VentaVO {
	private Integer idUsuario;
	private Integer idPuntoVenta;
	private Integer idCine;
	private Integer idCaja;
	private List<BoletoXTicketVO> boletosXTicketVO;
	private List<PromocionXTicketVO> promocionesXTicketVO;
	private List<PagoVO> pagosVO;
	private List<List<AsientoVO>> asientos;
	
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
	public Integer getIdCaja() {
		return idCaja;
	}
	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}
	public List<List<AsientoVO>> getAsientos() {
		return asientos;
	}
	public void setAsientos(List<List<AsientoVO>> asientos) {
		this.asientos = asientos;
	}
	
}
