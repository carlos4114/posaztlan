package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;

public interface ProductoDAOI extends GlobalHibernateDAOI<Producto>{

	List<Producto> findByCine(Integer idCine);

}
