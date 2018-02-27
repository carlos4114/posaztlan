package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPaquete;

@Repository 
public class ProductosXPaqueteDAO extends GlobalHibernateDAO<ProductosXPaquete> implements ProductosXPaqueteDAOI {
	
	@Override
	public List<ProductosXPaquete> findByIdPaquete(Integer idPaquete) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pp from ProductosXPaquete pp ");
		hql.append("where pp.paquete.idPaquete=:idPaquete ");
		hql.append("order by pp.paquete.idPaquete, pp.indice asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPaquete", idPaquete);
		
		return query.list();
	}
	
}