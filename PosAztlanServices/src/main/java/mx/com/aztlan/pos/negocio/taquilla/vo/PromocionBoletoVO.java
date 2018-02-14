package mx.com.aztlan.pos.negocio.taquilla.vo;

import java.util.List;

public class PromocionBoletoVO {
	private PromocionVO promocionVO;
	private List<BoletoXTicketVO> boletosXTicketVO;
	
	public PromocionVO getPromocionVO() {
		return promocionVO;
	}
	public void setPromocionVO(PromocionVO promocionVO) {
		this.promocionVO = promocionVO;
	}
	public List<BoletoXTicketVO> getBoletosXTicketVO() {
		return boletosXTicketVO;
	}
	public void setBoletosXTicketVO(List<BoletoXTicketVO> boletosXTicketVO) {
		this.boletosXTicketVO = boletosXTicketVO;
	}
	
}
