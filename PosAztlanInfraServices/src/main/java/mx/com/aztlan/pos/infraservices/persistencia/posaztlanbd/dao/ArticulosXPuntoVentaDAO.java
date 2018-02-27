package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

@Repository 
public class ArticulosXPuntoVentaDAO extends GlobalHibernateDAO<ArticulosXPuntoVenta> implements ArticulosXPuntoVentaDAOI {

	@Override
	public List<ArticulosXPuntoVenta> findByIdCineAndIdPuntoVenta(Integer idCine,Integer idPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select axpv from ArticulosXPuntoVenta axpv join axpv.puntoVenta pv ");
		hql.append("where pv.cine.idCine=:idCine and pv.idPuntoVenta=:idPuntoVenta ");
		hql.append("order by pv.cine.nombre,pv.nombre,axpv.articulo.nombre asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.list();
	}

	@Override
	public List<ArticulosXPuntoVenta> findByIdPuntoVentaAndNameArticulo(Integer idPuntoVenta, String nameArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select axpv from ArticulosXPuntoVenta axpv join axpv.puntoVenta pv ");
		hql.append("where pv.idPuntoVenta=:idPuntoVenta and axpv.articulo.nombre like :nameArticulo ");
		hql.append("order by axpv.articulo.nombre ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("nameArticulo", "%"+nameArticulo+"%");
		
		return query.list();
	}
	
	@Override
	public List<ArticulosXPuntoVenta> findByIdArticulo(Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select axpv from ArticulosXPuntoVenta axpv ");
		hql.append("where axpv.articulo.idArticulo=:idArticulo ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idArticulo", idArticulo);
		
		return query.list();
	}

	@Override
	public List<PuntoVenta> findByIdArticulos(Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from ArticulosXPuntoVenta apv join apv.puntoVenta pdv ");
		hql.append("where pdv.idPuntoVenta=apv.puntoVenta.idPuntoVenta and apv.articulo.idArticulo=:idArticulo ");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idArticulo", idArticulo);
		
		return query.list();
	}

}