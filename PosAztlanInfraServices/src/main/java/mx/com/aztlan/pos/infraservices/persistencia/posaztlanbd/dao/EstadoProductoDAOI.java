package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstadoProducto;

public interface EstadoProductoDAOI extends GlobalHibernateDAOI<EstadoProducto>{
	EstadoProducto findByClave(String clave);
	
}
