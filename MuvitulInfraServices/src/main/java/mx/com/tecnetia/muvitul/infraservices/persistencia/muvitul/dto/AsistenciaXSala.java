package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	
	private AsistenciaXSalaId id;
	private AsientosXSala asientosXSala;
	private Programacion programacion;
	private EstatusAsiento estatusAsiento;
	private Date fechaReserva;
	private Usuario usuario;
	private TicketVenta ticketVenta;
	
	public AsistenciaXSala() {
	}


	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idAsientosXSala", column = @Column(name = "id_asientos_x_sala", nullable = false)),
			@AttributeOverride(name = "idProgramacion", column = @Column(name = "id_programacion", nullable = false)),
			@AttributeOverride(name = "fechaExhibicion", column = @Column(name = "fecha_exhibicion", nullable = false)) })
	public AsistenciaXSalaId getId() {
		return this.id;
	}

	public void setId(AsistenciaXSalaId id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_asientos_x_sala", nullable = false, insertable = false, updatable = false)
	public AsientosXSala getAsientosXSala() {
		return this.asientosXSala;
	}

	public void setAsientosXSala(AsientosXSala asientosXSala) {
		this.asientosXSala = asientosXSala;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_programacion", nullable = false, insertable = false, updatable = false)
	public Programacion getProgramacion() {
		return this.programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ticket", nullable = false)
	public TicketVenta getTicketVenta() {
		return this.ticketVenta;
	}

	public void setTicketVenta(TicketVenta ticketVenta) {
		this.ticketVenta = ticketVenta;
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
	@Column(name = "fecha_reserva", nullable = false, length = 19)
	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
}
