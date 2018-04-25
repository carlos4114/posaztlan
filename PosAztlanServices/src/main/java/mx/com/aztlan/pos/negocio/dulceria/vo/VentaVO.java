package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.List;

public class VentaVO {
	private Integer idEmpresa;
	private Integer idUsuario;
	private Integer idAlmacen;
	private Integer idCanal;
	private Integer idCaja;
	
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
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
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
	public Integer getIdCaja() {
		return idCaja;
	}
	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
