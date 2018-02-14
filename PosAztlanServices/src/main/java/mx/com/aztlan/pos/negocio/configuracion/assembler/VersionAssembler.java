package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Version;
import mx.com.aztlan.pos.negocio.configuracion.vo.VersionVO;

public class VersionAssembler {

	public static VersionVO getVersionVO(Version version) {

		if (version == null)
			return null;

		VersionVO versionVO = new VersionVO();
		versionVO.setIdVersion(version.getIdVersion());
		versionVO.setNombre(version.getNombre());
		versionVO.setActivo(version.isActivo());

		return versionVO;
	}

	public static List<VersionVO> getVersionesVO(List<Version> versiones) {

		if (versiones == null || versiones.isEmpty())
			return null;

		List<VersionVO> versionesVO = new ArrayList<VersionVO>();

		for (Version version : versiones) {
			versionesVO.add(VersionAssembler.getVersionVO(version));
		}

		return versionesVO;
	}

	public static Version getVersion(Integer idVersion) {

		if (idVersion == null)
			return null;

		Version version = new Version();
		version.setIdVersion(idVersion);

		return version;
	}

}
