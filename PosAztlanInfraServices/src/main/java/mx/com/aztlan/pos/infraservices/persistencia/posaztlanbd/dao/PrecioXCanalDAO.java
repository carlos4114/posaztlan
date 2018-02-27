package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXCanal;


@Repository 
public class PrecioXCanalDAO extends GlobalHibernateDAO<PrecioXCanal> implements PrecioXCanalDAOI {
	@Override
	public void delete(Integer idProducto) {
		StringBuilder hql = new StringBuilder();
		hql.append("delete ");
		hql.append("from PrecioXCanal ");
		hql.append("where producto.idProducto =:idProducto ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProducto", idProducto);
		
		query.executeUpdate();
	}
}