package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration;

public enum PropiedadConfigEnum {

	URL_LOGO(new Integer("1"));	

	private Integer value;

	PropiedadConfigEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}
};