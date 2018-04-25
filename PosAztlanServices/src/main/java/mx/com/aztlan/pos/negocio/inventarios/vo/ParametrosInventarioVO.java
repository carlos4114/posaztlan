package mx.com.aztlan.pos.negocio.inventarios.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametrosInventarioVO {

	private Integer idEmpresa;
	private Integer idInventario;
	private Integer idProducto;
	private String lote;
	private Integer cantidad;
	private Integer idTipoMovimiento;
	private String claveTipoMovimiento;
	private Float importe; 
	private Integer idAutorizacion;
	private Integer idProveedor; 
	private byte[] archivo;
	private String contentType;
	private String nombreArchivo;
	private Integer sizeArchivo;
	private Integer idPuntoVentaConsigna;
	private Integer idOrdenCompra; 
	
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}	
	public String getClaveTipoMovimiento() {
		return claveTipoMovimiento;
	}
	public void setClaveTipoMovimiento(String claveTipoMovimiento) {
		this.claveTipoMovimiento = claveTipoMovimiento;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public Integer getSizeArchivo() {
		return sizeArchivo;
	}
	public void setSizeArchivo(Integer sizeArchivo) {
		this.sizeArchivo = sizeArchivo;
	}
	public Integer getIdPuntoVentaConsigna() {
		return idPuntoVentaConsigna;
	}
	public void setIdPuntoVentaConsigna(Integer idPuntoVentaConsigna) {
		this.idPuntoVentaConsigna = idPuntoVentaConsigna;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdOrdenCompra() {
		return idOrdenCompra;
	}
	public void setIdOrdenCompra(Integer idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}
	
	
}
