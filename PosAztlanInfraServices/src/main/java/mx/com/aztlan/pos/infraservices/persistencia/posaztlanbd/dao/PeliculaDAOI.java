package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pelicula;

public interface PeliculaDAOI extends GlobalHibernateDAOI<Pelicula>{

	List<Pelicula> findByIdCine(Integer idCine);

}
