package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Paquete;

public interface PaqueteDAOI extends GlobalHibernateDAOI<Paquete>{

	List<Paquete> findByCine(Integer idCine);

}
