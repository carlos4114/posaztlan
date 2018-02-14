package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ReportesCineXDistribuidora;

@Repository 
public class ReportesCineXDistribuidoraDAO extends GlobalHibernateDAO<ReportesCineXDistribuidora> implements ReportesCineXDistribuidoraDAOI {

	@Override
	public List<ReportesCineXDistribuidora> findActivos() {
		StringBuilder hql = new StringBuilder();
		hql.append("select rcd from ReportesCineXDistribuidora rcd where rcd.activo=1");			
		Query query = getSession().createQuery(hql.toString());
		List<ReportesCineXDistribuidora>  cines = query.list();
		return cines;
	}


}
