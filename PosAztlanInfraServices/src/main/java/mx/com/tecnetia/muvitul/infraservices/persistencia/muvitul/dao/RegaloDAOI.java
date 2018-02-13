package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Regalo;

public interface RegaloDAOI extends GlobalHibernateDAOI<Regalo>{
	
	List<Regalo> findByIdCine(Integer idCine);

}
