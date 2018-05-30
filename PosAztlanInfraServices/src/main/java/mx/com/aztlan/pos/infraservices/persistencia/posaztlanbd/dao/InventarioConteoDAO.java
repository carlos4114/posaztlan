package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;

@Repository 
public class InventarioConteoDAO extends GlobalHibernateDAO<InventarioConteo> implements InventarioConteoDAOI {
	
	@Override
	public List<InventarioConteo> getByFolio(Integer idEmpresa, Integer folio) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ic from InventarioConteo ic ");
		hql.append("where ic.folio=:folio and ic.canal.empresa.idEmpresa=:idEmpresa " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("folio", folio);
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}
}
