package mx.com.aztlan.pos.negocio.reportes.business;

public class TaquillaMensualVO {

	private String nombreSemana;
	private Integer numSemana;
	private String titulo;
	private Double precio;
	private Integer cantidad;
	private Double total;
	private String semana;

	
	public TaquillaMensualVO(String nombreSemana, Integer numSemana, String titulo, Double precio, Integer cantidad,
			Double total, String semana) {
		super();
		this.nombreSemana = nombreSemana;
		this.numSemana = numSemana;
		this.titulo = titulo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
		this.semana = semana;
	}
	public String getNombreSemana() {
		return nombreSemana;
	}
	public void setNombreSemana(String nombreSemana) {
		this.nombreSemana = nombreSemana;
	}
	public Integer getNumSemana() {
		return numSemana;
	}
	public void setNumSemana(Integer numSemana) {
		this.numSemana = numSemana;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}

	
 

}