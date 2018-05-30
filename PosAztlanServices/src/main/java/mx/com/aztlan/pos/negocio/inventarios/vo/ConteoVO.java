package mx.com.aztlan.pos.negocio.inventarios.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.UsuarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

public class ConteoVO implements Serializable{

	private Integer idConteo;
	private List<ProductoExistenciaVO> productos;
	private Integer idAlmacen;
	private Integer folio;
	private Integer idEstatusConteo;
	private Integer idCanal;
	private Integer idUsuarioCreador;
	private Integer idUsuarioAutorizador;
	private Boolean esParcial;
	private Integer idEmpresa; 
	private String nombreEstatus;
	private Integer diferencia;
	
	
	
	public Integer getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(Integer diferencia) {
		this.diferencia = diferencia;
	}
	public String getNombreEstatus() {
		return nombreEstatus;
	}
	public void setNombreEstatus(String nombreEstatus) {
		this.nombreEstatus = nombreEstatus;
	}
	public Integer getIdConteo() {
		return idConteo;
	}
	public void setIdConteo(Integer idConteo) {
		this.idConteo = idConteo;
	}
	public List<ProductoExistenciaVO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoExistenciaVO> productos) {
		this.productos = productos;
	}
	
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public Integer getIdEstatusConteo() {
		return idEstatusConteo;
	}
	public void setIdEstatusConteo(Integer idEstatusConteo) {
		this.idEstatusConteo = idEstatusConteo;
	}
	public Integer getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	public Integer getIdUsuarioCreador() {
		return idUsuarioCreador;
	}
	public void setIdUsuarioCreador(Integer idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}
	public Integer getIdUsuarioAutorizador() {
		return idUsuarioAutorizador;
	}
	public void setIdUsuarioAutorizador(Integer idUsuarioAutorizador) {
		this.idUsuarioAutorizador = idUsuarioAutorizador;
	}
	public Boolean getEsParcial() {
		return esParcial;
	}
	public void setEsParcial(Boolean esParcial) {
		this.esParcial = esParcial;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
