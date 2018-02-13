package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoDevolucion;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.TipoDevolucionVO;

public class TipoDevolucionAssembler {
	
	public static TipoDevolucion getTipoDevolucion(Integer idTipoDevolucion){

		if(idTipoDevolucion==null)
			return null;
		
		TipoDevolucion tipoDevolucion = new TipoDevolucion();
		tipoDevolucion.setIdTipoDevolucion(idTipoDevolucion);
		
		return tipoDevolucion;
	}
	
	
	public static TipoDevolucionVO getTipoDevolucionVO(TipoDevolucion tipoDevolucion ){

		if(tipoDevolucion==null)
			return null;
		
		TipoDevolucionVO tipoDevolucionVO = new TipoDevolucionVO();
		tipoDevolucionVO.setIdTipoDevolucion(tipoDevolucion.getIdTipoDevolucion());
		tipoDevolucionVO.setNombre(tipoDevolucion.getNombre());
		tipoDevolucionVO.setActivo(tipoDevolucion.isActivo());
		
		return tipoDevolucionVO;
	}
	
}