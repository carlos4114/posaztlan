package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ClasificacionArt;

public interface ClasificacionArtDAOI extends GlobalHibernateDAOI<ClasificacionArt>{
	List<ClasificacionArt> findByIdCine(Integer idCine);
}
