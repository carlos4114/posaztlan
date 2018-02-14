package mx.com.aztlan.pos.negocio.taquilla.vo;

public class ProductoVO {
	private Integer idProducto;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
//	private Set<ProductosXPaquete> productosXPaquetes = new HashSet<ProductosXPaquete>(0);
//	private Set<PrecioXProducto> precioXProductos = new HashSet<PrecioXProducto>(0);
//	private Set<ProductosXTicket> productosXTickets = new HashSet<ProductosXTicket>(0);
//	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);
//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);
//	private Set<ArticulosXProducto> articulosXProductos = new HashSet<ArticulosXProducto>(0);
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

}
