package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

public interface PuntoVentaDAOI extends GlobalHibernateDAOI<PuntoVenta>{
	List<PuntoVenta> findByIdCine(Integer idCine);
	
	List<PuntoVenta> findByIdCineDulceria(Integer idCine);
	
	List<PuntoVenta> findByIdPuntoVenta(Integer idPuntoVenta);
	
	List<PuntoVenta> findByIdArticulo(Integer idArticulo);
}
