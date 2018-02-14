package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Version;

public interface VersionDAOI extends GlobalHibernateDAOI<Version>{
	
	List<Version> findByIdCine();


}
