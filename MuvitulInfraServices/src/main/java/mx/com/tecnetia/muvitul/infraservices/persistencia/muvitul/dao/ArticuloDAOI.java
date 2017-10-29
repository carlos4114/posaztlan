package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Articulo;

public interface ArticuloDAOI extends GlobalHibernateDAOI<Articulo>{

	List<Articulo> getDisponible(Integer idPuntoVenta);

}
