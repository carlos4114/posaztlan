package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductoVO {
	private Integer idProducto;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private BigDecimal precio;
	private List<ArticuloXProductoVO> articulosXProductosVO;
	
//	private Set<ProductosXPaquete> productosXPaquetes = new HashSet<ProductosXPaquete>(0);
//	private Set<ProductosXTicket> productosXTickets = new HashSet<ProductosXTicket>(0);
//	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);
//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);

//	private Set<ImpuestoXProducto> impuestoXProductos = new HashSet<ImpuestoXProducto>(0);
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public CineVO getCineVO() {
		return cineVO;
	}
	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getIcono() {
		return icono;
	}
	public void setIcono(byte[] icono) {
		this.icono = icono;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public List<ArticuloXProductoVO> getArticulosXProductosVO() {
		return articulosXProductosVO;
	}
	public void setArticulosXProductosVO(List<ArticuloXProductoVO> articulosXProductosVO) {
		this.articulosXProductosVO = articulosXProductosVO;
	}
}
