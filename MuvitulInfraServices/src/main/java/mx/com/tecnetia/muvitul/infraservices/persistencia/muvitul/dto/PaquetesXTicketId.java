package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto;
// Generated 14-abr-2017 14:25:39 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PaquetesXTicketId generated by hbm2java
 */
@Embeddable
public class PaquetesXTicketId implements java.io.Serializable {

	private int idTicket;
	private int idPaquete;

	public PaquetesXTicketId() {
	}

	public PaquetesXTicketId(int idTicket, int idPaquete) {
		this.idTicket = idTicket;
		this.idPaquete = idPaquete;
	}

	@Column(name = "id_ticket", nullable = false)
	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	@Column(name = "id_paquete", nullable = false)
	public int getIdPaquete() {
		return this.idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaquetesXTicketId))
			return false;
		PaquetesXTicketId castOther = (PaquetesXTicketId) other;

		return (this.getIdTicket() == castOther.getIdTicket()) && (this.getIdPaquete() == castOther.getIdPaquete());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdTicket();
		result = 37 * result + this.getIdPaquete();
		return result;
	}

}