package mx.com.aztlan.pos.negocio.devolucion.vo;

public class DevolucionBoletoVO {
	private Integer idDevolucion;
	private Integer idAutorizacion;
	private Integer idTicketVenta;
	private MotivoDevolucionVO motivoDevolucionVO;
	private TipoDevolucionVO tipoDevolucionVO;
	private String comentarios;
	
	public Integer getIdDevolucion() {
		return idDevolucion;
	}
	public void setIdDevolucion(Integer idDevolucion) {
		this.idDevolucion = idDevolucion;
	}
	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public Integer getIdTicketVenta() {
		return idTicketVenta;
	}
	public void setIdTicketVenta(Integer idTicketVenta) {
		this.idTicketVenta = idTicketVenta;
	}
	public MotivoDevolucionVO getMotivoDevolucionVO() {
		return motivoDevolucionVO;
	}
	public void setMotivoDevolucionVO(MotivoDevolucionVO motivoDevolucionVO) {
		this.motivoDevolucionVO = motivoDevolucionVO;
	}
	public TipoDevolucionVO getTipoDevolucionVO() {
		return tipoDevolucionVO;
	}
	public void setTipoDevolucionVO(TipoDevolucionVO tipoDevolucionVO) {
		this.tipoDevolucionVO = tipoDevolucionVO;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
