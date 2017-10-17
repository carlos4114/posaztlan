package mx.com.tecnetia.muvitul.negocio.inventarios.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ProveedorVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.ArticuloVO;
import  mx.com.tecnetia.muvitul.negocio.dulceria.vo.PuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.UsuarioVO;

public class InventarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668884778156013191L;
	private Integer idInventario;
	private ArticuloVO articulo;
	private ProveedorVO proveedor;
	private TipoMovimientoInvVO tipoMovimientoInvVO;
	private UsuarioVO usuario;
	private Date fecha;
	private String lote;
	private long cantidad;
	private BigDecimal importe;
	private long existenciaActual;
	private PuntoVentaVO puntoVentaVO;
	private Date ultimoMovimiento;
	private UsuarioVO usuarioUltimoMovimiento;
	
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	public ArticuloVO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
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
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
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
	
}
