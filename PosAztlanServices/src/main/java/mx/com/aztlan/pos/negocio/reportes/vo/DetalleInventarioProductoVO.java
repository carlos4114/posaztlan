package mx.com.aztlan.pos.negocio.reportes.vo;

import java.util.Date;

public class DetalleInventarioProductoVO  {

 	private Integer id;
	private Date fecha;
	private String tipo;
	private String movimiento;
	private Integer existenciaFinal;
	private Integer piezas;
	private Double total;
	private Double precioUnitario;
 
	public DetalleInventarioProductoVO(Integer id,Date fecha, String tipo, String movimiento, Integer existenciaFinal,
			Integer piezas, Double total, Double precioUnitario) {
		super();
		this.id=id;
		this.fecha = fecha;
		this.tipo = tipo;
		this.movimiento = movimiento;
		this.existenciaFinal = existenciaFinal;
		this.piezas = piezas;
		this.total = total;
		this.precioUnitario = precioUnitario;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	public Integer getExistenciaFinal() {
		return existenciaFinal;
	}
	public void setExistenciaFinal(Integer existenciaFinal) {
		this.existenciaFinal = existenciaFinal;
	}
	public Integer getPiezas() {
		return piezas;
	}
	public void setPiezas(Integer piezas) {
		this.piezas = piezas;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
 
}
