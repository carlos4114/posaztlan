package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.io.Serializable;
import java.math.BigDecimal;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;


public class ProductoCostoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Producto producto;
	private TicketVenta ticketVenta;
	private int cantidad;
	private BigDecimal importe;
	private BigDecimal unidadXTicket;

	public ProductoCostoVO() {
	}


	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public TicketVenta getTicketVenta() {
		return this.ticketVenta;
	}

	public void setTicketVenta(TicketVenta ticketVenta) {
		this.ticketVenta = ticketVenta;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public BigDecimal getUnidadXTicket() {
		return unidadXTicket;
	}

	public void setUnidadXTicket(BigDecimal unidadXTicket) {
		this.unidadXTicket = unidadXTicket;
	}

}
