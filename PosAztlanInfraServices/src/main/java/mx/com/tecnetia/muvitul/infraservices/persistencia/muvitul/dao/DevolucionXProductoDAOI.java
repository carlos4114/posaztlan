package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.DevolucionXProducto;

public interface DevolucionXProductoDAOI extends GlobalHibernateDAOI<DevolucionXProducto>{
	List<DevolucionXProducto> findByTicket (Integer idTicket);
}
