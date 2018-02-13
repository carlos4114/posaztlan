package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPromocion;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.TipoPromocionVO;

public class TipoPromocionAssembler {

	public static TipoPromocionVO getTipoPromocion(TipoPromocion tipoPromocion){

		if(tipoPromocion==null)
			return null;
		
		TipoPromocionVO tipoPromocionVO = new TipoPromocionVO();
		tipoPromocion.setIdTipoPromocion(tipoPromocion.getIdTipoPromocion());
		tipoPromocion.setNombre(tipoPromocion.getNombre());
		tipoPromocion.setDescripcion(tipoPromocion.getDescripcion());
		tipoPromocion.setClave(tipoPromocion.getClave());
		return tipoPromocionVO;
	}
	
}
