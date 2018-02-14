package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;

public interface ProgramacionDAOI  extends GlobalHibernateDAOI<Programacion>{
	List<Programacion> findByCineDiaAndExhibicion(Integer idCine, String diaSemana,  Date fechaExhibicion);
	List<Programacion> findByCineDiaAndExhibicionAndHorario(Integer idCine, String diaSemana,  Date fechaExhibicion, Date Horario);
	List<Programacion> findByCineSalaAndExhibicion(Integer idCine, Integer idSala, Date fechaExhibicion);
	List<Programacion> findBySalaDiaAndExhibicionAll(Integer idSala, String diaSemana, Date fechaExhibicion);
	List<Programacion> findBySalaDiaAndRangoHorario(Integer idSala, String diaSemana, Date horario, Date horarioFin, Date today);
	List<Programacion> findBySalaDiaActualAndHorario(Integer idSala, String diaSemana, Date horario, Date horarioFin, Date today);
}
