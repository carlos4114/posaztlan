package mx.com.aztlan.pos.negocio.dulceria.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

public class MovimientoInventarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668884778156013191L;
	private Integer idMovimiento;
	private ProductoVO producto;
	private ProveedorVO proveedor;
	private TipoMovimientoInvVO tipoMovimientoInvVO;
	private UsuarioVO usuario;
	private long cantidad;
	private Date fecha;
	private BigDecimal importe;
	private String documentoRespaldo;
	private long existenciaActual;
	private AlmacenVO almacenVO;
	private AlmacenVO destinoAlmacenVO;
	private InventarioVO inventario;
	
	public Integer getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	
	public ProveedorVO getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorVO proveedor) {
		this.proveedor = proveedor;
	}
	public TipoMovimientoInvVO getTipoMovimientoInvVO() {
		return tipoMovimientoInvVO;
	}
	public void setTipoMovimientoInvVO(TipoMovimientoInvVO tipoMovimientoInvVO) {
		this.tipoMovimientoInvVO = tipoMovimientoInvVO;
	}
	public UsuarioVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public String getDocumentoRespaldo() {
		return documentoRespaldo;
	}
	public void setDocumentoRespaldo(String documentoRespaldo) {
		this.documentoRespaldo = documentoRespaldo;
	}
	public long getExistenciaActual() {
		return existenciaActual;
	}
	public void setExistenciaActual(long existenciaActual) {
		this.existenciaActual = existenciaActual;
	}	
	
	
	
	public InventarioVO getInventario() {
		return inventario;
	}
	public void setInventario(InventarioVO inventario) {
		this.inventario = inventario;
	}
	public ProductoVO getProducto() {
		return producto;
	}
	public void setProducto(ProductoVO producto) {
		this.producto = producto;
	}
	public AlmacenVO getAlmacenVO() {
		return almacenVO;
	}
	public void setAlmacenVO(AlmacenVO almacenVO) {
		this.almacenVO = almacenVO;
	}
	public AlmacenVO getDestinoAlmacenVO() {
		return destinoAlmacenVO;
	}
	public void setDestinoAlmacenVO(AlmacenVO destinoAlmacenVO) {
		this.destinoAlmacenVO = destinoAlmacenVO;
	}
		
	
}
