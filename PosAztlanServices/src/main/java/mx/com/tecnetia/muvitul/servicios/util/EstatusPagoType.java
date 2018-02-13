package mx.com.tecnetia.muvitul.servicios.util;

public enum EstatusPagoType {
	PAGADO("PAG-001"), DEVUELTO("DEV-002"), CANCELADO("CAN-003");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	EstatusPagoType(String type) {
		this.setType(type);
	}

}