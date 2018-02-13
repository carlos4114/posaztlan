package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Version;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VersionVO;

public class VersionAssembler {

	
	public static VersionVO getVersionVO(Version version){

		if(version==null)
			return null;
		
		VersionVO versionVO = new VersionVO();
		versionVO.setIdVersion(version.getIdVersion());
		versionVO.setNombre(version.getNombre());
		versionVO.setActivo(version.isActivo());
		return versionVO;
	}
	
}
