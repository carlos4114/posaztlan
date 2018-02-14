package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.BoletosXTicket;

@Repository 
public class BoletosXTicketDAO extends GlobalHibernateDAO<BoletosXTicket> implements BoletosXTicketDAOI {

	@Override
	public long  sumByProgramacion(Integer idProgramacion, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select sum(bxt.cantidad)  from BoletosXTicket bxt join bxt.programacion pgr ");
		hql.append("where pgr.idProgramacion=:idProgramacion and bxt.fechaExhibicion=:fechaExhibicion and bxt.activo=1 and pgr.activo=1" );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProgramacion", idProgramacion);
		query.setParameter("fechaExhibicion", fechaExhibicion);
		Long result=(Long) query.uniqueResult();
		if (result==null){
			return 0;
		}
		return result ;
			
	}

//	@Override
//	public List<BoletosXTicket> findByTicket(Integer idTicket) {
//		StringBuilder hql = new StringBuilder();
//		hql.append("select bxt from BoletosXTicket bxt join bxt.tipoCliente tdc ");
//		hql.append("where bxt.ticketVenta.idTicket=:idTicket " );
//		hql.append("order by tdc.idTipoCliente asc ");
//
//		Query query = getSession().createQuery(hql.toString());
//		query.setParameter("idTicket", idTicket);
//		return  query.list();
//	}


}
