package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Version;

@Repository 
public class VersionDAO extends GlobalHibernateDAO<Version> implements VersionDAOI {

	@Override
	public List<Version> findByIdCine() {
		StringBuilder hql = new StringBuilder();
		hql.append("select vrs from Version vrs ");
		hql.append("where vrs.activo=1 ");
		hql.append("order by vrs.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		
		return query.list();
	}

}
