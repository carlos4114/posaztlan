package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.math.BigDecimal;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Inventario;

public interface InventarioDAOI extends GlobalHibernateDAOI<Inventario>{
		
	List<Inventario> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nombreArticulo);
	List<Inventario> findByIdArticuloAndFirtsIn(Integer idPuntoVenta, Integer idArticulo);
	List<Inventario> findByIdArticuloAndLastOut(Integer idPuntoVenta,Integer idArticulo);
	List<Inventario> findByArticuloByProveedor(Integer idPuntoVenta,Integer idArticulo,Integer idProveedor);
	BigDecimal getCostoUltimasSalidasByArticulo(Integer idPuntoVenta, Integer idArticulo);
	List<Inventario> findByIdPuntoVentaWithOutCount(Integer idPuntoVenta, String nombreArticulo);
	List<Inventario> findByArticuloByProveedores(Integer idPuntoVenta,Integer idArticulo);
	
}
