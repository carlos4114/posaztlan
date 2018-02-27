package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;

public interface UnidadMedidaDAOI extends GlobalHibernateDAOI<UnidadMedida>{
	List<UnidadMedida> findAll();
	
	List<UnidadMedida> findByIdEmpresa(Integer idEmpresa);
	
}
