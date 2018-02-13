package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;

@Repository 
public class RegaloDAO extends GlobalHibernateDAO<Regalo> implements RegaloDAOI {

	@Override
	public List<Regalo> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select rgl from Regalo rgl join rgl.cine cne ");
		hql.append("where cne.idCine=:idCine ");
		hql.append("order by rgl.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}


}
