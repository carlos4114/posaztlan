package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Paquete;

public interface PaqueteDAOI extends GlobalHibernateDAOI<Paquete>{

	List<Paquete> findByCine(Integer idCine);

}
