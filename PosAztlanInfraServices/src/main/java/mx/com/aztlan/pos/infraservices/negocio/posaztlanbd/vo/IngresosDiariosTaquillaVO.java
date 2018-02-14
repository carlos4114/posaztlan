package mx.com.aztlan.pos.infraservices.negocio.posaztlanbd.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class IngresosDiariosTaquillaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cantidad;
	private BigDecimal importe;
	private BigDecimal total;
	private BigDecimal descuentos;
	private Integer promociones;
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}
	public Integer getPromociones() {
		return promociones;
	}
	public void setPromociones(Integer promociones) {
		this.promociones = promociones;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}	
	
	
}
