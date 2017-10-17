package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosXPuntoVenta;

public interface ArticulosXPuntoVentaDAOI extends GlobalHibernateDAOI<ArticulosXPuntoVenta>{
	List<ArticulosXPuntoVenta> findByIdCineAndIdPuntoVenta(Integer idCine,Integer idPuntoVenta);
	List<ArticulosXPuntoVenta> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nameArticulo);
}
