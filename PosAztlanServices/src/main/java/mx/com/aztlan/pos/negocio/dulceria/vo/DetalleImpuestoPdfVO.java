package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;

public class DetalleImpuestoPdfVO {
	private String concepto;
	private BigDecimal cantidad;
	
	public DetalleImpuestoPdfVO() {
	}
	
	public String getConcepto() {
		return concepto;
	}
	
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	public BigDecimal getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
}
