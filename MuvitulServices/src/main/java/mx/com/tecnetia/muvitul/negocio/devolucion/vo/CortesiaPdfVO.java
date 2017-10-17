package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

import java.math.BigDecimal;

public class CortesiaPdfVO {
	private String nombreCine;
	private String razonSocial;
	private String direccion;
	private String rfc;
	private String telefono;
	private String fechaHoraCompra;
	private Long numeroOrdenTicket;
	private BigDecimal totalPago;
	private String leyenda;
	private String slogan;
	private String sugerencias;
	private String agradeciemiento;
	private String folioDevolucion;
	
	public String getNombreCine() {
		return nombreCine;
	}
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaHoraCompra() {
		return fechaHoraCompra;
	}
	public void setFechaHoraCompra(String fechaHoraCompra) {
		this.fechaHoraCompra = fechaHoraCompra;
	}
	public Long getNumeroOrdenTicket() {
		return numeroOrdenTicket;
	}
	public void setNumeroOrdenTicket(Long numeroOrdenTicket) {
		this.numeroOrdenTicket = numeroOrdenTicket;
	}
	public BigDecimal getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(BigDecimal totalPago) {
		this.totalPago = totalPago;
	}
	public String getLeyenda() {
		return leyenda;
	}
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getSugerencias() {
		return sugerencias;
	}
	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}
	public String getAgradeciemiento() {
		return agradeciemiento;
	}
	public void setAgradeciemiento(String agradeciemiento) {
		this.agradeciemiento = agradeciemiento;
	}
	public String getFolioDevolucion() {
		return folioDevolucion;
	}
	public void setFolioDevolucion(String folioDevolucion) {
		this.folioDevolucion = folioDevolucion;
	}
	
}
