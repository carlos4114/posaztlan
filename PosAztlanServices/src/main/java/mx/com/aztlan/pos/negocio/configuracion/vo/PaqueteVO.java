package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.util.List;



public class PaqueteVO {
	private Integer idPaquete;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private PuntoVentaVO puntoVentaVO;
	private List<ProductoXPaqueteVO> productosXPaqueteVO;
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
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
	
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
	}
	
	public List<ProductoXPaqueteVO> getProductosXPaqueteVO() {
		return productosXPaqueteVO;
	}
	public void setProductosXPaqueteVO(List<ProductoXPaqueteVO> productosXPaqueteVO) {
		this.productosXPaqueteVO = productosXPaqueteVO;
	}
	
}
