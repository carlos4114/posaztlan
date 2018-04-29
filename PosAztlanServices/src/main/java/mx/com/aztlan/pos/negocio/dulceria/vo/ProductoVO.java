package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;

import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;

public class ProductoVO {
	private Integer idProducto;
	private CanalVO canalVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private BigDecimal precio;
	
//	private Set<ProductosXPaquete> productosXPaquetes = new HashSet<ProductosXPaquete>(0);
//	private Set<ProductosXTicket> productosXTickets = new HashSet<ProductosXTicket>(0);
//	private Set<DetallePromocion> detallePromocions = new HashSet<DetallePromocion>(0);
//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);

//	private Set<ImpuestoXProducto> impuestoXProductos = new HashSet<ImpuestoXProducto>(0);
	
	public ProductoVO(){
		
	}
	public ProductoVO(Integer idProducto){
		this.idProducto = idProducto;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public CanalVO getCanalVO() {
		return canalVO;
	}
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
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

}
