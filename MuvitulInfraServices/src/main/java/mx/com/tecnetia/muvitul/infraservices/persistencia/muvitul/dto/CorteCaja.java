package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
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
 * PuntoVenta generated by hbm2java
 */
@Entity
@Table(name = "corte_caja", catalog = "muvitul")
public class CorteCaja implements java.io.Serializable {

	private Integer idCorteCaja;
	private Autorizacion autorizacion;
	private Caja caja;
	private Usuario usuario;
	private Date fecha;
	private BigDecimal efectivoReal;
	private BigDecimal efectivoSistema;
	private String comentarios;
	private CargoAjuste cargoAjuste;
	private BigDecimal entradaCaja;
	
	public CorteCaja() {
	}
	
	public CorteCaja(Integer idCorteCaja) {
		this.idCorteCaja = idCorteCaja;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_corte_caja", unique = true, nullable = false)
	public Integer getIdCorteCaja() {
		return this.idCorteCaja;
	}

	public void setIdCorteCaja(Integer idCorteCaja) {
		this.idCorteCaja = idCorteCaja;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autorizacion", nullable = true)
	public Autorizacion getAutorizacion() {
		return this.autorizacion;
	}

	public void setAutorizacion(Autorizacion autorizacion) {
		this.autorizacion = autorizacion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_caja", nullable = false)
	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
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
	@JoinColumn(name = "id_cargo_ajuste", nullable = true)
	public CargoAjuste getCargoAjuste() {
		return this.cargoAjuste;
	}

	public void setCargoAjuste(CargoAjuste cargoAjuste) {
		this.cargoAjuste = cargoAjuste;
	}

	@Column(name = "comentarios", nullable = false, length = 250)
	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}	
	
	@Column(name = "efectivo_real", nullable = false, precision = 15)
	public BigDecimal getEfectivoReal() {
		return this.efectivoReal;
	}

	public void setEfectivoReal(BigDecimal efectivoReal) {
		this.efectivoReal = efectivoReal;
	}
	
	@Column(name = "efectivo_sistema", nullable = false, precision = 15)
	public BigDecimal getEfectivoSistema() {
		return this.efectivoSistema;
	}

	public void setEfectivoSistema(BigDecimal efectivoSistema) {
		this.efectivoSistema = efectivoSistema;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "entrada_caja", nullable = false, precision = 15)
	public BigDecimal getEntradaCaja() {
		return this.entradaCaja;
	}

	public void setEntradaCaja(BigDecimal entradaCaja) {
		this.entradaCaja = entradaCaja;
	}
	
}
