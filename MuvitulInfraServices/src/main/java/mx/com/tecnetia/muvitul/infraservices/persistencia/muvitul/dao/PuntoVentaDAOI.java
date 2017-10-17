package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;

public interface PuntoVentaDAOI extends GlobalHibernateDAOI<PuntoVenta>{
	List<PuntoVenta> findByIdCine(Integer idCine);
}
