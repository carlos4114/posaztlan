package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

public class ProductoExistenciaVO {
	private ProductoVO productoVO;
	private long seleccionado;
	private long existencia;
	
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}

	public long getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(long seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public long getExistencia() {
		return existencia;
	}

	public void setExistencia(long existencia) {
		this.existencia = existencia;
	}
	
}
