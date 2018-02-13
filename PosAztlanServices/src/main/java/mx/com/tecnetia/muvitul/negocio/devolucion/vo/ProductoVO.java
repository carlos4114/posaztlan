package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

import java.util.List;

public class ProductoVO {
	private Integer idProducto;
	private CineVO cineVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private int cantidad;
	private List<ArticuloXProductoVO> articulosXProductosVO;
	
	private boolean selected;
	private boolean estado= true;
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
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
	public List<ArticuloXProductoVO> getArticulosXProductosVO() {
		return articulosXProductosVO;
	}
	public void setArticulosXProductosVO(List<ArticuloXProductoVO> articulosXProductosVO) {
		this.articulosXProductosVO = articulosXProductosVO;
	}
}
