package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CorteCaja;

@Repository 
public class CorteCajaDAO extends GlobalHibernateDAO<CorteCaja> implements CorteCajaDAOI {
	

	@SuppressWarnings("unchecked")
	@Override
	public List<CorteCaja> getPorCaja(Integer idCaja, Integer maxResults) throws Exception {

		Criteria criteria = getSession().createCriteria(CorteCaja.class);
		
		criteria.add(Restrictions.eq("caja.idCaja", idCaja));
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("fecha"));
		
		return criteria.list();
	}
	 
}