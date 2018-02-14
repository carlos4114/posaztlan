package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.negocio.configuracion.vo.CineVO;

public class CineAssembler {

	public static CineVO getCineVO(Cine cine){
		if(cine==null)
			return null;
		
		CineVO cineVO = new CineVO();
		cineVO.setIdCine(cine.getIdCine());
		cineVO.setNombre(cine.getNombre());
		cineVO.setActivo(cine.isActivo());
		
		return cineVO;
	}
	
	public static Cine getCine(Integer idCine){
		
		if(idCine==null)
			return null;
		
		Cine cine = new Cine();
		cine.setIdCine(idCine);

		return cine;
	}
	
	public static List<CineVO> getCinesVO(List<Cine> cines){
		
		if(cines==null || cines.isEmpty())
			return null;
		
		List<CineVO> cinesVO = new ArrayList<CineVO>();
		
		for (Cine cine : cines) {
			cinesVO.add(CineAssembler.getCineVO(cine));
		}

		return cinesVO;
		
	}

	
}
