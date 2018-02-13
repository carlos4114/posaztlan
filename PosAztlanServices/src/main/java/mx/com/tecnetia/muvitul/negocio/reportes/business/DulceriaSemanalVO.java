package mx.com.tecnetia.muvitul.negocio.reportes.business;

public class DulceriaSemanalVO {

	private String diaSemana;
	private Integer numDia;
	private String producto;
	private Double precio;
	private Integer cantidad;
	private Double total;
	
	
	public DulceriaSemanalVO(String diaSemana, Integer numDia, String producto, Double precio, Integer cantidad,
			Double total) {
		super();
		this.diaSemana = diaSemana;
		this.numDia = numDia;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
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