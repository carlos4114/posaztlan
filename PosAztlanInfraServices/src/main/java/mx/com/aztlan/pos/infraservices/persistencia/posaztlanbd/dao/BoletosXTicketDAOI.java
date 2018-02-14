package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.BoletosXTicket;

public interface BoletosXTicketDAOI extends GlobalHibernateDAOI<BoletosXTicket>{
	long sumByProgramacion(Integer idProgramacion, Date fechaExhibicion );
//	List<BoletosXTicket> findByTicket(Integer idTicket);
}
