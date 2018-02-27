package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAlmacen;
import mx.com.aztlan.pos.negocio.configuracion.vo.TipoAlmacenVO;

public class TipoAlmacenAssembler {


	public static TipoAlmacenVO getTipoAlmacenVO(TipoAlmacen tipoAlmacen) {
		if(tipoAlmacen == null )
			return null;
		
		TipoAlmacenVO tipoAlmacenVO = new TipoAlmacenVO();
		tipoAlmacenVO.setIdTipoAlmacen(tipoAlmacen.getIdTipoAlmacen());
		tipoAlmacenVO.setNombre(tipoAlmacen.getNombre());
		tipoAlmacenVO.setDescripcion(tipoAlmacen.getDescripcion());
		
		return tipoAlmacenVO;
	}
	
	
}
