package mx.com.aztlan.pos.negocio.dashboard.vo;

import java.math.BigDecimal;
import java.util.List;

public class IngresoPeliculaVO {
	private String descripcion;
	private List<BigDecimal> totales;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<BigDecimal> getTotales() {
		return totales;
	}
	public void setTotales(List<BigDecimal> totales) {
		this.totales = totales;
	}
	
	
}
