package mx.com.aztlan.pos.servicios.util;

public enum FormaPagoType {
	EFECTIVO("EFE-001"), DEBITO("DEB-002"), CREDITO("CRE-003");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	FormaPagoType(String type) {
		this.setType(type);
	}

}