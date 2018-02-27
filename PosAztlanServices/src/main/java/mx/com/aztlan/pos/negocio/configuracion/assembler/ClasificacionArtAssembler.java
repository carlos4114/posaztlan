package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ClasificacionArt;
import mx.com.aztlan.pos.negocio.configuracion.vo.ClasificacionArtVO;

public class ClasificacionArtAssembler {

	public static ClasificacionArtVO getClasificacionArtVO(ClasificacionArt  clasificacionArt){
		
		if(clasificacionArt==null)
			return null;
		
		ClasificacionArtVO clasificacionArtVO = new ClasificacionArtVO();
		clasificacionArtVO.setIdClasificacionArt(clasificacionArt.getIdClasificacionArt());
		clasificacionArtVO.setNombre(clasificacionArt.getNombre());
		clasificacionArtVO.setActivo(clasificacionArt.isActivo());

		return clasificacionArtVO;
	}
	
	public static List<ClasificacionArtVO> getClasificacionesArt(List<ClasificacionArt> clasificaciones){

		List<ClasificacionArtVO> clasificacionArtVO = new ArrayList<ClasificacionArtVO>();
		
		for (ClasificacionArt clasificacion : clasificaciones) {
			clasificacionArtVO.add(ClasificacionArtAssembler.getClasificacionArtVO(clasificacion));
		}

		return clasificacionArtVO;

	}

	
}
