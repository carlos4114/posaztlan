package mx.com.aztlan.pos.negocio.inventarios.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalidaVO {

	private Integer idEmpresa;
	private Integer idCanal;
	private Integer idAlmacen;
	private Integer idInventario;
	private List<ProductoVO> productos;
	private String lote;
	private Integer idTipoMovimiento;
	private String claveTipoMovimiento;
	private Integer idAutorizacion;
	private Integer idProveedor; 
	private byte[] archivo;
	private String contentType;
	private String nombreArchivo;
	private Integer sizeArchivo;
	private Integer idAlmacenConsigna;
	
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
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
	public Integer getIdAlmacenConsigna() {
		return idAlmacenConsigna;
	}
	public void setIdAlmacenConsigna(Integer idAlmacenConsigna) {
		this.idAlmacenConsigna = idAlmacenConsigna;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public List<ProductoVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoVO> productos) {
		this.productos = productos;
	}
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	
	
}
