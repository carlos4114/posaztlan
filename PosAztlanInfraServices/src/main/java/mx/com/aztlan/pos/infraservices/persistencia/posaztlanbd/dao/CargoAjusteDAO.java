package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CargoAjuste;

@Repository 
public class CargoAjusteDAO extends GlobalHibernateDAO<CargoAjuste> implements CargoAjusteDAOI {

	@SuppressWarnings("unchecked")
	@Override
	public List<CargoAjuste> getActivos() {

		Criteria criteria = getSession().createCriteria(CargoAjuste.class);
		
		criteria.add(Restrictions.eq("activo", true));
		criteria.addOrder(Order.asc("nombre"));
		
		return criteria.list();

	}
	
}