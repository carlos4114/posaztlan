package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;

@Repository 
public class PuntoVentaDAO extends GlobalHibernateDAO<PuntoVenta> implements PuntoVentaDAOI {

	@Override
	public List<PuntoVenta> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from PuntoVenta pdv join pdv.cine cne ");
		hql.append("where cne.idCine=:idCine ");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}

	@Override
	public List<PuntoVenta> findByIdCineDulceria(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from PuntoVenta pdv join pdv.cine cne ");
		hql.append("where cne.idCine=:idCine and pdv.tipoPuntoVenta.idTipoPuntoVenta=1");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}
	
	@Override
	public List<PuntoVenta> findByIdPuntoVenta(Integer idPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from PuntoVenta pdv ");
		hql.append("where pdv.idPuntoVenta=:idPuntoVenta ");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.list();
	}

	@Override
	public List<PuntoVenta> findByIdArticulo(Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from PuntoVenta pdv join pdv.articulosXPuntoVenta apv ");
		hql.append("where pdv.idPuntoVenta=:apv.idPuntoVenta and apv.idArticulo=:idArticulo ");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idArticulo", idArticulo);
		
		return query.list();
	}
}