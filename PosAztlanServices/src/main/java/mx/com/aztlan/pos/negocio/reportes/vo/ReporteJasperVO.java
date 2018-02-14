package mx.com.aztlan.pos.negocio.reportes.vo;

import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteJasperVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private HashMap<String,Object> parametros;
	private String rutaReporte;
	private String rutaPdf;
	private String rutaXls;
	
	public HashMap<String, Object> getParametros() {
		return parametros;
	}
	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}
	public String getRutaReporte() {
		return rutaReporte;
	}
	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = rutaReporte;
	}
	public String getRutaPdf() {
		return rutaPdf;
	}
	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}
	public String getRutaXls() {
		return rutaXls;
	}
	public void setRutaXls(String rutaXls) {
		this.rutaXls = rutaXls;
	}

	
}
