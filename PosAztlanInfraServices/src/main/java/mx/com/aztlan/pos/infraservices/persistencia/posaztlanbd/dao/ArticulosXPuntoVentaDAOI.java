package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

public interface ArticulosXPuntoVentaDAOI extends GlobalHibernateDAOI<ArticulosXPuntoVenta>{
	List<ArticulosXPuntoVenta> findByIdCineAndIdPuntoVenta(Integer idCine,Integer idPuntoVenta);
	
	List<ArticulosXPuntoVenta> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nameArticulo);
	
	List<ArticulosXPuntoVenta> findByIdArticulo(Integer idArticulo);
	
	List<PuntoVenta> findByIdArticulos(Integer idArticulo);
}
