package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPuntoVenta;

public interface ProductoXPuntoVentaDAOI extends GlobalHibernateDAOI<ProductosXPuntoVenta>{

	List<ProductosXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta);

	List<ProductosXPuntoVenta> findByIdProducto(Integer idProducto);
}
