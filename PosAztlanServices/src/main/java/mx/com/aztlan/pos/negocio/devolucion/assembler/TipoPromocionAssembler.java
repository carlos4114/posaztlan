package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoPromocion;
import mx.com.aztlan.pos.negocio.devolucion.vo.TipoPromocionVO;

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
