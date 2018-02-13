package mx.com.tecnetia.muvitul.servicios.util;

public enum PuntoVentaType {
	TAQUILLA("TAQ-002"), DULCERIA("DUL-001"), TAQUILLA_DULCERIA("TAQDUL-003");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	PuntoVentaType(String type) {
		this.setType(type);
	}

}