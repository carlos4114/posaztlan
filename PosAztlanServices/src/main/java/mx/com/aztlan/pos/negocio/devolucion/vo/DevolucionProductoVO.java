package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.math.BigDecimal;
import java.util.List;

public class DevolucionProductoVO {
	private Integer idDevolucion;
	private Integer idAutorizacion;
	private Integer idTicketVenta;
	private Integer idPuntoVenta;
	private MotivoDevolucionVO motivoDevolucionVO;
	private TipoDevolucionVO tipoDevolucionVO;
	private String comentarios;
	private List<PaqueteXTicketVO> paquetesXTicketVO;
	private BigDecimal importe;
	
	public List<PaqueteXTicketVO> getPaquetesXTicketVO() {
		return paquetesXTicketVO;
	}
	public void setPaquetesXTicketVO(List<PaqueteXTicketVO> paquetesXTicketVO) {
		this.paquetesXTicketVO = paquetesXTicketVO;
	}
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
	public Integer getIdPuntoVenta() {
		return idPuntoVenta;
	}
	public void setIdPuntoVenta(Integer idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
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
	
	
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
}
