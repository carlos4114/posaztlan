package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;


import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CorteCaja;

public interface CorteCajaDAOI extends GlobalHibernateDAOI<CorteCaja>{
	
	List<CorteCaja> getPorCaja(Integer idCaja, Integer maxResults) throws Exception;
	
}
