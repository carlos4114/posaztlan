package mx.com.tecnetia.muvitul.negocio.taquilla.vo;

import java.math.BigDecimal;

public class TicketPdfVO {

	private String nombreCine;
	private String razonSocial;
	private String direccion;
	private String rfc;
	private String telefono ;
	private Long numeroOrdenTicket;
	private String fechaHoraCompra;
	private BigDecimal iva;
	private BigDecimal subtotal;
	private BigDecimal totalPago;
	private BigDecimal recibe;
	private BigDecimal cambio;
	private String leyenda;
	private String slogan;
	private String sugerencias;

	private DetalleTicketPdfVO detalleTicketVO;

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

	public Long getNumeroOrdenTicket() {
		return numeroOrdenTicket;
	}

	public void setNumeroOrdenTicket(Long numeroOrdenTicket) {
		this.numeroOrdenTicket = numeroOrdenTicket;
	}

	public String getFechaHoraCompra() {
		return fechaHoraCompra;
	}

	public void setFechaHoraCompra(String fechaHoraCompra) {
		this.fechaHoraCompra = fechaHoraCompra;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(BigDecimal totalPago) {
		this.totalPago = totalPago;
	}

	public BigDecimal getRecibe() {
		return recibe;
	}

	public void setRecibe(BigDecimal recibe) {
		this.recibe = recibe;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
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

	public DetalleTicketPdfVO getDetalleTicketVO() {
		return detalleTicketVO;
	}

	public void setDetalleTicketVO(DetalleTicketPdfVO detalleTicketVO) {
		this.detalleTicketVO = detalleTicketVO;
	}

}
