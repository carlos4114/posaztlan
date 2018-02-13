package mx.com.tecnetia.muvitul.negocio.dashboard.vo;

import java.math.BigDecimal;
import java.util.List;

public class AsistenciaGraficaVO {
	private List<String> dias;
	private List<BigDecimal> totales;
	
	
	public List<String> getDias() {
		return dias;
	}
	public void setDias(List<String> dias) {
		this.dias = dias;
	}
	public List<BigDecimal> getTotales() {
		return totales;
	}
	public void setTotales(List<BigDecimal> totales) {
		this.totales = totales;
	}
	
}
