package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.math.BigDecimal;

public class PreciosXCanalVO {

	private BigDecimal precio;
	private String nombre;
	private Integer idCanal;
	
	
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
			
	
}
