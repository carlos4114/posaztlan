package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 28-may-2017 21:38:10 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Autorizacion generated by hbm2java
 */
@Entity
@Table(name = "autorizacion", catalog = "muvitul")
public class Autorizacion implements java.io.Serializable {

	private Integer idAutorizacion;
	private TipoAutorizacion tipoAutorizacion;
	private Usuario usuario;
	private Date fecha;
	private String comentarios;
	private Set<AutorizacionMovimiento> autorizacionMovimientos = new HashSet<AutorizacionMovimiento>(0);
	private Set<CancelacionPago> cancelacionPagos = new HashSet<CancelacionPago>(0);
	private Set<Devolucion> devolucions = new HashSet<Devolucion>(0);

	public Autorizacion() {
	}

	public Autorizacion(TipoAutorizacion tipoAutorizacion, Usuario usuario, Date fecha, String comentarios) {
		this.tipoAutorizacion = tipoAutorizacion;
		this.usuario = usuario;
		this.fecha = fecha;
		this.comentarios = comentarios;
	}

	public Autorizacion(TipoAutorizacion tipoAutorizacion, Usuario usuario, Date fecha, String comentarios,
			Set<AutorizacionMovimiento> autorizacionMovimientos, Set<CancelacionPago> cancelacionPagos,
			Set<Devolucion> devolucions) {
		this.tipoAutorizacion = tipoAutorizacion;
		this.usuario = usuario;
		this.fecha = fecha;
		this.comentarios = comentarios;
		this.autorizacionMovimientos = autorizacionMovimientos;
		this.cancelacionPagos = cancelacionPagos;
		this.devolucions = devolucions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_autorizacion", unique = true, nullable = false)
	public Integer getIdAutorizacion() {
		return this.idAutorizacion;
	}

	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_autorizacion", nullable = false)
	public TipoAutorizacion getTipoAutorizacion() {
		return this.tipoAutorizacion;
	}

	public void setTipoAutorizacion(TipoAutorizacion tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autorizacion")
	public Set<AutorizacionMovimiento> getAutorizacionMovimientos() {
		return this.autorizacionMovimientos;
	}

	public void setAutorizacionMovimientos(Set<AutorizacionMovimiento> autorizacionMovimientos) {
		this.autorizacionMovimientos = autorizacionMovimientos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autorizacion")
	public Set<CancelacionPago> getCancelacionPagos() {
		return this.cancelacionPagos;
	}

	public void setCancelacionPagos(Set<CancelacionPago> cancelacionPagos) {
		this.cancelacionPagos = cancelacionPagos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autorizacion")
	public Set<Devolucion> getDevolucions() {
		return this.devolucions;
	}

	public void setDevolucions(Set<Devolucion> devolucions) {
		this.devolucions = devolucions;
	}

}
