package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Caja;

@Repository 
public class CajaDAO extends GlobalHibernateDAO<Caja> implements CajaDAOI {

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> getActivos(Integer idPuntoVenta) {

		Criteria criteria = getSession().createCriteria(Caja.class);
		
		criteria.add(Restrictions.eq("activo", true));
		criteria.add(Restrictions.eq("puntoVenta.idPuntoVenta", idPuntoVenta));
		criteria.addOrder(Order.asc("nombre"));
		
		return criteria.list();

	}
	
}