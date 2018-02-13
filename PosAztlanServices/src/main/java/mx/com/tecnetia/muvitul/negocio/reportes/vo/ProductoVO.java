package mx.com.tecnetia.muvitul.negocio.reportes.vo;

import java.util.List;

public class ProductoVO {
	private List<DetalleInventarioProductoVO> inventarioProductos;
	private String nombreProducto;
 	private String medida;
	private String tipo;
	private Integer invCantidad;
	private Double invTotal;

	public ProductoVO() {
		super();
	}

	public ProductoVO(List<DetalleInventarioProductoVO> inventarioProductos, String nombreProducto, String medida,
			String tipo, Integer invCantidad, Double invTotal) {
		super();
		this.inventarioProductos = inventarioProductos;
		this.nombreProducto = nombreProducto;
		this.medida = medida;
		this.tipo = tipo;
		this.invCantidad = invCantidad;
		this.invTotal = invTotal;
	}

	public List<DetalleInventarioProductoVO> getInventarioProductos() {
		return inventarioProductos;
	}

	public void setInventarioProductos(List<DetalleInventarioProductoVO> inventarioProductos) {
		this.inventarioProductos = inventarioProductos;
	}
 

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getInvCantidad() {
		return invCantidad;
	}

	public void setInvCantidad(Integer invCantidad) {
		this.invCantidad = invCantidad;
	}

	public Double getInvTotal() {
		return invTotal;
	}

	public void setInvTotal(Double invTotal) {
		this.invTotal = invTotal;
	}

}
