package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.math.BigDecimal;

public class PrecioXPaqueteVO {
	private Integer idPrecioXPaquete;
	//private Paquete paquete;
	private BigDecimal precio;
	private boolean activo;
	public Integer getIdPrecioXPaquete() {
		return idPrecioXPaquete;
	}
	public void setIdPrecioXPaquete(Integer idPrecioXPaquete) {
		this.idPrecioXPaquete = idPrecioXPaquete;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
