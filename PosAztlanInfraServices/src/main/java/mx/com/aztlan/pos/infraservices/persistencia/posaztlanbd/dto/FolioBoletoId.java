package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BoletosXTicketId generated by hbm2java
 */
@Embeddable
public class FolioBoletoId implements java.io.Serializable {

	private int folio;
	private int idCine;

	public FolioBoletoId() {
	}

	public FolioBoletoId(int folio, int idCine) {
		this.folio = folio;
		this.idCine = idCine;
	}

	@Column(name = "folio", nullable = false)
	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	@Column(name = "id_cine", nullable = false)
	public int getIdCine() {
		return this.idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FolioBoletoId))
			return false;
		FolioBoletoId castOther = (FolioBoletoId) other;

		return (this.getFolio() == castOther.getFolio())
				&& (this.getIdCine() == castOther.getIdCine());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdCine();
		result = 37 * result + this.getFolio();
		return result;
	}

}
