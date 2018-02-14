package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;

public interface FormaPagoDAOI extends GlobalHibernateDAOI<FormaPago>{
	FormaPago findByClave(String clave);
}
