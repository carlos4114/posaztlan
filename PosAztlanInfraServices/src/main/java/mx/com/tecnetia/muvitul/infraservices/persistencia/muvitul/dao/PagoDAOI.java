package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;

public interface PagoDAOI extends GlobalHibernateDAOI<Pago>{
	
	List<Pago> findByTicketAndCta(Integer idTiccket);
}
