package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;

public interface ProveedorDAOI extends GlobalHibernateDAOI<Proveedor>{
	List<Proveedor> findByIdCine(Integer idCine);
}
