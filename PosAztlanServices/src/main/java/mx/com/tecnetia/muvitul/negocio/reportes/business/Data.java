package mx.com.tecnetia.muvitul.negocio.reportes.business;

public class Data {
	private Integer idProgramacion;
	private String nombrePelicula;
	private String horario;
	private Integer cantidad;
	private Double precio;
	private Double total;
	private String cliente;

	public Data(Integer idProgramacion, String nombrePelicula, String horario, Integer cantidad, Double precio,
			Double total, String cliente) {
		super();
		this.idProgramacion = idProgramacion;
		this.nombrePelicula = nombrePelicula;
		this.horario = horario;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.cliente = cliente;
	}
	public Integer getIdProgramacion() {
		return idProgramacion;
	}
	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	 

}
