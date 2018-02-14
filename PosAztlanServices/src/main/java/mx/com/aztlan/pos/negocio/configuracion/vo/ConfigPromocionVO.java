package mx.com.aztlan.pos.negocio.configuracion.vo;

import java.util.List;

public class ConfigPromocionVO {
	List<TipoPromocionVO> tiposPromocionVO;
	List<PromocionParaVO> promocionesParaVO;
	List<ProductoVO> productosVO;
	List<RegaloVO> regalosVO;
	
	public List<TipoPromocionVO> getTiposPromocionVO() {
		return tiposPromocionVO;
	}
	public void setTiposPromocionVO(List<TipoPromocionVO> tiposPromocionVO) {
		this.tiposPromocionVO = tiposPromocionVO;
	}
	public List<PromocionParaVO> getPromocionesParaVO() {
		return promocionesParaVO;
	}
	public void setPromocionesParaVO(List<PromocionParaVO> promocionesParaVO) {
		this.promocionesParaVO = promocionesParaVO;
	}
	public List<ProductoVO> getProductosVO() {
		return productosVO;
	}
	public void setProductosVO(List<ProductoVO> productosVO) {
		this.productosVO = productosVO;
	}
	public List<RegaloVO> getRegalosVO() {
		return regalosVO;
	}
	public void setRegalosVO(List<RegaloVO> regalosVO) {
		this.regalosVO = regalosVO;
	}
	
	
}
