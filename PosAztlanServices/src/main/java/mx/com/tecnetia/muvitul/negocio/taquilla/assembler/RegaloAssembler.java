package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.RegaloVO;

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
