package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ArticuloExistenciaVO;

@Repository 
public class ArticuloDAO extends GlobalHibernateDAO<Articulo> implements ArticuloDAOI {

	@Override
	public List<ArticuloExistenciaVO> getDisponible(Integer idPuntoVenta) {

		StringBuilder hql = new StringBuilder();
		hql.append("select art as articulo, (select sum(inv2.existenciaActual) from Inventario inv2 join inv2.articulo art2 join inv2.puntoVenta pv2 join inv2.tipoMovimientoInv tmi2 where art2.idArticulo= art.idArticulo and pv2.idPuntoVenta =:idPuntoVenta and tmi2.esEntrada = 1  ) as existencia  ");
		hql.append("from Inventario inv join inv.articulo art join inv.puntoVenta pv join inv.tipoMovimientoInv tmi ");
		hql.append("where pv.idPuntoVenta =:idPuntoVenta ");
		hql.append("and tmi.esEntrada = 1 ");
		hql.append("and inv.existenciaActual >= 1 ");
		hql.append("group by inv.articulo ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.setResultTransformer(Transformers.aliasToBean(ArticuloExistenciaVO.class)).list();

	}
	
	@Override
	public List<Articulo> getArticulosByName(Integer idCine, String nombre) {
		StringBuilder hql = new StringBuilder();
		hql.append("select art ");
		hql.append("from Articulo art ");
		hql.append("where art.nombre =:nombre and art.cine.idCine =:idCine ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("nombre", nombre);
		query.setParameter("idCine", idCine);
		
		return query.list();
	}

	
	@Override
	public List<Articulo> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select art ");
		hql.append("from Articulo art ");
		hql.append("where art.cine.idCine =:idCine ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}
	
	@Override
	public List<Articulo> findByIdArticulo(Integer idArticulo) {
		StringBuilder hql = new StringBuilder();
		hql.append("select art from Articulo art ");
		hql.append("where art.idArticulo=:idArticulo");

		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idArticulo", idArticulo);
		
		return query.list();
	}
	
	@Override
	public List<Articulo> findByIdCinePuntosVenta(List<Integer> puntosVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select art ");
		hql.append("from Articulo art ");
		hql.append("where art.cine.idCine =:idCine and art.articulosXPuntoVentas.puntoVenta.idPuntoVenta in (:puntosVenta)");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("puntosVenta", puntosVenta);
		
		return query.list();
	}
}