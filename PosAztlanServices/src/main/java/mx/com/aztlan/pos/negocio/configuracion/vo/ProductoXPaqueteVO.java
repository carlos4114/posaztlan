package mx.com.aztlan.pos.negocio.configuracion.vo;

public class ProductoXPaqueteVO {
	private ProductoVO productoVO;
	private long cantidad;
	private Integer indice;
	
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
}