package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;

@Repository 
public class PagoDAO extends GlobalHibernateDAO<Pago> implements PagoDAOI {

	@Override
	public List<Pago> findByTicketAndCta(Integer idTicket) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pgs from Pago pgs ");
		hql.append("where pgs.ticketVenta.idTicket=:idTicket and pgs.noCuenta != '' and pgs.noCuenta is not null " );
		hql.append("order by pgs.importe desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		return  query.list();

	}

}
