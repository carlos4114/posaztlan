package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

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

/**
 * Cine generated by hbm2java
 */
@Entity
@Table(name = "cine", catalog = "posaztlanbd")
public class Cine implements java.io.Serializable {

	private Integer idCine;
	private Contacto contacto;
	private Empresa empresa;
	private String nombre;
	private boolean activo;
	private Set<ClasificacionArt> clasificacionArts = new HashSet<ClasificacionArt>(0);
	private Set<Articulo> articulos = new HashSet<Articulo>(0);
	private Set<Sala> salas = new HashSet<Sala>(0);
	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);
	private Set<Formato> formatos = new HashSet<Formato>(0);
	//private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<Proveedor> proveedors = new HashSet<Proveedor>(0);
	private Set<Promocion> promocions = new HashSet<Promocion>(0);
	private Set<Pelicula> peliculas = new HashSet<Pelicula>(0);
	private Set<MateriaPrima> materiaPrimas = new HashSet<MateriaPrima>(0);
	private Set<Regalo> regalos = new HashSet<Regalo>(0);
	private Set<Paquete> paquetes = new HashSet<Paquete>(0);
	private Set<ImpuestoBoleto> impuestoBoletos = new HashSet<ImpuestoBoleto>(0);
	//private Set<ImpuestoXProducto> impuestoXProductos = new HashSet<ImpuestoXProducto>(0);
	//private Set<Producto> productos = new HashSet<Producto>(0);

	public Cine() {
	}

	public Cine(Integer idCine) {
		this.idCine = idCine;
	}
	public Cine(Contacto contacto, Empresa empresa, String nombre, boolean activo) {
		this.contacto = contacto;
		this.empresa = empresa;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Cine(Contacto contacto, Empresa empresa, String nombre, boolean activo,
			Set<ClasificacionArt> clasificacionArts, Set<Articulo> articulos, Set<Sala> salas,
			Set<PuntoVenta> puntoVentas, Set<Formato> formatos, Set<Usuario> usuarios, Set<Proveedor> proveedors,
			Set<Promocion> promocions, Set<Pelicula> peliculas, Set<MateriaPrima> materiaPrimas, Set<Regalo> regalos,
			Set<Paquete> paquetes, Set<ImpuestoBoleto> impuestoBoletos) {
		this.contacto = contacto;
		this.empresa = empresa;
		this.nombre = nombre;
		this.activo = activo;
		this.clasificacionArts = clasificacionArts;
		this.articulos = articulos;
		this.salas = salas;
		this.puntoVentas = puntoVentas;
		this.formatos = formatos;
		//this.usuarios = usuarios;
		this.proveedors = proveedors;
		this.promocions = promocions;
		this.peliculas = peliculas;
		this.materiaPrimas = materiaPrimas;
		this.regalos = regalos;
		this.paquetes = paquetes;
		this.impuestoBoletos = impuestoBoletos;
	//	this.impuestoXProductos = impuestoXProductos;
		//this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_cine", unique = true, nullable = false)
	public Integer getIdCine() {
		return this.idCine;
	}

	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contacto", nullable = false)
	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<ClasificacionArt> getClasificacionArts() {
		return this.clasificacionArts;
	}

	public void setClasificacionArts(Set<ClasificacionArt> clasificacionArts) {
		this.clasificacionArts = clasificacionArts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<PuntoVenta> getPuntoVentas() {
		return this.puntoVentas;
	}

	public void setPuntoVentas(Set<PuntoVenta> puntoVentas) {
		this.puntoVentas = puntoVentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Formato> getFormatos() {
		return this.formatos;
	}

	public void setFormatos(Set<Formato> formatos) {
		this.formatos = formatos;
	}

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Proveedor> getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(Set<Proveedor> proveedors) {
		this.proveedors = proveedors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Promocion> getPromocions() {
		return this.promocions;
	}

	public void setPromocions(Set<Promocion> promocions) {
		this.promocions = promocions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<MateriaPrima> getMateriaPrimas() {
		return this.materiaPrimas;
	}

	public void setMateriaPrimas(Set<MateriaPrima> materiaPrimas) {
		this.materiaPrimas = materiaPrimas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Regalo> getRegalos() {
		return this.regalos;
	}

	public void setRegalos(Set<Regalo> regalos) {
		this.regalos = regalos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<ImpuestoBoleto> getImpuestoBoletos() {
		return this.impuestoBoletos;
	}

	public void setImpuestoBoletos(Set<ImpuestoBoleto> impuestoBoletos) {
		this.impuestoBoletos = impuestoBoletos;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<ImpuestoXProducto> getImpuestoXProductos() {
		return this.impuestoXProductos;
	}

	public void setImpuestoXProductos(Set<ImpuestoXProducto> impuestoXProductos) {
		this.impuestoXProductos = impuestoXProductos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cine")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}*/

}
