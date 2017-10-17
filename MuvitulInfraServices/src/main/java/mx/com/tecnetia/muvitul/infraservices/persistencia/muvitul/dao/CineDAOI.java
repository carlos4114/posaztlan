package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;

public interface CineDAOI extends GlobalHibernateDAOI<Cine>{
	List<Cine> findByEmpresa(Integer idEmpresa);
}
