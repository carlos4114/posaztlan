package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Formato;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pelicula;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Sala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Version;
import mx.com.aztlan.pos.negocio.configuracion.vo.ConfigProgramacionVO;

public class ConfigProgramacionAssembler {

	public static ConfigProgramacionVO getConfigProgramacionVO(List<Sala> salas, List<String> diasSemana,
			List<Pelicula> peliculas, List<Formato> formatos, List<Version> versiones) {

		if (salas == null || peliculas == null || formatos == null || versiones == null)
			return null;
		
		ConfigProgramacionVO configProgramacionVO = new ConfigProgramacionVO();
		configProgramacionVO.setSalasVO(SalaAssembler.getSalasVO(salas));
		configProgramacionVO.setDias(diasSemana);
		configProgramacionVO.setPeliculasVO(PeliculaAssembler.getPeliculasVO(peliculas));
		configProgramacionVO.setFormatosVO(FormatoAssembler.getFormatosVO(formatos));
		configProgramacionVO.setVersionesVO(VersionAssembler.getVersionesVO(versiones));

		return configProgramacionVO;
	}

}
