package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;

@Repository 
public class OrdenCompraDetalleDAO extends GlobalHibernateDAO<OrdenCompraDetalle> implements OrdenCompraDetalleDAOI {
	
	@Override
	public List<OrdenCompraDetalle> findByIdOrdenCompra(Integer idOrdenCompra) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select ocd from OrdenCompraDetalle ocd ");		
		hql.append("where ocd.id.idOrdenCompra=:idOrdenCompra " );
				
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idOrdenCompra", idOrdenCompra);	
 
		return query.list();
		
	}
	
}