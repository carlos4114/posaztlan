package mx.com.aztlan.pos.negocio.administracion.vo;

import java.math.BigDecimal;
import java.util.List;

import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

public class OrdenCompraVO {
	private Integer idEmpresa;
	private Integer idOrdenCompra;
	private Integer idProveedor;
	private BigDecimal descuento; 
	private Integer idEstatusOrdenCompra;
	private List<ProductoVO> productos;
	private BigDecimal total;
	
	
	public Integer getIdOrdenCompra() {
		return idOrdenCompra;
	}
	public void setIdOrdenCompra(Integer idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public List<ProductoVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
	public Integer getIdEstatusOrdenCompra() {
		return idEstatusOrdenCompra;
	}
	public void setIdEstatusOrdenCompra(Integer idEstatusOrdenCompra) {
		this.idEstatusOrdenCompra = idEstatusOrdenCompra;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
