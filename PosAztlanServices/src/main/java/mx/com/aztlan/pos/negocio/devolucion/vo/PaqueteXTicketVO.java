package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.math.BigDecimal;

public class PaqueteXTicketVO {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private PaqueteVO paqueteVO;
	private int cantidad;
	private BigDecimal importe;
	
	public PaqueteVO getPaqueteVO() {
		return paqueteVO;
	}
	public void setPaqueteVO(PaqueteVO paqueteVO) {
		this.paqueteVO = paqueteVO;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
}
