package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PropiedadConfig;

public interface PropiedadConfigDAOI extends GlobalHibernateDAOI<PropiedadConfig>{
	List<PropiedadConfig> findByName(String nombre);
}
