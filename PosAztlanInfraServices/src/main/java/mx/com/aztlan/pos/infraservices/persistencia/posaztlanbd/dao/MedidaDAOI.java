package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Medida;

public interface MedidaDAOI extends GlobalHibernateDAOI<Medida>{
	List<Medida> findByIdEmpresa(Integer idEmpresa);
	
}
