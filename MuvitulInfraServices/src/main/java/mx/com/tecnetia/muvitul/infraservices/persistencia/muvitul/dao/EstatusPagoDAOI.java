package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;

public interface EstatusPagoDAOI extends GlobalHibernateDAOI<EstatusPago>{
	
	EstatusPago findByClave(String clave);
	
}
