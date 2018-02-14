package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ArticulosXProductoId generated by hbm2java
 */
@Embeddable
public class ArticulosXProductoId implements java.io.Serializable {

	private int idProducto;
	private int idArticulo;

	public ArticulosXProductoId() {
	}

	public ArticulosXProductoId(int idProducto, int idArticulo) {
		this.idProducto = idProducto;
		this.idArticulo = idArticulo;
	}

	@Column(name = "id_producto", nullable = false)
	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "id_articulo", nullable = false)
	public int getIdArticulo() {
		return this.idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ArticulosXProductoId))
			return false;
		ArticulosXProductoId castOther = (ArticulosXProductoId) other;

		return (this.getIdProducto() == castOther.getIdProducto())
				&& (this.getIdArticulo() == castOther.getIdArticulo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdProducto();
		result = 37 * result + this.getIdArticulo();
		return result;
	}

}