package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;

public interface EmpresaDAOI extends GlobalHibernateDAOI<Empresa>{
	List<Empresa> findByEstatus(Integer idEstatus);
	
}
