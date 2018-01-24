package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;

public interface ProgramacionDAOI  extends GlobalHibernateDAOI<Programacion>{
	List<Programacion> findByCineDiaAndExhibicion(Integer idCine, String diaSemana,  Date fechaExhibicion);
	List<Programacion> findByCineDiaAndExhibicionAndHorario(Integer idCine, String diaSemana,  Date fechaExhibicion, Date Horario);
	List<Programacion> findByCineSalaAndExhibicion(Integer idCine, Integer idSala, Date fechaExhibicion);
	List<Programacion> findBySalaDiaAndExhibicionAll(Integer idSala, String diaSemana, Date fechaExhibicion);
	List<Programacion> findBySalaDiaAndRangoHorario(Integer idSala, String diaSemana, Date horario, Date horarioFin, Date today);
	List<Programacion> findBySalaDiaActualAndHorario(Integer idSala, String diaSemana, Date horario, Date horarioFin, Date today);
}
