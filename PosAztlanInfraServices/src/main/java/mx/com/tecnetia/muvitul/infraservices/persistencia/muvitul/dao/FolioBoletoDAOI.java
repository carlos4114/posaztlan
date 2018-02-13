package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FolioBoleto;

public interface FolioBoletoDAOI extends GlobalHibernateDAOI<FolioBoleto>{
	List<FolioBoleto> getByTicketAndTipoCliente(Integer idTicket, Integer idTipoCliente, Integer idCine);
}
