package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProgramacionVO;
import mx.com.aztlan.pos.servicios.util.Fecha;

public class ProgramacionAssembler {

	public static ProgramacionVO getProgramacionVO(Programacion programacion, boolean nuevo) {

		if (programacion == null)
			return null;

		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		ProgramacionVO programacionVO = new ProgramacionVO();
		programacionVO.setIdProgramacion(programacion.getIdProgramacion());
		programacionVO.setFormatoVO(FormatoAssembler.getFormatoVO(programacion.getFormato()));
		programacionVO.setPeliculaVO(PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
		programacionVO.setSalaVO(SalaAssembler.getSalaVO(programacion.getSala()));
		programacionVO.setVersionVO(VersionAssembler.getVersionVO(programacion.getVersion()));
		programacionVO.setDiaSemana(programacion.getDiaSemana());
		programacionVO.setHorario(hourFormat.format(programacion.getHorario()));
		programacionVO.setHorarioFin(hourFormat.format(programacion.getHorarioFin()));
		programacionVO.setFechaVigencia(programacion.getFechaVigencia());
		programacionVO.setFechaInicio(programacion.getFechaInicio());
		programacionVO.setActivo(programacion.isActivo());
		programacionVO.setNuevo(nuevo);
		
		return programacionVO;
	}

	public static Programacion getProgramacion(ProgramacionVO programacionVO) {

		if (programacionVO == null)
			return null;


		Programacion programacion = new Programacion();
		programacion.setSala(SalaAssembler.getSala(programacionVO.getSalaVO().getIdSala()));
		programacion.setDiaSemana(programacionVO.getDiaSemana());
		programacion.setPelicula(PeliculaAssembler.getPelicula(programacionVO.getPeliculaVO()));
		programacion.setFormato(FormatoAssembler.getFormato(programacionVO.getFormatoVO().getIdFormato()));
		programacion.setVersion(VersionAssembler.getVersion(programacionVO.getVersionVO().getIdVersion()));
		programacion.setHorario(Fecha.getTime(programacionVO.getHorario()));
		programacion.setFechaVigencia(programacionVO.getFechaVigencia());
		programacion.setFechaInicio(programacionVO.getFechaInicio());
		programacion.setActivo(programacionVO.isActivo());

		Calendar calHorario = Calendar.getInstance();
		calHorario.setTime(programacion.getHorario());
		calHorario.add(Calendar.MINUTE, programacion.getPelicula().getDuracion() + 30 );
		
		programacion.setHorarioFin(calHorario.getTime());
		
		return programacion;
	}

}
