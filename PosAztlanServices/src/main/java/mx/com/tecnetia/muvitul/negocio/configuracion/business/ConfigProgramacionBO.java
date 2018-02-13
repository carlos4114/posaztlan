package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.FormatoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PeliculaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.SalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.VersionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Formato;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Version;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.ConfigProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.PeliculaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.ProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.SalaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ConfigProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaProgramacionVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
@Transactional
public class ConfigProgramacionBO {

	@Autowired
	private SalaDAOI salaDAO;

	@Autowired
	private PeliculaDAOI peliculaDAO;

	@Autowired
	private FormatoDAOI formatoDAO;

	@Autowired
	private VersionDAOI versionDAO;

	@Autowired
	private ProgramacionDAOI programacionDAO;

	public ConfigProgramacionVO findConfigByCine(Integer idCine) {

		String[] dias = new String[] { "LU", "MA", "MI", "JU", "VI", "SA", "DO" };
		List<String> diasSemana = Arrays.asList(dias);
		List<Sala> salas = salaDAO.findByIdCine(idCine);
		List<Pelicula> peliculas = peliculaDAO.findByIdCine(idCine);
		List<Formato> formatos = formatoDAO.findByIdCine(idCine);
		List<Version> versiones = versionDAO.findByIdCine();

		return ConfigProgramacionAssembler.getConfigProgramacionVO(salas, diasSemana, peliculas, formatos, versiones);
	}

	public List<SalaProgramacionVO> findProgramacionOfSala(Integer idCine, Date fecha) {

		List<SalaProgramacionVO> salasProgramacionVO = new ArrayList<SalaProgramacionVO>();
		List<Sala> salas = salaDAO.findByIdCine(idCine);

		for (Sala sala : salas) {
			SalaProgramacionVO salaProgramacionVO = SalaAssembler.getSalaProgramacionVO(sala);
			Map<Integer, PeliculaVO> mapPeliculas = new HashMap<Integer, PeliculaVO>();

			List<Programacion> programaciones = programacionDAO.findByCineSalaAndExhibicion(idCine, sala.getIdSala(),
					fecha);
			for (Programacion programacion : programaciones) {

				if (!mapPeliculas.containsKey(programacion.getPelicula().getIdPelicula())) {
					mapPeliculas.put(programacion.getPelicula().getIdPelicula(),
							PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
				}

				PeliculaVO peliculaVO = mapPeliculas.get(programacion.getPelicula().getIdPelicula());
				ProgramacionVO programacionVO = ProgramacionAssembler.getProgramacionVO(programacion, false);
				peliculaVO.addProgramacionVO(programacionVO);

			}

			List<PeliculaVO> peliculasVO = new ArrayList<PeliculaVO>(mapPeliculas.values());
			salaProgramacionVO.setPeliculasVO(peliculasVO);
			salasProgramacionVO.add(salaProgramacionVO);

		}

		return salasProgramacionVO;
	}

	public ProgramacionVO save(ProgramacionVO programacionVO) {
		Programacion programacion = ProgramacionAssembler.getProgramacion(programacionVO);

		List<Programacion> validacionRangos = programacionDAO.findBySalaDiaAndRangoHorario(programacion.getSala().getIdSala(),
				programacion.getDiaSemana(), programacion.getHorario(),programacion.getHorarioFin(), new Date());
		
		if (!validacionRangos.isEmpty() ) {
			Programacion prog = validacionRangos.get(0);
			return ProgramacionAssembler.getProgramacionVO(prog, false);
		}
		
		List<Programacion> validacionDiaActual = programacionDAO.findBySalaDiaActualAndHorario(programacion.getSala().getIdSala(),
				programacion.getDiaSemana(), programacion.getHorario(),programacion.getHorarioFin(), new Date());
		
		if (!validacionDiaActual.isEmpty() ) {
			Programacion prog = validacionDiaActual.get(0);
			return ProgramacionAssembler.getProgramacionVO(prog, false);
		}
		
		List<Programacion> validacionDiaAnterior = programacionDAO.findBySalaDiaActualAndHorario(programacion.getSala().getIdSala(),
				Fecha.getBeforeDay(programacion.getDiaSemana()), programacion.getHorario(),programacion.getHorarioFin(), new Date());
		
		if (!validacionDiaAnterior.isEmpty() ) {
			Programacion prog = validacionDiaAnterior.get(0);
			return ProgramacionAssembler.getProgramacionVO(prog, false);
		}
		
		programacionDAO.save(programacion);
		return ProgramacionAssembler.getProgramacionVO(programacion, true);
	}

	public void delete(Integer idProgramacion) {
		Programacion programacion = programacionDAO.findById(idProgramacion);
		programacion.setActivo(false);
		programacionDAO.update(programacion);
	}

}