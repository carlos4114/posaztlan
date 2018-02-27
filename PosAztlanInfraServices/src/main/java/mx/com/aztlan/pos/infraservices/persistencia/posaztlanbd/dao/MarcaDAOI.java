package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Marca;

public interface MarcaDAOI extends GlobalHibernateDAOI<Marca>{
	List<Marca> findByIdEmpresa(Integer idEmpresa);
	
}
