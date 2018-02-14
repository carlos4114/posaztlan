package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoDevolucion;

public interface TipoDevolucionDAOI extends GlobalHibernateDAOI<TipoDevolucion>{

	List<TipoDevolucion> findByTipoPuntoVenta(Integer idTipoPuntoVenta);
}
