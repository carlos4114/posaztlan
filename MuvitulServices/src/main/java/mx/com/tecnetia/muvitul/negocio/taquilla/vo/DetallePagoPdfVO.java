package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

public class DetallePagoPdfVO {
	 private String tipoTarjeta;
	 private String numeroTarjeta;
	 private BigDecimal cantidad;
	 
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
 	 
	 
}
