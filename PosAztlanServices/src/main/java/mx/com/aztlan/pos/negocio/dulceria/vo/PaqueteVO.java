package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.math.BigDecimal;
import java.util.List;

import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;

public class PaqueteVO {
	private Integer idPaquete;
	private boolean paquete;
	private CanalVO canalVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private BigDecimal precio;
	private List<ProductoXPaqueteVO> productosXPaqueteVO;


	//Adicionales
	private String color;
	private int cantidad;
	private BigDecimal importe;
	private boolean deshabilitado;
	
//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);
//	private Set<PaquetesXTicket> paquetesXTickets = new HashSet<PaquetesXTicket>(0);
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	public boolean isPaquete() {
		return paquete;
	}
	public void setPaquete(boolean paquete) {
		this.paquete = paquete;
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
	public List<ProductoXPaqueteVO> getProductosXPaqueteVO() {
		return productosXPaqueteVO;
	}
	public void setProductosXPaqueteVO(List<ProductoXPaqueteVO> productosXPaqueteVO) {
		this.productosXPaqueteVO = productosXPaqueteVO;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public boolean isDeshabilitado() {
		return deshabilitado;
	}
	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}
	public CanalVO getCanalVO() {
		return canalVO;
	}
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
	}
	
	
}
