package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CorteCaja;

public interface CorteCajaDAOI extends GlobalHibernateDAOI<CorteCaja>{
	
	List<CorteCaja> getPorCaja(Integer idCaja, Integer maxResults) throws Exception;
	
}
