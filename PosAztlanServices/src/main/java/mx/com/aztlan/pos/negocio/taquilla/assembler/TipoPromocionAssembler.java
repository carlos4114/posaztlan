package mx.com.aztlan.pos.negocio.taquilla.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoPromocion;
import mx.com.aztlan.pos.negocio.taquilla.vo.TipoPromocionVO;

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
