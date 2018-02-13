package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PropiedadConfig;

@Repository 
public class PropiedadConfigDAO extends GlobalHibernateDAO<PropiedadConfig> implements PropiedadConfigDAOI {

	@Override
	public List<PropiedadConfig> findByName(String nombre) {

		StringBuilder hql = new StringBuilder();
		hql.append("select pc from PropiedadConfig pc ");
		hql.append("where pc.nombre=:nombre ");
		hql.append("order by pc.idPropiedadConfig asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("nombre", nombre);

		return query.list();
	}


}
