package mx.com.tecnetia.muvitul.negocio.dashboard.vo;

public class RentableVO {
	private int consecutivo;
	private String nombre;
	private int vendidos; 
	private Double rentabilidad;
	private Double unidadXTicket;
	
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVendidos() {
		return vendidos;
	}
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}
	public Double getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(Double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	public Double getUnidadXTicket() {
		return unidadXTicket;
	}
	public void setUnidadXTicket(Double unidadXTicket) {
		this.unidadXTicket = unidadXTicket;
	}
	
}
