package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DevolucionXProducto;

public interface DevolucionXProductoDAOI extends GlobalHibernateDAOI<DevolucionXProducto>{
	List<DevolucionXProducto> findByTicket (Integer idTicket);
}
