package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Familia;

public interface FamiliaDAOI extends GlobalHibernateDAOI<Familia>{
	List<Familia> findByIdEmpresa(Integer idEmpresa);
	
}
