package mx.com.aztlan.pos.negocio.dashboard.vo;

import java.util.List;

public class RentabilidadGraficaVO {
	private List<String> fechas;
	private List<RentabilidadVO> totales;
	
	
	public List<String> getFechas() {
		return fechas;
	}
	public void setFechas(List<String> fechas) {
		this.fechas = fechas;
	}
	public List<RentabilidadVO> getTotales() {
		return totales;
	}
	public void setTotales(List<RentabilidadVO> totales) {
		this.totales = totales;
	}
	
}
