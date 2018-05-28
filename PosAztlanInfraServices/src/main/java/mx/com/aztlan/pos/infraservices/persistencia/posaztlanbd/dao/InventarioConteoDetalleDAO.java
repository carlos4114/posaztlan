package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;

@Repository 
public class InventarioConteoDetalleDAO extends GlobalHibernateDAO<InventarioConteoDetalle> implements InventarioConteoDetalleDAOI {
	
	@Override
	public List<InventarioConteoDetalle> findByIdConteo(Integer idConteo) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select icd from InventarioConteoDetalle icd ");		
		hql.append("where icd.id.idConteo=:idConteo " );
				
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idConteo", idConteo);	
 
		return query.list();
		
	}
}
