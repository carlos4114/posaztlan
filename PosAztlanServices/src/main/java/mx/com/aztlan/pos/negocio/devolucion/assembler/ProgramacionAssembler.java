package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;
import mx.com.aztlan.pos.negocio.devolucion.vo.ProgramacionVO;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion) {

		if (programacion == null)
			return null;

		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setPeliculaVO(PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
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
