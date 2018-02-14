package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;

public interface PaqueteXPuntoVentaDAOI extends GlobalHibernateDAOI<PaquetesXPuntoVenta>{

	List<PaquetesXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta);

}
