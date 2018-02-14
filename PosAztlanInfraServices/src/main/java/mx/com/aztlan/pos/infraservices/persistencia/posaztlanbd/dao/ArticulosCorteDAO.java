package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosCorte;

@Repository 
public class ArticulosCorteDAO extends GlobalHibernateDAO<ArticulosCorte> implements ArticulosCorteDAOI {
	
	
	@Override
	public List<ArticulosCorte> getArticulosCorte(Integer idPuntoVenta,Integer estatusConteo){
		StringBuilder hql = new StringBuilder();
		hql.append("select artcort from ArticulosCorte artcort join artcort.puntoVenta ptovta ");
		hql.append("where ptovta.idPuntoVenta=:idPuntoVenta and artcort.estatusConteo=:estatusConteo ");
		hql.append("order by artcort.fecha desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("estatusConteo",estatusConteo);
		
		List<ArticulosCorte> articulosCorte = query.list();
		
		return articulosCorte;
	}

	@Override
	public Integer updateEstatusConteoByEstatus(Integer idPuntoVenta,Integer estatusActual,Integer estatusFinal, Integer usuario) {
		StringBuilder hql = new StringBuilder();
		hql.append("update ArticulosCorte set estatusConteo=:estatusFinal, usuarioModificacion.idUsuario=:usuario, ultimaModificacion=:fechaModificacion where puntoVenta.idPuntoVenta=:idPuntoVenta and estatusConteo=:estatusActual");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		query.setParameter("estatusActual",estatusActual);
		query.setParameter("estatusFinal",estatusFinal);
		query.setParameter("usuario",usuario);
		query.setParameter("fechaModificacion",new Date());
		
		return query.executeUpdate();
	}
	
}