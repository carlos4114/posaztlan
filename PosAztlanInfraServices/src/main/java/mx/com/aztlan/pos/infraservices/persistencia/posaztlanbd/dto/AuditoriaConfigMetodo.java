package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuditoriaConfigMetodo generated by hbm2java
 */
@Entity
@Table(name = "auditoria_config_metodo", catalog = "posaztlanbd")
public class AuditoriaConfigMetodo implements java.io.Serializable {

	private int idMetodo;
	private String nombre;
	private String descripcion;
	private boolean activo;
	private Date fechaModificacion;
	private Set<AuditoriaConfigAtributo> auditoriaConfigAtributos = new HashSet<AuditoriaConfigAtributo>(0);

	public AuditoriaConfigMetodo() {
	}

	public AuditoriaConfigMetodo(int idMetodo, String nombre, String descripcion, boolean activo,
			Date fechaModificacion) {
		this.idMetodo = idMetodo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.fechaModificacion = fechaModificacion;
	}

	public AuditoriaConfigMetodo(int idMetodo, String nombre, String descripcion, boolean activo,
			Date fechaModificacion, Set<AuditoriaConfigAtributo> auditoriaConfigAtributos) {
		this.idMetodo = idMetodo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.fechaModificacion = fechaModificacion;
		this.auditoriaConfigAtributos = auditoriaConfigAtributos;
	}

	@Id

	@Column(name = "id_metodo", unique = true, nullable = false)
	public int getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(int idMetodo) {
		this.idMetodo = idMetodo;
	}

	@Column(name = "nombre", nullable = false, length = 150)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false, length = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", nullable = false, length = 19)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auditoriaConfigMetodo")
	public Set<AuditoriaConfigAtributo> getAuditoriaConfigAtributos() {
		return this.auditoriaConfigAtributos;
	}

	public void setAuditoriaConfigAtributos(Set<AuditoriaConfigAtributo> auditoriaConfigAtributos) {
		this.auditoriaConfigAtributos = auditoriaConfigAtributos;
	}

}
