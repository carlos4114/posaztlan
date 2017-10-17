package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.RegaloVO;

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
	
	public static List<RegaloVO> getRegalosVO(List<Regalo> regalos) {

		if (regalos == null || regalos.isEmpty())
			return null;

		List<RegaloVO> regalosVO = new ArrayList<RegaloVO>();

		for (Regalo regalo : regalos) {
			regalosVO.add(RegaloAssembler.getRegaloVO(regalo));
		}

		return regalosVO;
	}
	
	
	public static Regalo getRegalo(Integer idRegalo){

		if(idRegalo==null )
			return null;

		Regalo regalo = new Regalo();
		regalo.setIdRegalo(idRegalo);

		return regalo;
	}
	
	
}
