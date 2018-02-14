package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;

public interface EstatusPagoDAOI extends GlobalHibernateDAOI<EstatusPago>{
	
	EstatusPago findByClave(String clave);
	
}
