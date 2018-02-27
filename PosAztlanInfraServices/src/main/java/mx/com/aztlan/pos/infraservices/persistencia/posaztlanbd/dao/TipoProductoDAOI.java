package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoProducto;

public interface TipoProductoDAOI extends GlobalHibernateDAOI<TipoProducto>{
	List<TipoProducto> findByIdEmpresa(Integer idEmpresa);
	
}
