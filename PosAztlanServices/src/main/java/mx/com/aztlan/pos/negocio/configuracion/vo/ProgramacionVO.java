package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.aztlan.pos.servicios.util.DateStringToDateDeserializer;
import mx.com.aztlan.pos.servicios.util.DateToDateStringSerializer;

public class ProgramacionVO {
	private Integer idProgramacion;
	private FormatoVO formatoVO;
	private PeliculaVO peliculaVO;
	private SalaVO salaVO;
	private VersionVO versionVO;
	private String diaSemana;
	private String horario;
	private String horarioFin;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaVigencia;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaInicio;
	private boolean activo;
	private boolean nuevo;
	
	public boolean isNuevo() {
		return nuevo;
	}
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	public Integer getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public FormatoVO getFormatoVO() {
		return formatoVO;
	}
	public void setFormatoVO(FormatoVO formatoVO) {
		this.formatoVO = formatoVO;
	}
	public PeliculaVO getPeliculaVO() {
		return peliculaVO;
	}
	public void setPeliculaVO(PeliculaVO peliculaVO) {
		this.peliculaVO = peliculaVO;
	}
	public SalaVO getSalaVO() {
		return salaVO;
	}
	public void setSalaVO(SalaVO salaVO) {
		this.salaVO = salaVO;
	}
	public VersionVO getVersionVO() {
		return versionVO;
	}
	public void setVersionVO(VersionVO versionVO) {
		this.versionVO = versionVO;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
