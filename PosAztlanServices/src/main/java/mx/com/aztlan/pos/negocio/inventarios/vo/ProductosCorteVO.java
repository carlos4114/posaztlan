package mx.com.aztlan.pos.negocio.inventarios.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.AutorizacionVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PuntoVentaVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductosCorteVO {
	
	private Integer idProductoCorte;
	private ProductoVO producto;
	private UsuarioVO usuario;
	private long existenciaFisica;
	private long existenciaSistema;
	private Integer estatusConteo;
	private Date fecha;
	private AlmacenVO almacen;
	private UsuarioVO usuarioModificacion;
	private Date ultimaModificacion;
	private AutorizacionVO autorizacion;
	public Integer getIdProductoCorte() {
		return idProductoCorte;
	}
	public void setIdProductoCorte(Integer idProductoCorte) {
		this.idProductoCorte = idProductoCorte;
	}
	public ProductoVO getProducto() {
		return producto;
	}
	public void setProducto(ProductoVO producto) {
		this.producto = producto;
	}
	public UsuarioVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	public long getExistenciaFisica() {
		return existenciaFisica;
	}
	public void setExistenciaFisica(long existenciaFisica) {
		this.existenciaFisica = existenciaFisica;
	}
	public long getExistenciaSistema() {
		return existenciaSistema;
	}
	public void setExistenciaSistema(long existenciaSistema) {
		this.existenciaSistema = existenciaSistema;
	}
	public Integer getEstatusConteo() {
		return estatusConteo;
	}
	public void setEstatusConteo(Integer estatusConteo) {
		this.estatusConteo = estatusConteo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public AlmacenVO getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenVO almacen) {
		this.almacen = almacen;
	}
	public UsuarioVO getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(UsuarioVO usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}
	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}
	public AutorizacionVO getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(AutorizacionVO autorizacion) {
		this.autorizacion = autorizacion;
	}
	
	
}
