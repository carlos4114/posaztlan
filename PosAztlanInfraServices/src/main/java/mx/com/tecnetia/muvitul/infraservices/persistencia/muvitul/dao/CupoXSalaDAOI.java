package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;

public interface CupoXSalaDAOI extends GlobalHibernateDAOI<CupoXSala>{
	CupoXSala findByIdSala (Integer idSala);
}
