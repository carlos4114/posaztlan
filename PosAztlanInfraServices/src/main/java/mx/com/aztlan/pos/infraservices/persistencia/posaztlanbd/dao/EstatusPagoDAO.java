package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;

@Repository 
public class EstatusPagoDAO extends GlobalHibernateDAO<EstatusPago> implements EstatusPagoDAOI {

	@Override
	public EstatusPago findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select edp from EstatusPago edp  ");
		hql.append("where edp.clave=:clave ");
		hql.append("order by edp.idEstatus desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<EstatusPago>  estatusPago = query.list();
		
		if (estatusPago!= null && !estatusPago.isEmpty()){
			return estatusPago.get(0);
		}
		
		return null;
	}


}
