package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;

public interface PaqueteXTicketDAOI extends GlobalHibernateDAOI<PaquetesXTicket>{
	
	List <PaquetesXTicket> findByTicket (Integer idTicket , Integer idTipoPuntoVenta);
	
}
