package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioBoleto;

@Repository 
public class FolioBoletoDAO extends GlobalHibernateDAO<FolioBoleto> implements FolioBoletoDAOI {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FolioBoleto> getByTicketAndTipoCliente(Integer idTicket, Integer idTipoCliente, Integer idCine){
		Criteria criteria = getSession().createCriteria(FolioBoleto.class);
		
		criteria.add(Restrictions.eq("ticketVenta.idTicket", idTicket));
		criteria.add(Restrictions.eq("tipoCliente.idTipoCliente", idTipoCliente));
		criteria.add(Restrictions.eq("cine.idCine", idCine));
		
		return criteria.list();
	
	}
}
