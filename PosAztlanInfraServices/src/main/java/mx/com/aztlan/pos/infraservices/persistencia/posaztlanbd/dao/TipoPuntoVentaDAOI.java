package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoPuntoVenta;

public interface TipoPuntoVentaDAOI extends GlobalHibernateDAOI<TipoPuntoVenta>{
	TipoPuntoVenta findByClave(String clave);
}
