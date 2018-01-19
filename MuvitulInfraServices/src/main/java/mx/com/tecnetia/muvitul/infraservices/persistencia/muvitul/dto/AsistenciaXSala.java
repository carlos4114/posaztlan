package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Articulo generated by hbm2java
 */
@Entity
@Table(name = "asistencia_x_sala", catalog = "muvitul")
public class AsistenciaXSala implements java.io.Serializable {

	private AsientosXSala asientosXSala;
	private Programacion programacion;
	private EstatusAsiento estatusAsiento;
	private Date fechaExhibicion;
	private Date fechaReserva;
	
	public AsistenciaXSala() {
	}



	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_asientos_x_sala",unique = true, nullable = false)
	public AsientosXSala getAsientosXSala() {
		return this.asientosXSala;
	}

	public void setAsientosXSala(AsientosXSala asientosXSala) {
		this.asientosXSala = asientosXSala;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_programacion", nullable = false)
	public Programacion getProgramacion() {
		return this.programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus_asiento", nullable = false)
	public EstatusAsiento getEstatusAsiento() {
		return this.estatusAsiento;
	}

	public void setEstatusAsiento(EstatusAsiento estatusAsiento) {
		this.estatusAsiento = estatusAsiento;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_exhibicion", nullable = false, length = 10)
	public Date getFechaExhibicion() {
		return this.fechaExhibicion;
	}

	public void setFechaExhibicion(Date fechaExhibicion) {
		this.fechaExhibicion = fechaExhibicion;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_reserva", nullable = false, length = 19)
	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
}