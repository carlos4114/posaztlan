package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;

public interface CineDAOI extends GlobalHibernateDAOI<Cine>{
	List<Cine> findByEmpresa(Integer idEmpresa);
	List<Cine> findActivos();
}
