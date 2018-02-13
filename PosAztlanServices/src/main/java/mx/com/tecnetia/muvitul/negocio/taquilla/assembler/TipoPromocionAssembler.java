package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TipoPromocionVO;

public class TipoPromocionAssembler {

	public static TipoPromocionVO getTipoPromocion(TipoPromocion tipoPromocion){

		if(tipoPromocion==null)
			return null;
		
		TipoPromocionVO tipoPromocionVO = new TipoPromocionVO();
		tipoPromocionVO.setIdTipoPromocion(tipoPromocion.getIdTipoPromocion());
		tipoPromocionVO.setNombre(tipoPromocion.getNombre());
		tipoPromocionVO.setDescripcion(tipoPromocion.getDescripcion());
		//tipoPromocionVO.setClave(tipoPromocion.getClave());
		return tipoPromocionVO;
	}
	
}
