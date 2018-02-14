package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXTicket;

public interface PaqueteXTicketDAOI extends GlobalHibernateDAOI<PaquetesXTicket>{
	
	List <PaquetesXTicket> findByTicket (Integer idTicket , Integer idTipoPuntoVenta);
	
}
