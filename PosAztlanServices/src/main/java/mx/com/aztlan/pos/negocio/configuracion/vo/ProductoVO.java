package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductoVO {
	private Integer idProducto;
	private String nombre;
	private String descripcion;
	private byte[] icono;
	private boolean activo;
	private Integer idEmpresa;
	private Integer idFamilia;
	private Integer idMarca;
	private Integer idTipoProducto;
	private Integer idMedida;
	private Integer idUnidadMedida;
	private BigDecimal precioUnico;
	private List<PreciosXCanalVO> preciosXCanalList;
	private List<ImpuestoVO> impuestosList;
	private boolean nacional;
	private String nombreUnidadMedida;
	private BigDecimal precioUnitario;
	private Integer cantidad;
	private String nombreFamilia;
	private String nombreMarca;
	private String nombreTipo;
	private String nombreMedida;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(Integer idFamilia) {
		this.idFamilia = idFamilia;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public Integer getIdMedida() {
		return idMedida;
	}
	public void setIdMedida(Integer idMedida) {
		this.idMedida = idMedida;
	}
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public BigDecimal getPrecioUnico() {
		return precioUnico;
	}
	public void setPrecioUnico(BigDecimal precioUnico) {
		this.precioUnico = precioUnico;
	}
	public List<PreciosXCanalVO> getPreciosXCanalList() {
		return preciosXCanalList;
	}
	public void setPreciosXCanalList(List<PreciosXCanalVO> preciosXCanalList) {
		this.preciosXCanalList = preciosXCanalList;
	}
	public List<ImpuestoVO> getImpuestosList() {
		return impuestosList;
	}
	public void setImpuestosList(List<ImpuestoVO> impuestosList) {
		this.impuestosList = impuestosList;
	}
	public boolean isNacional() {
		return nacional;
	}
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}
	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreFamilia() {
		return nombreFamilia;
	}
	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public String getNombreMedida() {
		return nombreMedida;
	}
	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}
	
	
}
