package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXPuntoVenta;

public interface PaqueteXPuntoVentaDAOI extends GlobalHibernateDAOI<PaquetesXPuntoVenta>{

	List<PaquetesXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta);

}
