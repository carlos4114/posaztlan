package mx.com.tecnetia.muvitul.negocio.devolucion.vo;

public class TipoDevolucionVO {
	private Integer idTipoDevolucion;
	private TipoPuntoVentaVO tipoPuntoVentaVO;
	private String nombre;
	private String clave;
	private boolean activo;
	
	public Integer getIdTipoDevolucion() {
		return idTipoDevolucion;
	}
	public void setIdTipoDevolucion(Integer idTipoDevolucion) {
		this.idTipoDevolucion = idTipoDevolucion;
	}
	public TipoPuntoVentaVO getTipoPuntoVentaVO() {
		return tipoPuntoVentaVO;
	}
	public void setTipoPuntoVentaVO(TipoPuntoVentaVO tipoPuntoVentaVO) {
		this.tipoPuntoVentaVO = tipoPuntoVentaVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
