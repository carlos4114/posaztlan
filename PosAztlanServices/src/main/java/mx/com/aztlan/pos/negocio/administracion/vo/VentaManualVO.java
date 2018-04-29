package mx.com.aztlan.pos.negocio.administracion.vo;

import java.util.List;

import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

public class VentaManualVO {
	private Integer idEmpresa;
	private Integer idCanal;
	private Integer idAlmacen;
	private List<ProductoVO> productos;
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public List<ProductoVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	

	
}
