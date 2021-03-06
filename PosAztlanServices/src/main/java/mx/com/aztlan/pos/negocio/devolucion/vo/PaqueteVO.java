package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.math.BigDecimal;
import java.util.List;

public class PaqueteVO {
	private Integer idPaquete;
	private boolean paquete;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private BigDecimal precio;
	private List<ProductoXPaqueteVO> productosXPaqueteVO;

	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
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
	public List<ProductoXPaqueteVO> getProductosXPaqueteVO() {
		return productosXPaqueteVO;
	}
	public void setProductosXPaqueteVO(List<ProductoXPaqueteVO> productosXPaqueteVO) {
		this.productosXPaqueteVO = productosXPaqueteVO;
	}

}
