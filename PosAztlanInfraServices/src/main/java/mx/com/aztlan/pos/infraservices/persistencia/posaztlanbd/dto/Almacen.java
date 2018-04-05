package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Almacen generated by hbm2java
 */
@Entity
@Table(name = "almacen", catalog = "posAztlanbd")
public class Almacen implements java.io.Serializable {

	private Integer idAlmacen;
	private Empresa empresa;
	private Canal canal;
	private String nombre;
	private TipoAlmacen tipoAlmacen;
	private Integer idAlmacenPadre;
//	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Almacen() {
	}

	public Almacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	
	public Almacen(Canal canal, String nombre, TipoAlmacen tipoAlmacen) {
		this.canal = canal;
		this.nombre = nombre;
		this.tipoAlmacen = tipoAlmacen;
	}

	public Almacen(Canal canal, String nombre, TipoAlmacen tipoAlmacen, Integer idAlmacenPadre) {
		this.canal = canal;
		this.nombre = nombre;
		this.tipoAlmacen = tipoAlmacen;
		this.idAlmacenPadre = idAlmacenPadre;
		//this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_almacen", unique = true, nullable = false)
	public Integer getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_canal", nullable = true)
	public Canal getCanal() {
		return this.canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "nombre", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_almacen", nullable = false)
	public TipoAlmacen getTipoAlmacen() {
		return this.tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacen tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	@Column(name = "id_almacen_padre")
	public Integer getIdAlmacenPadre() {
		return this.idAlmacenPadre;
	}

	public void setIdAlmacenPadre(Integer idAlmacenPadre) {
		this.idAlmacenPadre = idAlmacenPadre;
	}

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puntoVenta")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/
}
