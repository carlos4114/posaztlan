package mx.com.aztlan.pos.infraservices.negocio.posaztlanbd.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class IngresosDulceriaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String puntoVenta;
	private String producto;
	private BigDecimal precio;
	private Integer cantidad;
	private BigDecimal total;
	public String getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(String puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
}
