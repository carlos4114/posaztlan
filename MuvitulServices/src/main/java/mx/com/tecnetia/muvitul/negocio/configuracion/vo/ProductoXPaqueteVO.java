package mx.com.tecnetia.muvitul.negocio.configuracion.vo;

public class ProductoXPaqueteVO {
	private ProductoVO productoVO;
	private long cantidad;
	
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

}