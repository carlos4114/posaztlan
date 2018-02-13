package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion) {

		if (programacion == null)
			return null;

		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setSalaVO(SalaAssembler.getSalaVO(programacion.getSala()));
		programacionVO.setVersionVO(VersionAssembler.getVersionVO(programacion.getVersion()));
		programacionVO.setDiaSemana(programacion.getDiaSemana());
		//programacionVO.setHorario(sdf.format(programacion.getHorario()));
		programacionVO.setHorario(programacion.getHorario());
		programacionVO.setFechaVigencia(programacion.getFechaVigencia());
		programacionVO.setActivo(programacion.isActivo());

		return programacionVO;
	}

	public static Programacion getProgramacion(Integer idProgramacion) {

		if (idProgramacion == null)
			return null;

		Programacion programacion = new Programacion();
		programacion.setIdProgramacion(idProgramacion);

		return programacion;
	}

}
