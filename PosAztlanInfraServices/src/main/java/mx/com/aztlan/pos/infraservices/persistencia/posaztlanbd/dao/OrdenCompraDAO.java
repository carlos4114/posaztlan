package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;

@Repository 
public class OrdenCompraDAO extends GlobalHibernateDAO<OrdenCompra> implements OrdenCompraDAOI {
	
	@Override
	public List<OrdenCompra> findByIdOrdenCompra(Integer idOrdenCompra) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select oc from OrdenCompra oc ");
		hql.append("where oc.idOrdenCompra =:idOrdenCompra " );
				
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idOrdenCompra", idOrdenCompra);	
 
		return query.list();
		
	}
	
	@Override
	public Integer getId(Integer idEmpresa, Integer folio) {
		StringBuilder hql = new StringBuilder();
		hql.append("select oc.idOrdenCompra from OrdenCompra oc ");
		hql.append("where oc.folio=:folio and oc.empresa.idEmpresa=:idEmpresa " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("folio", folio);
		query.setParameter("idEmpresa", idEmpresa);
		
		List result = query.list();
		Integer idOrdenCompra = 0;
		
		for(Object obj: result){			
			if(obj!=null){
				idOrdenCompra = (Integer)obj;
				break;
			}
		}
		
		return idOrdenCompra;
	}
}