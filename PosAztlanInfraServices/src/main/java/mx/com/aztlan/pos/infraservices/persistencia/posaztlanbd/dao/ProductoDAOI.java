package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;

public interface ProductoDAOI extends GlobalHibernateDAOI<Producto>{

	List<Producto> findByCine(Integer idCine);

	List<Producto> findByEmpresa(Integer idEmpresa);
	
	List<Producto> findByName(Integer idCine, String nombre);
	
	List<Producto> findByIdProducto(Integer idProducto);
}
