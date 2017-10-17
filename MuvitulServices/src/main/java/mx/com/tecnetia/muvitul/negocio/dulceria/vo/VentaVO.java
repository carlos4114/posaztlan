package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.List;

public class VentaVO {
	private Integer idUsuario;
	private Integer idPuntoVenta;
	private Integer idCine;
	private List<PaqueteVO> paquetesVO;
	private List<PagoVO> pagosVO;
	private BigDecimal total;
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
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
	public List<PaqueteVO> getPaquetesVO() {
		return paquetesVO;
	}
	public void setPaquetesVO(List<PaqueteVO> paquetesVO) {
		this.paquetesVO = paquetesVO;
	}
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	
}
