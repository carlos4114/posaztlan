package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Regalo;

public interface RegaloDAOI extends GlobalHibernateDAOI<Regalo>{
	
	List<Regalo> findByIdCine(Integer idCine);

}
