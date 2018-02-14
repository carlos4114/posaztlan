package mx.com.aztlan.pos.servicios.util;

public enum ColorType {
	BLUE("btn btn-round btn-default"), YELLOW("btn btn-round btn-warning"), RED("btn btn-round btn-danger");
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	ColorType(String color) {
		this.setColor(color);
	}

}