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



}
