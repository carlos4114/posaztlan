package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaCupoVO;

public class CupoXSalaAssembler {

	public static CupoXSala getCupoSala(SalaCupoVO salaVO, Sala sala){
		
		if(salaVO==null)
			return null;
		
		CupoXSala salaCupo = new CupoXSala();
		
		salaCupo.setActivo(salaVO.isCupoActivo());
		salaCupo.setIdCupoXSala(salaVO.getIdCupoSala());
		salaCupo.setNoAsientos(salaVO.getCupo());
		salaCupo.setSala(sala);
		salaCupo.setTieneNumerado(salaVO.isTieneNumerado());
		salaCupo.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
		
		return salaCupo;
	}
	
	public static CupoXSala getCupoSala(SalaCupoVO salaVO, Sala sala, CupoXSala salaCupo){
		
		if(salaVO==null)
			return null;
		
		salaCupo.setActivo(salaVO.isCupoActivo());
		salaCupo.setIdCupoXSala(salaVO.getIdCupoSala());
		salaCupo.setNoAsientos(salaVO.getCupo());
		salaCupo.setSala(sala);
		salaCupo.setTieneNumerado(salaVO.isTieneNumerado());
		
		return salaCupo;
	}
	
	
}
