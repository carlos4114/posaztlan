package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;

public interface CanalDAOI extends GlobalHibernateDAOI<Canal>{
	List<Canal> findByEmpresa(Integer idEmpresa);
	List<Canal> findActivos();
}
