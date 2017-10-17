package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 28-may-2017 1:06:14 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CancelacionPago generated by hbm2java
 */
@Entity
@Table(name = "cancelacion_pago", catalog = "muvitul")
public class CancelacionPago implements java.io.Serializable {

	private Integer idCancelacionPago;
	private Autorizacion autorizacion;
	private MotivoCancelacion motivoCancelacion;
	private Pago pago;
	private TicketVenta ticketVenta;
	private Usuario usuario;
	private Date fecha;
	private String comentarios;

	public CancelacionPago() {
	}

	public CancelacionPago(Autorizacion autorizacion, MotivoCancelacion motivoCancelacion, Pago pago,
			TicketVenta ticketVenta, Usuario usuario, Date fecha, String comentarios) {
		this.autorizacion = autorizacion;
		this.motivoCancelacion = motivoCancelacion;
		this.pago = pago;
		this.ticketVenta = ticketVenta;
		this.usuario = usuario;
		this.fecha = fecha;
		this.comentarios = comentarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_cancelacion_pago", unique = true, nullable = false)
	public Integer getIdCancelacionPago() {
		return this.idCancelacionPago;
	}

	public void setIdCancelacionPago(Integer idCancelacionPago) {
		this.idCancelacionPago = idCancelacionPago;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autorizacion", nullable = false)
	public Autorizacion getAutorizacion() {
		return this.autorizacion;
	}

	public void setAutorizacion(Autorizacion autorizacion) {
		this.autorizacion = autorizacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_motivo_cancelacion", nullable = false)
	public MotivoCancelacion getMotivoCancelacion() {
		return this.motivoCancelacion;
	}

	public void setMotivoCancelacion(MotivoCancelacion motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pago", nullable = false)
	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ticket_venta", nullable = false)
	public TicketVenta getTicketVenta() {
		return this.ticketVenta;
	}

	public void setTicketVenta(TicketVenta ticketVenta) {
		this.ticketVenta = ticketVenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "comentarios", nullable = false, length = 250)
	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
