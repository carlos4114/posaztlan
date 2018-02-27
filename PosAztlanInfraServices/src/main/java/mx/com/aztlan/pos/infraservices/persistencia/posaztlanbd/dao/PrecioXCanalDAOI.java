package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanal;

public interface PrecioXCanalDAOI extends GlobalHibernateDAOI<PrecioXCanal>{
	
	void delete(Integer idProducto);	

}
