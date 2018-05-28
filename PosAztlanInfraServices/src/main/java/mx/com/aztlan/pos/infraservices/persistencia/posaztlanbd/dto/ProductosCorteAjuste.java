package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MovimientoInventario generated by hbm2java
 */
@Entity
@Table(name = "producto_corte_ajuste", catalog = "posaztlanbd")
public class ProductosCorteAjuste implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2125072180805299682L;
	private Integer idProductoCorteAjuste;
	private ProductosCorte productoCorte;
	private MovimientoInventario movimientoInventario;
	private Usuario usuario;
	private Date fecha;
	
	
	public ProductosCorteAjuste() {
	}

	public ProductosCorteAjuste(Integer idProductoCorteAjuste, ProductosCorte productoCorte, Usuario usuario, Date fecha,
			MovimientoInventario movimientoInventario) {
		super();
		this.idProductoCorteAjuste = idProductoCorteAjuste;
		this.productoCorte = productoCorte;
		this.usuario = usuario;
		this.fecha = fecha;
		this.movimientoInventario = movimientoInventario;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProductoCorteAjuste", unique = true, nullable = false)
	public Integer getIdProductoCorteAjuste() {
		return idProductoCorteAjuste;
	}

	public void setIdProductoCorteAjuste(Integer idProductoCorteAjuste) {
		this.idProductoCorteAjuste = idProductoCorteAjuste;
	}	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto_corte", nullable = false)
	public ProductosCorte getProductoCorte() {
		return productoCorte;
	}

	public void setProductoCorte(ProductosCorte productoCorte) {
		this.productoCorte = productoCorte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_movimiento", nullable = false)
	public MovimientoInventario getMovimientoInventario() {
		return movimientoInventario;
	}

	public void setMovimientoInventario(MovimientoInventario movimientoInventario) {
		this.movimientoInventario = movimientoInventario;
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
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}