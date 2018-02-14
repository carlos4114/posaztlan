package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ClasificacionArt;
import mx.com.aztlan.pos.negocio.devolucion.vo.ClasificacionArtVO;

public class ClasificacionArtAssembler {

	public static ClasificacionArtVO getClasificacionArtVO(ClasificacionArt clasificacionArt){
		if(clasificacionArt==null)
			return null;
		
		ClasificacionArtVO clasificacionArtVO = new ClasificacionArtVO();
		clasificacionArtVO.setIdClasificacionArt(clasificacionArt.getIdClasificacionArt());
		clasificacionArtVO.setCineVO(CineAssembler.getCineVO(clasificacionArt.getCine()));
		clasificacionArtVO.setNombre(clasificacionArt.getNombre());
		clasificacionArtVO.setActivo(clasificacionArt.isActivo());
		

		return clasificacionArtVO;
	}
	
}
