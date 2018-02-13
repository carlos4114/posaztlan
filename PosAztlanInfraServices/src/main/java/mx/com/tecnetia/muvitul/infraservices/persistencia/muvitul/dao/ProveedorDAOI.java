package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Proveedor;

public interface ProveedorDAOI extends GlobalHibernateDAOI<Proveedor>{
	List<Proveedor> findByIdCine(Integer idCine);
}
