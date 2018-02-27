package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.math.BigDecimal;
import java.util.List;



public class PaqueteVO {
	private Integer idPaquete;
	private CineVO cineVO;
	private CanalVO canalVO;
	private String nombre;
	private byte[] icono;
	private boolean activo;
	private PuntoVentaVO puntoVentaVO;
	private List<ProductoXPaqueteVO> productosXPaqueteVO;
	private Integer idCine;
	private List <Integer> puntosVentaList;
	private List<ImpuestoVO> impuestosList;
	private List<ProductosSeleccionadosVO> productosSeleccionadosList;
	private BigDecimal precio;
	
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
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public List<Integer> getPuntosVentaList() {
		return puntosVentaList;
	}
	public void setPuntosVentaList(List<Integer> puntosVentaList) {
		this.puntosVentaList = puntosVentaList;
	}
	public List<ImpuestoVO> getImpuestosList() {
		return impuestosList;
	}
	public void setImpuestosList(List<ImpuestoVO> impuestosList) {
		this.impuestosList = impuestosList;
	}
	public List<ProductosSeleccionadosVO> getProductosSeleccionadosList() {
		return productosSeleccionadosList;
	}
	public void setProductosSeleccionadosList(List<ProductosSeleccionadosVO> productosSeleccionadosList) {
		this.productosSeleccionadosList = productosSeleccionadosList;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public CanalVO getCanalVO() {
		return canalVO;
	}
	public void setCanalVO(CanalVO canalVO) {
		this.canalVO = canalVO;
	}

	
}
