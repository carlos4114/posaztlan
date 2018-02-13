package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionPara;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigPromocionVO;

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
