package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;

public interface PagoDAOI extends GlobalHibernateDAOI<Pago>{
	
	List<Pago> findByTicketAndCta(Integer idTiccket);
}
