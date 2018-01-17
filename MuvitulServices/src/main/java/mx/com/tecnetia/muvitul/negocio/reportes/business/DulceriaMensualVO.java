package mx.com.tecnetia.muvitul.negocio.reportes.business;

public class DulceriaMensual {

	private String nombreSemana;
	private Integer numSemana;
	private String producto;
	private Double precio;
	private Integer cantidad;
	private Double total;
	
	
	
	public DulceriaMensual(String nombreSemana, Integer numSemana, String producto, Double precio, Integer cantidad,
			Double total) {
		super();
		this.nombreSemana = nombreSemana;
		this.numSemana = numSemana;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
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
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
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
	
	
	 
}