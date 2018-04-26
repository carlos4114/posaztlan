package mx.com.aztlan.pos.negocio.inventarios.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

public class InventarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668884778156013191L;
	private Integer idInventario;
	private ProductoVO producto;
	private ProveedorVO proveedor;
	private TipoMovimientoInvVO tipoMovimientoInvVO;
	private UsuarioVO usuario;
	private Date fecha;
	private String lote;
	private long cantidad;
	private BigDecimal importe;
	private long existenciaActual;
	private AlmacenVO almacenVO;
	private Date ultimoMovimiento;
	private UsuarioVO usuarioUltimoMovimiento;
	
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public long getExistenciaActual() {
		return existenciaActual;
	}
	public void setExistenciaActual(long existenciaActual) {
		this.existenciaActual = existenciaActual;
	}

	public Date getUltimoMovimiento() {
		return ultimoMovimiento;
	}
	public void setUltimoMovimiento(Date ultimoMovimiento) {
		this.ultimoMovimiento = ultimoMovimiento;
	}
	public UsuarioVO getUsuarioUltimoMovimiento() {
		return usuarioUltimoMovimiento;
	}
	public void setUsuarioUltimoMovimiento(UsuarioVO usuarioUltimoMovimiento) {
		this.usuarioUltimoMovimiento = usuarioUltimoMovimiento;
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
	
	
}
