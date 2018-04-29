package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoExistenciaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idProducto;
	private String sku;
	private String nombre;
	private String familia;
	private String marca;
	private String tipoProducto;
	private String medida;
	private String unidadMedida;
	private Integer existencia;
	private BigDecimal precio;
	private boolean validarExistencia;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Integer getExistencia() {
		return existencia;
	}
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public boolean isValidarExistencia() {
		return validarExistencia;
	}
	public void setValidarExistencia(boolean validarExistencia) {
		this.validarExistencia = validarExistencia;
	}
	

	
}
