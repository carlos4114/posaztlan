package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pelicula;

public interface PeliculaDAOI extends GlobalHibernateDAOI<Pelicula>{

	List<Pelicula> findByIdCine(Integer idCine);

}
