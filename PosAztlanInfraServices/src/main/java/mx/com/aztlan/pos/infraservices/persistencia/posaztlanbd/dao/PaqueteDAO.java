package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;


@Repository 
public class PaqueteDAO extends GlobalHibernateDAO<Paquete> implements PaqueteDAOI {

	@Override
	public List<Paquete> findByCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pqt from Paquete pqt join pqt.cine cne ");
		hql.append("where cne.idCine=:idCine and pqt.activo=1 ");
		hql.append("order by pqt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();

	}
	
}