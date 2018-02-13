package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.FormaPago;

public interface FormaPagoDAOI extends GlobalHibernateDAOI<FormaPago>{
	FormaPago findByClave(String clave);
}
