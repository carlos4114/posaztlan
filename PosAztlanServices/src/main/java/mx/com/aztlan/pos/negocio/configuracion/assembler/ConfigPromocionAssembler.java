package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionPara;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Regalo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoPromocion;
import mx.com.aztlan.pos.negocio.configuracion.vo.ConfigPromocionVO;

public class ConfigPromocionAssembler {

	public static ConfigPromocionVO getConfigPromocionVO(List<TipoPromocion> tiposPromocion,
			List<PromocionPara> promocionesPara, List<Producto> productos, List<Regalo> regalos) {
		if (tiposPromocion==null || promocionesPara==null || productos==null || regalos==null )
			return null;
		
		ConfigPromocionVO configPromocionVO = new ConfigPromocionVO();
		configPromocionVO.setTiposPromocionVO(TipoPromocionAssembler.getTiposPromocionVO(tiposPromocion));
		configPromocionVO.setPromocionesParaVO(PromocionParaAssembler.getPromocionParaVO(promocionesPara));
		configPromocionVO.setProductosVO(ProductoAssembler.getProductos(productos));
		configPromocionVO.setRegalosVO(RegaloAssembler.getRegalosVO(regalos));
		
		return configPromocionVO;
	}

}
