package mx.com.aztlan.pos.negocio.inventarios.vo;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.negocio.dulceria.vo.MovimientoInventarioVO;

public class AutorizacionVO {

	private Integer idAutorizacionMovimiento;
	private MovimientoInventarioVO movimientoInventarioVO;
	private Usuario usuario;
	private Date fecha;
	private String comentarios;
	
	public Integer getIdAutorizacionMovimiento() {
		return idAutorizacionMovimiento;
	}
	public void setIdAutorizacionMovimiento(Integer idAutorizacionMovimiento) {
		this.idAutorizacionMovimiento = idAutorizacionMovimiento;
	}
	public MovimientoInventarioVO getMovimientoInventarioVO() {
		return movimientoInventarioVO;
	}
	public void setMovimientoInventarioVO(MovimientoInventarioVO movimientoInventarioVO) {
		this.movimientoInventarioVO = movimientoInventarioVO;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}	
	
}
