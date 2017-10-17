package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
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
 * Articulo generated by hbm2java
 */
@Entity
@Table(name = "articulo", catalog = "muvitul")
public class Articulo implements java.io.Serializable {

	private Integer idArticulo;
	private Cine cine;
	private ClasificacionArt clasificacionArt;
	private UnidadMedida unidadMedida;
	private String nombre;
	private boolean activo;
	private long puntoReorden;
	private Set<ArticulosXPuntoVenta> articulosXPuntoVentas = new HashSet<ArticulosXPuntoVenta>(0);
	private Set<MovimientoInventario> movimientoInventarios = new HashSet<MovimientoInventario>(0);
	private Set<ArticulosXProducto> articulosXProductos = new HashSet<ArticulosXProducto>(0);

	public Articulo() {
	}

	public Articulo(Cine cine, ClasificacionArt clasificacionArt, UnidadMedida unidadMedida, String nombre,
			boolean activo, long puntoReorden) {
		this.cine = cine;
		this.clasificacionArt = clasificacionArt;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
		this.activo = activo;
		this.puntoReorden = puntoReorden;
	}

	public Articulo(Cine cine, ClasificacionArt clasificacionArt, UnidadMedida unidadMedida, String nombre,
			boolean activo, long puntoReorden, Set<ArticulosXPuntoVenta> articulosXPuntoVentas,
			Set<MovimientoInventario> movimientoInventarios, Set<ArticulosXProducto> articulosXProductos) {
		this.cine = cine;
		this.clasificacionArt = clasificacionArt;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
		this.activo = activo;
		this.puntoReorden = puntoReorden;
		this.articulosXPuntoVentas = articulosXPuntoVentas;
		this.movimientoInventarios = movimientoInventarios;
		this.articulosXProductos = articulosXProductos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_articulo", unique = true, nullable = false)
	public Integer getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cine", nullable = false)
	public Cine getCine() {
		return this.cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clasificacion_art", nullable = false)
	public ClasificacionArt getClasificacionArt() {
		return this.clasificacionArt;
	}

	public void setClasificacionArt(ClasificacionArt clasificacionArt) {
		this.clasificacionArt = clasificacionArt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad_medida", nullable = false)
	public UnidadMedida getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Column(name = "nombre", nullable = false, length = 200)
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

	@Column(name = "punto_reorden", nullable = false)
	public long getPuntoReorden() {
		return this.puntoReorden;
	}

	public void setPuntoReorden(long puntoReorden) {
		this.puntoReorden = puntoReorden;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public Set<ArticulosXPuntoVenta> getArticulosXPuntoVentas() {
		return this.articulosXPuntoVentas;
	}

	public void setArticulosXPuntoVentas(Set<ArticulosXPuntoVenta> articulosXPuntoVentas) {
		this.articulosXPuntoVentas = articulosXPuntoVentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public Set<MovimientoInventario> getMovimientoInventarios() {
		return this.movimientoInventarios;
	}

	public void setMovimientoInventarios(Set<MovimientoInventario> movimientoInventarios) {
		this.movimientoInventarios = movimientoInventarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	public Set<ArticulosXProducto> getArticulosXProductos() {
		return this.articulosXProductos;
	}

	public void setArticulosXProductos(Set<ArticulosXProducto> articulosXProductos) {
		this.articulosXProductos = articulosXProductos;
	}

}
