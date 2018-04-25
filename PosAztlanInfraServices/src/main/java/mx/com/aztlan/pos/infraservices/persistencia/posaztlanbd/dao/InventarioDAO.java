package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

@Repository 
public class InventarioDAO extends GlobalHibernateDAO<Inventario> implements InventarioDAOI {

	
	@Override
	public List<Inventario> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nameArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv.articulo,sum(inv.cantidad),avg(inv.importe),sum(inv.existenciaActual) from Inventario inv  ");
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.nombre like :nameArticulo " );
		hql.append("group by inv.articulo.idArticulo ");
		hql.append("order by inv.articulo.nombre");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("nameArticulo", "%"+nameArticulo+"%");
		
		List result = query.list();		
		
		List<Inventario> inventarios = new ArrayList<Inventario>();
		Inventario inventario=null;
		Object[] ob = null;
		for(Object obj: result){
			ob = (Object[]) obj;
			inventario = new Inventario();
			inventario.setProducto((Producto)ob[0]);
			inventario.setCantidad((long) ob[1]);
			inventario.setImporte(new BigDecimal ((double)(ob[2])));
			inventario.setExistenciaActual((long) ob[3]);			
			inventarios.add(inventario);
		}
		
		return inventarios;		
	}
		
	@Override
	public List<Inventario> findByArticuloByProveedores(Integer idPuntoVenta,Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv.proveedor,inv.articulo,sum(inv.cantidad),avg(inv.importe),sum(inv.existenciaActual)  from Inventario inv  ");
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.idArticulo = :idArticulo " );
		hql.append("and inv.existenciaActual > 0 ");
		hql.append("group by inv.proveedor.idProveedor ");
		hql.append("order by inv.articulo.nombre,inv.fecha, inv.proveedor.nombre asc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("idArticulo", idArticulo);
		
		List result = query.list();		
		
		List<Inventario> inventarios = new ArrayList<Inventario>();
		Inventario inventario=null;
		Object[] ob = null;
		for(Object obj: result){
			ob = (Object[]) obj;
			inventario = new Inventario();
			inventario.setProveedor((Proveedor)ob[0]);
			inventario.setProducto((Producto)ob[1]);
			inventario.setCantidad((long) ob[2]);
			inventario.setImporte(new BigDecimal ((double)(ob[3])));
			inventario.setExistenciaActual((long) ob[4]);
			inventarios.add(inventario);
		}
						
		return inventarios;		
	}
	
	@Override
	public List<Inventario> findByIdArticuloAndFirtsIn(Integer idPuntoVenta,Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv from Inventario inv  ");
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.idArticulo = :idArticulo " );
		hql.append("and inv.existenciaActual > 0 ");
		hql.append("order by inv.fecha asc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("idArticulo", idArticulo);
				
		List<Inventario> inventarios = query.list();

						
		return inventarios;		
	}
	
	@Override
	public List<Inventario> findByIdArticuloAndLastOut(Integer idPuntoVenta,Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv from Inventario inv  ");
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.idArticulo = :idArticulo " );
		hql.append("and inv.existenciaActual < inv.cantidad ");
		hql.append("order by inv.fecha desc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("idArticulo", idArticulo);
				
		List<Inventario> inventarios = query.list();
						
		return inventarios;		
	}
	
	@Override
	public List<Inventario> findByArticuloByProveedor(Integer idPuntoVenta,Integer idArticulo,Integer idProveedor) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv from Inventario inv  ");
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.idArticulo = :idArticulo " );
		hql.append("and existenciaActual > 0 and inv.proveedor.idProveedor= :idProveedor ");
		hql.append("order by inv.fecha asc");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("idArticulo", idArticulo);
		query.setParameter("idProveedor", idProveedor);
		
		List<Inventario>  inventario = query.list();
						
		return inventario;		
	}
	
	@Override
	public BigDecimal getCostoUltimasSalidasByArticulo(Integer idPuntoVenta, Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select sum(mov.importe) from MovimientoInventario mov ");
		hql.append("where mov.puntoVenta.idPuntoVenta = :idPuntoVenta and mov.articulo.idArticulo = :idArticulo " );
		hql.append("and mov.tipoMovimientoInv.esEntrada = false and mov.inventario.existenciaActual > 0 ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("idArticulo", idArticulo);
		
		List result = query.list();
		BigDecimal importe = new BigDecimal(0);
		
		for(Object obj: result){			
			if(obj!=null){
				importe = importe.add((BigDecimal)obj);
				break;
			}
		}
		
		return importe;
	}
	
	@Override
	public List<Inventario> findByIdPuntoVentaWithOutCount(Integer idPuntoVenta, String nameArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv.articulo,sum(inv.cantidad),avg(inv.importe),sum(inv.existenciaActual),inv.puntoVenta from Inventario inv  ");		
		hql.append("where inv.puntoVenta.idPuntoVenta = :idPuntoVenta and  inv.articulo.nombre like :nameArticulo " );
		hql.append("and inv.articulo not in (select ac.articulo from ArticulosCorte ac where ac.estatusConteo = 0) ");
		hql.append("group by inv.articulo.idArticulo ");
		hql.append("order by inv.articulo.nombre");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("nameArticulo", "%"+nameArticulo+"%");
		
		List result = query.list();		
		
		List<Inventario> inventarios = new ArrayList<Inventario>();
		Inventario inventario=null;
		Object[] ob = null;
		for(Object obj: result){
			ob = (Object[]) obj;
			inventario = new Inventario();
			inventario.setProducto((Producto)ob[0]);
			inventario.setCantidad((long) ob[1]);
			inventario.setImporte(new BigDecimal ((double)(ob[2])));
			inventario.setExistenciaActual((long) ob[3]);
			inventario.setAlmacen((Almacen)ob[4]);
			inventarios.add(inventario);
		}
						
		return inventarios;
	}
	
	@Override
	public BigDecimal getPrecioUnitario(Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select inv.importe/inv.cantidad from Inventario inv ");
		hql.append("where inv.articulo.idArticulo = :idArticulo " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idArticulo", idArticulo);
		
		List result = query.list();
		BigDecimal importe = new BigDecimal(0);
		
		for(Object obj: result){			
			if(obj!=null){
				importe = importe.add((BigDecimal)obj);
				break;
			}
		}
		
		return importe;
	}
	
}
