package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPuntoVenta;

public interface ProductoXPuntoVentaDAOI extends GlobalHibernateDAOI<ProductosXPuntoVenta>{

	List<ProductosXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta);

}
