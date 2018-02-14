package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioBoleto;

public interface FolioBoletoDAOI extends GlobalHibernateDAOI<FolioBoleto>{
	List<FolioBoleto> getByTicketAndTipoCliente(Integer idTicket, Integer idTipoCliente, Integer idCine);
}
