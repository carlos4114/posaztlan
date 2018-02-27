package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaquete;

public interface ProductosXPaqueteDAOI extends GlobalHibernateDAOI<ProductosXPaquete>{

	List<ProductosXPaquete> findByIdPaquete(Integer idPaquete);
	
}
