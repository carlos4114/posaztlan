package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ClasificacionArt;

@Repository 
public class ClasificacionArtDAO extends GlobalHibernateDAO<ClasificacionArt> implements ClasificacionArtDAOI {

	@Override
	public List<ClasificacionArt> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ca from ClasificacionArt ca ");
		hql.append("where ca.cine.idCine=:idCine ");
		hql.append("order by ca.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		//List<ClasificacionArt> result= query.list();
		return query.list();
	}


}