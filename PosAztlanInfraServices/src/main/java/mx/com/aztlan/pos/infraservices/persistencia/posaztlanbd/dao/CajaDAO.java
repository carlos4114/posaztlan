package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Caja;

@Repository 
public class CajaDAO extends GlobalHibernateDAO<Caja> implements CajaDAOI {

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> getActivos(Integer idAlmacen) {

		Criteria criteria = getSession().createCriteria(Caja.class);
		
		criteria.add(Restrictions.eq("activo", true));
		criteria.add(Restrictions.eq("almacen.idAlmacen", idAlmacen));
		criteria.addOrder(Order.asc("nombre"));
		
		return criteria.list();

	}
	
}