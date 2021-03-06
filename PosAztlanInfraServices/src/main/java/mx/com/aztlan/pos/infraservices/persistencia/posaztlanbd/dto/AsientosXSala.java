package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

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
 * Articulo generated by hbm2java
 */
@Entity
@Table(name = "asientos_x_sala", catalog = "posaztlanbd")
public class AsientosXSala implements java.io.Serializable {

	private Integer idAsientosXSala;
	private Sala sala;
	private String fila;
	private Integer posicion;
	private Integer numeroAsiento;	
	private boolean existente;
	private boolean activo;
	private Date ultimaActualizacion;
	private Set<AsistenciaXSala> asistenciaXSalas = new HashSet<AsistenciaXSala>(0);

	public AsientosXSala() {
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_asientos_x_sala", unique = true, nullable = false)
	public Integer getIdAsientosXSala() {
		return this.idAsientosXSala;
	}

	public void setIdAsientosXSala(Integer idAsientosXSala) {
		this.idAsientosXSala = idAsientosXSala;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sala", nullable = false)
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Column(name = "fila", nullable = false, length = 1)
	public String getFila() {
		return this.fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}
	
	@Column(name = "posicion", nullable = false)
	public Integer getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	
	@Column(name = "numero_asiento", nullable = true)
	public Integer getNumeroAsiento() {
		return numeroAsiento;
	}
	
	public void setNumeroAsiento(Integer numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	@Column(name = "existente", nullable = false)
	public boolean isExistente() {
		return this.existente;
	}

	public void setExistente(boolean existente) {
		this.existente = existente;
	}
	
	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "asientosXSala")
	public Set<AsistenciaXSala> getAsistenciaXSalas() {
		return this.asistenciaXSalas;
	}

	public void setAsistenciaXSalas(Set<AsistenciaXSala> asistenciaXSalas) {
		this.asistenciaXSalas = asistenciaXSalas;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultima_actualizacion", nullable = false, length = 19)
	public Date getUltimaActualizacion() {
		return this.ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

}
