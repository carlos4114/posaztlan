package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 23/02/2018 09:54:46 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Medida generated by hbm2java
 */
@Entity
@Table(name = "medida", catalog = "posAztlanbd")
public class Medida implements java.io.Serializable {

	private Integer idMedida;
	private String nombre;
	private Empresa empresa;
	private boolean activo;

	public Medida() {
	}

	public Medida(Integer idMedida) {
		this.idMedida = idMedida;
	}
	public Medida(String nombre, Empresa empresa, boolean activo) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.activo = activo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_medida", unique = true, nullable = false)
	public Integer getIdMedida() {
		return this.idMedida;
	}

	public void setIdMedida(Integer idMedida) {
		this.idMedida = idMedida;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
