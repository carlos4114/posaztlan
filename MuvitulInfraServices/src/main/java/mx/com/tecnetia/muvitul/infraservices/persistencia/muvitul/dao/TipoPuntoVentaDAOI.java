package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPuntoVenta;

public interface TipoPuntoVentaDAOI extends GlobalHibernateDAOI<TipoPuntoVenta>{
	TipoPuntoVenta findByClave(String clave);
}
