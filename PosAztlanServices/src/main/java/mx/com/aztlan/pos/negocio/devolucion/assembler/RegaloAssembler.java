package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Regalo;
import mx.com.aztlan.pos.negocio.devolucion.vo.RegaloVO;


public class RegaloAssembler {

	public static RegaloVO getRegaloVO(Regalo regalo){

		if(regalo==null )
			return null;

		RegaloVO regaloVO = new RegaloVO();
		regaloVO.setIdRegalo(regalo.getIdRegalo());
		regaloVO.setCineVO(CineAssembler.getCineVO(regalo.getCine()));
		regaloVO.setNombre(regalo.getNombre());
		regaloVO.setDescripcion(regalo.getDescripcion());
		
		return regaloVO;
	}
	
}
