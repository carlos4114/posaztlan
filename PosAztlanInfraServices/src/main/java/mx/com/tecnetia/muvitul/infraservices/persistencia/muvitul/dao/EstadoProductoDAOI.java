package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstadoProducto;

public interface EstadoProductoDAOI extends GlobalHibernateDAOI<EstadoProducto>{
	EstadoProducto findByClave(String clave);
	
}
