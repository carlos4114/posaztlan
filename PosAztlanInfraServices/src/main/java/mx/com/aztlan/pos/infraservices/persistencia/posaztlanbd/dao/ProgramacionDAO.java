package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;

@Repository
public class ProgramacionDAO extends GlobalHibernateDAO<Programacion> implements ProgramacionDAOI {

	@Override
	public List<Programacion> findByCineDiaAndExhibicion(Integer idCine, String diaSemana, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=:idCine and pgr.diaSemana=:diaSemana and ( :fechaExhibicion between pgr.fechaInicio and pgr.fechaVigencia) and pgr.activo=1 and plc.activo=1 ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("diaSemana", diaSemana);	
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}

	public List<Programacion> findByCineDiaAndExhibicionAndHorario(Integer idCine, String diaSemana, Date fechaExhibicion, Date horario) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=:idCine and pgr.diaSemana=:diaSemana and ( :fechaExhibicion between pgr.fechaInicio and pgr.fechaVigencia) ");
		hql.append("and pgr.horario >= :horario and pgr.activo=1 and plc.activo=1 ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("diaSemana", diaSemana);	
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		query.setParameter("horario", horario);
		
		return query.list();
	}
	
	@Override
	public List<Programacion> findBySalaDiaAndExhibicionAll(Integer idSala, String diaSemana, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.sala sla ");
		hql.append("where sla.idSala=:idSala and pgr.diaSemana=:diaSemana  and ( :fechaExhibicion between pgr.fechaInicio and pgr.fechaVigencia) ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idSala", idSala);
		query.setParameter("diaSemana", diaSemana);
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}
	
	@Override
	public List<Programacion> findByCineSalaAndExhibicion(Integer idCine,Integer idSala, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.pelicula plc inner join pgr.formato frm inner join pgr.version vrs inner join pgr.sala sla ");
		hql.append("where plc.cine.idCine=:idCine and sla.idSala=:idSala  and pgr.fechaVigencia>=:fechaExhibicion and pgr.activo=1 and plc.activo=1 ");
		hql.append("order by pgr.horario asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idSala", idSala);
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}

	
	@Override
	public List<Programacion> findBySalaDiaAndRangoHorario(Integer idSala, String diaSemana, Date horario, Date horarioFin , Date today) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.sala sla ");
		hql.append("where sla.idSala =:idSala and pgr.diaSemana=:diaSemana  ");
		hql.append("and pgr.fechaVigencia>=:today and pgr.activo=1 ");
		hql.append("and (:horario between pgr.horario and pgr.horarioFin or :horarioFin between pgr.horario and pgr.horarioFin ) ");
		hql.append("order by pgr.horario asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idSala", idSala);
		query.setParameter("diaSemana", diaSemana);
		query.setParameter("today", today);	
		query.setParameter("horario", horario);	
		query.setParameter("horarioFin", horarioFin);	

		return query.list();
	}

	@Override
	public List<Programacion> findBySalaDiaActualAndHorario(Integer idSala, String diaSemana, Date horario,Date horarioFin, Date today) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pgr from Programacion pgr inner join pgr.sala sla ");
		hql.append("where sla.idSala =:idSala and pgr.diaSemana=:diaSemana  ");
		hql.append("and pgr.fechaVigencia>=:today and pgr.activo=1 and pgr.horario > pgr.horarioFin ");
		hql.append("and (:horario >= pgr.horario or :horarioFin >= pgr.horario or  :horario <= pgr.horarioFin or :horarioFin <= pgr.horarioFin ) ");
		hql.append("order by pgr.horario asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idSala", idSala);
		query.setParameter("diaSemana", diaSemana);
		query.setParameter("today", today);	
		query.setParameter("horario", horario);	
		query.setParameter("horarioFin", horarioFin);	
		
		return query.list();
	}

}
