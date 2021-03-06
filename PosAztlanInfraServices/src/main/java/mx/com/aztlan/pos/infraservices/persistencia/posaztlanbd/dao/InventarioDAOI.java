package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.math.BigDecimal;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;

public interface InventarioDAOI extends GlobalHibernateDAOI<Inventario>{
		
	List<Inventario> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nombreArticulo);
	List<Inventario> findByIdArticuloAndFirtsIn(Integer idPuntoVenta, Integer idArticulo);
	List<Inventario> findByIdProductoAndLastOut(Integer idAlmacen,Integer idProducto);
	List<Inventario> findByArticuloByProveedor(Integer idPuntoVenta,Integer idArticulo,Integer idProveedor);
	BigDecimal getCostoUltimasSalidasByArticulo(Integer idPuntoVenta, Integer idArticulo);
	List<Inventario> findByIdPuntoVentaWithOutCount(Integer idPuntoVenta, String nombreArticulo);
	List<Inventario> findByArticuloByProveedores(Integer idPuntoVenta,Integer idArticulo);
	BigDecimal getPrecioUnitario(Integer idArticulo);
	
	List<Inventario> findByAlmacen(Integer idAlmacen);
	List<Inventario> findByCanal(Integer idCanal);
}
