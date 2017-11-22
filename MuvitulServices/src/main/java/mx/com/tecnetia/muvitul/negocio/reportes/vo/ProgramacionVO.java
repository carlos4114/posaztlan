package mx.com.tecnetia.muvitul.negocio.reportes.vo;

public class ProgramacionVO {
	private Double precio;
	private Integer cantidad;
	private Double subtotal;
	private Integer totalCantidad;
	private Double total;
	private String nombreSala;
	private String horario;
	private String nombrePelicula;

	public ProgramacionVO(Double precio, Integer cantidad, Double subtotal, Integer totalCantidad, Double total,
			String nombreSala, String horario, String nombrePelicula) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.totalCantidad = totalCantidad;
		this.total = total;
		this.nombreSala = nombreSala;
		this.horario = horario;
		this.nombrePelicula = nombrePelicula;
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

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getTotalCantidad() {
		return totalCantidad;
	}

	public void setTotalCantidad(Integer totalCantidad) {
		this.totalCantidad = totalCantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

}
