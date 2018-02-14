package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CupoXSala;

public interface CupoXSalaDAOI extends GlobalHibernateDAOI<CupoXSala>{
	CupoXSala findByIdSala (Integer idSala);
}
