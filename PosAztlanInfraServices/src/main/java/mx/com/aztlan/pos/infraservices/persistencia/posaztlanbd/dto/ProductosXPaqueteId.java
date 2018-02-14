package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductosXPaqueteId generated by hbm2java
 */
@Embeddable
public class ProductosXPaqueteId implements java.io.Serializable {

	private int idPaquete;
	private int idProducto;

	public ProductosXPaqueteId() {
	}

	public ProductosXPaqueteId(int idPaquete, int idProducto) {
		this.idPaquete = idPaquete;
		this.idProducto = idProducto;
	}

	@Column(name = "id_paquete", nullable = false)
	public int getIdPaquete() {
		return this.idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	@Column(name = "id_producto", nullable = false)
	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductosXPaqueteId))
			return false;
		ProductosXPaqueteId castOther = (ProductosXPaqueteId) other;

		return (this.getIdPaquete() == castOther.getIdPaquete()) && (this.getIdProducto() == castOther.getIdProducto());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPaquete();
		result = 37 * result + this.getIdProducto();
		return result;
	}

}