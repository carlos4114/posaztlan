package mx.com.tecnetia.muvitul.negocio.reportes.business;

public class TaquillaSemanal {

	private String diaSemana;
	private Integer numDia;
	private String titulo;
	private Double precio;
	private Integer cantidad;
	private Double total;
	private String semana;

	
	
	public TaquillaSemanal(String diaSemana, Integer numDia, String titulo, Double precio, Integer cantidad, Double total,
			String semana) {
		super();
		this.diaSemana = diaSemana;
		this.numDia = numDia;
		this.titulo = titulo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
		this.semana = semana;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getNumDia() {
		return numDia;
	}

	public void setNumDia(Integer numDia) {
		this.numDia = numDia;
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