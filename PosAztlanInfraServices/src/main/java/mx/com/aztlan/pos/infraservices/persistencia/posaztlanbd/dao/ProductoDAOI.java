package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;

public interface ProductoDAOI extends GlobalHibernateDAOI<Producto>{

	List<Producto> findByCine(Integer idCine);

	List<Producto> findByEmpresa(Integer idEmpresa);
	
	List<Producto> findByName(String nombre, Integer idEmpresa);
	
	List<Producto> findByIdProducto(Integer idProducto);
	
	List<Producto> findByFiltros(Integer idEmpresa, Integer idFamilia, 
			Integer idMarca, Integer idTipoProducto, Integer idMedida, String nombre);
	
	List<Producto> findBySku(String sku, Integer idEmpresa);
}
