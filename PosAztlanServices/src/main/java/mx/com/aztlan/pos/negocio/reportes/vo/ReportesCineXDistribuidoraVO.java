package mx.com.aztlan.pos.negocio.reportes.vo;

import java.io.Serializable;
import java.util.Date;

import mx.com.aztlan.pos.negocio.configuracion.vo.CineVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PeliculaVO;

public class ReportesCineXDistribuidoraVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idReporte;
	private CineVO cine;
	private PeliculaVO pelicula;
	private Date fechaInicio;
	private Date fechaFin;	
	private String destinatarios;
	private String asunto;
	private Integer diasPeriodo;
	private Integer diasEnvio;	
	private Date fechaEnvio;
	private String emailError;
	private boolean activo;
	private ReportesDistribuidoraVO reportesDistribuidora;
	
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public CineVO getCine() {
		return cine;
	}
	public void setCine(CineVO cine) {
		this.cine = cine;
	}
	public PeliculaVO getPelicula() {
		return pelicula;
	}
	public void setPelicula(PeliculaVO pelicula) {
		this.pelicula = pelicula;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Integer getDiasPeriodo() {
		return diasPeriodo;
	}
	public void setDiasPeriodo(Integer diasPeriodo) {
		this.diasPeriodo = diasPeriodo;
	}
	public Integer getDiasEnvio() {
		return diasEnvio;
	}
	public void setDiasEnvio(Integer diasEnvio) {
		this.diasEnvio = diasEnvio;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}	
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public ReportesDistribuidoraVO getReportesDistribuidora() {
		return reportesDistribuidora;
	}
	public void setReportesDistribuidora(ReportesDistribuidoraVO reportesDistribuidora) {
		this.reportesDistribuidora = reportesDistribuidora;
	}	
	
}
