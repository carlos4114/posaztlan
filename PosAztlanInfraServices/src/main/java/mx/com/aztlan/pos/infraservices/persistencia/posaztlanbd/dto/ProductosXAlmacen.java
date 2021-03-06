package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductosXPuntoVenta generated by hbm2java
 */
@Entity
@Table(name = "productos_x_punto_venta", catalog = "posaztlanbd")
public class ProductosXAlmacen implements java.io.Serializable {

	private ProductosXAlmacenId id;
	private Producto producto;
	private Almacen almacen;

	public ProductosXAlmacen() {
	}

	public ProductosXAlmacen(ProductosXAlmacenId id, Producto producto, Almacen almacen) {
		this.id = id;
		this.producto = producto;
		this.almacen = almacen;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idAlmacen", column = @Column(name = "id_almacen", nullable = false)),
			@AttributeOverride(name = "idProducto", column = @Column(name = "id_producto", nullable = false)) })
	public ProductosXAlmacenId getId() {
		return this.id;
	}

	public void setId(ProductosXAlmacenId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false, insertable = false, updatable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_almacen", nullable = false, insertable = false, updatable = false)
	public Almacen getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

}
