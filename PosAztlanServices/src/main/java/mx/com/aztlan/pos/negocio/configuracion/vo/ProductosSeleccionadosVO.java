package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductosSeleccionadosVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<ProductosAgregadosVO> productosAgregadosList;
	private Long cantidad;
	
	public List<ProductosAgregadosVO> getProductosAgregadosList() {
		return productosAgregadosList;
	}
	public void setProductosAgregadosList(List<ProductosAgregadosVO> productosAgregadosList) {
		this.productosAgregadosList = productosAgregadosList;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


}
