package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
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
@Table(name = "productos_x_punto_venta", catalog = "muvitul")
public class ProductosXPuntoVenta implements java.io.Serializable {

	private ProductosXPuntoVentaId id;
	private Producto producto;
	private PuntoVenta puntoVenta;

	public ProductosXPuntoVenta() {
	}

	public ProductosXPuntoVenta(ProductosXPuntoVentaId id, Producto producto, PuntoVenta puntoVenta) {
		this.id = id;
		this.producto = producto;
		this.puntoVenta = puntoVenta;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idPuntoVenta", column = @Column(name = "id_punto_venta", nullable = false)),
			@AttributeOverride(name = "idProducto", column = @Column(name = "id_producto", nullable = false)) })
	public ProductosXPuntoVentaId getId() {
		return this.id;
	}

	public void setId(ProductosXPuntoVentaId id) {
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
	@JoinColumn(name = "id_punto_venta", nullable = false, insertable = false, updatable = false)
	public PuntoVenta getPuntoVenta() {
		return this.puntoVenta;
	}

	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}

}
