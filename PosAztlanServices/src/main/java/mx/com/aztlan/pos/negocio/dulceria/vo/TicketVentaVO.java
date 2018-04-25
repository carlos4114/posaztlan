package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;

public class TicketVentaVO {
	private Integer idTicket;
	private Integer idCaja;
	private AlmacenVO almacenVO;
	private UsuarioVO usuarioVO;
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal total;
	
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public AlmacenVO getAlmacenVO() {
		return almacenVO;
	}
	public void setAlmacenVO(AlmacenVO almacenVO) {
		this.almacenVO = almacenVO;
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
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getIdCaja() {
		return idCaja;
	}
	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}
	
}
