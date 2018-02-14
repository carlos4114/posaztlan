package mx.com.aztlan.pos.servicios.util;

public enum DevolucionType {
	PRODUCTO_PRO("PRO-001"), EFECTIVO_PRO("EFE-002"), CORTESIA_BOL("COR-003"), EFECTIVO_BOL("EFE-004");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	DevolucionType(String type) {
		this.setType(type);
	}

}