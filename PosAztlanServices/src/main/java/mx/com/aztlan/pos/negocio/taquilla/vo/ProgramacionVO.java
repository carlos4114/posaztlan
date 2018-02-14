package mx.com.aztlan.pos.negocio.taquilla.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.aztlan.pos.servicios.util.DateStringToDateDeserializer;
import mx.com.aztlan.pos.servicios.util.DateToDateStringSerializer;
import mx.com.aztlan.pos.servicios.util.DateToTimeSerializer;
import mx.com.aztlan.pos.servicios.util.TimeToDateDeserializer;

public class ProgramacionVO {
	private Integer idProgramacion;
	private FormatoVO formatoVO;
//	private Pelicula pelicula;
	private SalaVO salaVO;
	private VersionVO versionVO;
	private String diaSemana;
	@JsonDeserialize(using = TimeToDateDeserializer.class)
	@JsonSerialize(using = DateToTimeSerializer.class)
	private Date horario;
	@JsonDeserialize(using = DateStringToDateDeserializer.class)
	@JsonSerialize(using = DateToDateStringSerializer.class)
	private Date fechaVigencia;
	private boolean activo;

	/**Addicional**/
	private ExistenciaBoletoVO existenciaBoletoVO;
//	private Set<ExistenciaBoletos> existenciaBoletoses = new HashSet<ExistenciaBoletos>(0);
//	private Set<BoletosXTicket> boletosXTickets = new HashSet<BoletosXTicket>(0);
	
	public ExistenciaBoletoVO getExistenciaBoletoVO() {
		return existenciaBoletoVO;
	}
	public void setExistenciaBoletoVO(ExistenciaBoletoVO existenciaBoletoVO) {
		this.existenciaBoletoVO = existenciaBoletoVO;
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
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
