package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoCliente;

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