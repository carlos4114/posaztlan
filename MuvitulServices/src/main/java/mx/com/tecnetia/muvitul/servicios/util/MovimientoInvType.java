package mx.com.tecnetia.muvitul.servicios.util;

public enum MovimientoInvType {
	COMPRA_IN("COM-IN-001"), DEVOLUCION_CLIENTE_IN("DEV-IN-004"), 
	VENTA_OUT("VEN-OUT-007"), CORTESIA_OUT("COR-OUT-008"), MERMA_OUT("MER-OUT-011");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	MovimientoInvType(String type) {
		this.setType(type);
	}

}