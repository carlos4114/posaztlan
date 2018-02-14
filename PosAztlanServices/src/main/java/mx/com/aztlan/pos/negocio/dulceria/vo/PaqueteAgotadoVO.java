package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.util.List;

public class PaqueteAgotadoVO {
	private boolean agotado;
	private List <ProductoExistenciaVO> productosExistenciaVO ;

	public boolean isAgotado() {
		return agotado;
	}

	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}

	public List<ProductoExistenciaVO> getProductosExistenciaVO() {
		return productosExistenciaVO;
	}

	public void setProductosExistenciaVO(List<ProductoExistenciaVO> productosExistenciaVO) {
		this.productosExistenciaVO = productosExistenciaVO;
	}


}
