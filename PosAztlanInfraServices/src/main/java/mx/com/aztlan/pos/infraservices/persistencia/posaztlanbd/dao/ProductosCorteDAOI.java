package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosCorte;

public interface ProductosCorteDAOI extends GlobalHibernateDAOI<ProductosCorte>{
	
	List<ProductosCorte> getProductosCorte(Integer idAlmacen,Integer estatusConteo);
	Integer updateEstatusConteoByEstatus(Integer idAlmacen,Integer estatusActual,Integer estatusFinal, Integer usuario);
	
}
