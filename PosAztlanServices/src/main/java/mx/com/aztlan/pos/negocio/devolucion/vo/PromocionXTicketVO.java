package mx.com.aztlan.pos.negocio.devolucion.vo;

import java.math.BigDecimal;

public class PromocionXTicketVO {
	private PromocionVO promocionVO;
	private int cantidad;
	private BigDecimal importe;
	
	public PromocionVO getPromocionVO() {
		return promocionVO;
	}
	public void setPromocionVO(PromocionVO promocionVO) {
		this.promocionVO = promocionVO;
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