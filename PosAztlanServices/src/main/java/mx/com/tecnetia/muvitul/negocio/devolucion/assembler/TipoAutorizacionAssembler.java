package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoAutorizacion;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.TipoAutorizacionVO;

public class TipoAutorizacionAssembler {
	
	public static TipoAutorizacionVO getTipoAutorizacionVO(TipoAutorizacion  tipoAutorizacion){

		if(tipoAutorizacion==null)
			return null;
		
		TipoAutorizacionVO tipoAutorizacionVO = new TipoAutorizacionVO();
		tipoAutorizacionVO.setIdTipoAutorizacion(tipoAutorizacionVO.getIdTipoAutorizacion());
		tipoAutorizacionVO.setNombre(tipoAutorizacionVO.getNombre());
		tipoAutorizacionVO.setActivo(tipoAutorizacionVO.isActivo());

		return tipoAutorizacionVO;
	}
	
	
}