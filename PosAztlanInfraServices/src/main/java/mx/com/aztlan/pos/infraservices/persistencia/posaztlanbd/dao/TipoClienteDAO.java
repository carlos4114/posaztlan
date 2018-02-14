package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoCliente;

@Repository 
public class TipoClienteDAO extends GlobalHibernateDAO<TipoCliente> implements TipoClienteDAOI {

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCliente> getTipoClientesOrdered() {

		Criteria criteria = getSession().createCriteria(TipoCliente.class);
		
		criteria.add(Restrictions.eq("activo", true));	
		criteria.addOrder(Order.asc("idTipoCliente"));
		
		return criteria.list();

	}
	
}