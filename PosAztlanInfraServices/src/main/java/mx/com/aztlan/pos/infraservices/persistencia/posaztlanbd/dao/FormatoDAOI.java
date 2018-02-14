package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Formato;

public interface FormatoDAOI extends GlobalHibernateDAOI<Formato>{
	
	List<Formato> findByIdCine(Integer idCine);

}
