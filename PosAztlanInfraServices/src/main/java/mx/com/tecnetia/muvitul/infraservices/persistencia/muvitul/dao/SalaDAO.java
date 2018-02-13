package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;

@Repository 
public class SalaDAO extends GlobalHibernateDAO<Sala> implements SalaDAOI {

	@Override
	public List<Sala> findByIdCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select sla from Sala sla join sla.cine cne ");
		hql.append("where cne.idCine=:idCine and sla.activo=1 ");
		hql.append("order by sla.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}
	
	@Override
	public List<Sala> findAllByIdCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select sla from Sala sla join sla.cine cne ");
		hql.append("where cne.idCine=:idCine ");
		hql.append("order by sla.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}
	
	@Override
	public List<Sala> findByNombre(Integer idCine, String nombre) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select sla from Sala sla join sla.cine cne ");
		hql.append(" where cne.idCine=:idCine and sla.nombre=:nombre ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("nombre", nombre);
		
		return query.list();
	}
	
	@Override
	public boolean findNombreRepetido(Integer idCine, Integer idSala, String nombre) {
		
		StringBuilder hql = new StringBuilder();
		nombre = nombre.toUpperCase();
		hql.append("select sla from Sala sla join sla.cine cne ");
		hql.append(" where cne.idCine=:idCine and upper(sla.nombre)=:nombre and sla.idSala <> :idSala");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("nombre", nombre);
		query.setParameter("idSala", idSala);
		
		List<Sala> salas = query.list();
		return salas.size()>0;
	}



}
