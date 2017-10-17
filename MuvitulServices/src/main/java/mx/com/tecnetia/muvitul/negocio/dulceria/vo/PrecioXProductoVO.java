package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.math.BigDecimal;

public class PrecioXProductoVO {
	private Integer idPrecioXProducto;
	//private Producto producto;
	private BigDecimal precio;
	private boolean activo;
	
	public Integer getIdPrecioXProducto() {
		return idPrecioXProducto;
	}
	public void setIdPrecioXProducto(Integer idPrecioXProducto) {
		this.idPrecioXProducto = idPrecioXProducto;
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
