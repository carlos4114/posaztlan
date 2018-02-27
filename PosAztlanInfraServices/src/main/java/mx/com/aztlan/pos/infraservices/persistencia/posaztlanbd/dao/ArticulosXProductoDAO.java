package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;


@Repository 
public class ArticulosXProductoDAO extends GlobalHibernateDAO<ArticulosXProducto> implements ArticulosXProductoDAOI {

	/*@Override
	public List<ArticulosXPuntoVenta> findByIdCineAndIdPuntoVenta(Integer idCine,Integer idPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select axpv from ArticulosXPuntoVenta axpv join axpv.puntoVenta pv ");
		hql.append("where pv.cine.idCine=:idCine and pv.idPuntoVenta=:idPuntoVenta ");
		hql.append("order by pv.cine.nombre,pv.nombre,axpv.articulo.nombre asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.list();
	}*/

}