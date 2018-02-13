package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Formato;

@Repository 
public class FormatoDAO extends GlobalHibernateDAO<Formato> implements FormatoDAOI {

	@Override
	public List<Formato> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select fmt from Formato fmt join fmt.cine cne ");
		hql.append("where cne.idCine=:idCine and fmt.activo=1 ");
		hql.append("order by fmt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}


}
