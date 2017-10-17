package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

import java.math.BigDecimal;

public class ProductoXTicketVO {
	private ProductoVO productoVO;
	private int cantidad;
	private BigDecimal importe;
	
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
}
