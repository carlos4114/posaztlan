package mx.com.tecnetia.muvitul.servicios.util;

public enum EstadoProductoType {
	BUENO("BUE-001"), DANIADO("DAN-002");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	EstadoProductoType(String type) {
		this.setType(type);
	}

}