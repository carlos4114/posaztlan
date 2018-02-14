package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class IngresoVO implements Serializable {
	private String agrupador;
	private BigDecimal total;
	
	public String getAgrupador() {
		return agrupador;
	}
	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
