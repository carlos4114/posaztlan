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
 * Marca generated by hbm2java
 */
@Entity
@Table(name = "marca", catalog = "posAztlanbd")
public class Marca implements java.io.Serializable {

	private Integer idMarca;
	private String nombre;
	private Empresa empresa;
	private boolean activo;

	public Marca() {
	}

	public Marca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	
	public Marca(String nombre, Empresa empresa, boolean activo) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.activo = activo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_marca", unique = true, nullable = false)
	public Integer getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
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
