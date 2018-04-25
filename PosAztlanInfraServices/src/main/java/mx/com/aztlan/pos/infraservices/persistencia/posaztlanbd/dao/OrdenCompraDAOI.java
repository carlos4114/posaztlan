package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;

public interface OrdenCompraDAOI extends GlobalHibernateDAOI<OrdenCompra>{

	List<OrdenCompra> findByIdOrdenCompra(Integer idOrdenCompra);
	
	Integer getId(Integer idEmpresa, Integer folio);
}
