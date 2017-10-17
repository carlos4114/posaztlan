package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.tecnetia.muvitul.servicios.util.DateStringToDateDeserializer;
import mx.com.tecnetia.muvitul.servicios.util.DateToDateStringSerializer;

public class TicketVentaProductoVO {
	private Integer idTicket;
	private PuntoVentaVO puntoVentaVO;
	private UsuarioVO usuarioVO;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fecha;
	private BigDecimal descuento;
	private BigDecimal importe;
	private BigDecimal total;
	private List<PaqueteXTicketVO> paquetesXTicketVO;
	private List<ProductoXTicketVO> productosXTicketVO;
	private List<PagoVO> pagosVO;
	private BigDecimal subtotal;
	
	private List <DevolucionVO> devolucionesVO;
	
	public List<DevolucionVO> getDevolucionesVO() {
		return devolucionesVO;
	}
	public void setDevolucionesVO(List<DevolucionVO> devolucionesVO) {
		this.devolucionesVO = devolucionesVO;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public List<PaqueteXTicketVO> getPaquetesXTicketVO() {
		return paquetesXTicketVO;
	}
	public void setPaquetesXTicketVO(List<PaqueteXTicketVO> paquetesXTicketVO) {
		this.paquetesXTicketVO = paquetesXTicketVO;
	}
	public List<ProductoXTicketVO> getProductosXTicketVO() {
		return productosXTicketVO;
	}
	public void setProductosXTicketVO(List<ProductoXTicketVO> productosXTicketVO) {
		this.productosXTicketVO = productosXTicketVO;
	}
	public Integer getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
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
	public List<PagoVO> getPagosVO() {
		return pagosVO;
	}
	public void setPagosVO(List<PagoVO> pagosVO) {
		this.pagosVO = pagosVO;
	}
	
}
