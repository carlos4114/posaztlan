package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PropiedadConfig;

public interface PropiedadConfigDAOI extends GlobalHibernateDAOI<PropiedadConfig>{
	List<PropiedadConfig> findByName(String nombre);
}
