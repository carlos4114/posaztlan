package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXTicket;

@Repository 
public class PaqueteXTicketDAO extends GlobalHibernateDAO<PaquetesXTicket> implements PaqueteXTicketDAOI {

	@Override
	public List<PaquetesXTicket> findByTicket(Integer idTicket, Integer idTipoPuntoVenta) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pxt from PaquetesXTicket pxt join pxt.ticketVenta tv join pxt.paquete pqt ");
		hql.append("where tv.idTicket=:idTicket ");
		hql.append("order by pqt.idPaquete asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		return 	query.list();
	}


}
