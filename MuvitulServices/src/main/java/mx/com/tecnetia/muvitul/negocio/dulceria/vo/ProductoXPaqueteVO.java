package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPaqueteId;

public class ProductoXPaqueteVO {
	private ProductosXPaqueteId id;
	//private Paquete paquete;
	private ProductoVO productoVO;
	private long cantidad;
	
	public ProductosXPaqueteId getId() {
		return id;
	}
	public void setId(ProductosXPaqueteId id) {
		this.id = id;
	}
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
