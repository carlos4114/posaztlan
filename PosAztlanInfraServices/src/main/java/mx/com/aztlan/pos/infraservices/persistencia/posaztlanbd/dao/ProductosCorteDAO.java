package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosCorte;

@Repository 
public class ProductosCorteDAO extends GlobalHibernateDAO<ProductosCorte> implements ProductosCorteDAOI {
	
	
	@Override
	public List<ProductosCorte> getProductosCorte(Integer idAlmacen,Integer estatusConteo){
		StringBuilder hql = new StringBuilder();
		hql.append("select prdcort from ProductosCorte prdcort join artcort.almacen alm ");
		hql.append("where alm.idAlmacen=:idAlmacen and prdcort.estatusConteo=:estatusConteo ");
		hql.append("order by prdcort.fecha desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idAlmacen", idAlmacen);
		query.setParameter("estatusConteo",estatusConteo);
		
		List<ProductosCorte> productosCorte = query.list();
		
		return productosCorte;
	}

	@Override
	public Integer updateEstatusConteoByEstatus(Integer idAlmacen,Integer estatusActual,Integer estatusFinal, Integer usuario) {
		StringBuilder hql = new StringBuilder();
		hql.append("update ProductosCorte set estatusConteo=:estatusFinal, usuarioModificacion.idUsuario=:usuario, ultimaModificacion=:fechaModificacion where almacen.idAlmacen=:idAlmacen and estatusConteo=:estatusActual");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idAlmacen", idAlmacen);
		query.setParameter("estatusActual",estatusActual);
		query.setParameter("estatusFinal",estatusFinal);
		query.setParameter("usuario",usuario);
		query.setParameter("fechaModificacion",new Date());
		
		return query.executeUpdate();
	}
	
}