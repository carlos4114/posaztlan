package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Formato;

public interface FormatoDAOI extends GlobalHibernateDAOI<Formato>{
	
	List<Formato> findByIdCine(Integer idCine);

}
