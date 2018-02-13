package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import mx.com.tecnetia.muvitul.negocio.inventarios.vo.InventarioVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ProveedorVO;
import  mx.com.tecnetia.muvitul.negocio.dulceria.vo.PuntoVentaVO;

public class MovimientoInventarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668884778156013191L;
	private Integer idMovimiento;
	private ArticuloVO articulo;
	private ProveedorVO proveedor;
	private TipoMovimientoInvVO tipoMovimientoInvVO;
	private UsuarioVO usuario;
	private long cantidad;
	private Date fecha;
	private BigDecimal importe;
	private String documentoRespaldo;
	private long existenciaActual;
	private PuntoVentaVO puntoVentaVO;
	private PuntoVentaVO destinoPuntoVentaVO;
	private InventarioVO inventario;
	
	public Integer getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
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
	public PuntoVentaVO getPuntoVentaVO() {
		return puntoVentaVO;
	}
	public void setPuntoVentaVO(PuntoVentaVO puntoVentaVO) {
		this.puntoVentaVO = puntoVentaVO;
	}
	public PuntoVentaVO getDestinoPuntoVentaVO() {
		return destinoPuntoVentaVO;
	}
	public void setDestinoPuntoVentaVO(PuntoVentaVO destinoPuntoVentaVO) {
		this.destinoPuntoVentaVO = destinoPuntoVentaVO;
	}
	public InventarioVO getInventario() {
		return inventario;
	}
	public void setInventario(InventarioVO inventario) {
		this.inventario = inventario;
	}
		
}
