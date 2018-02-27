package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;

@Repository 
public class UnidadMedidaDAO extends GlobalHibernateDAO<UnidadMedida> implements UnidadMedidaDAOI {

	@Override
	public List<UnidadMedida> findAll() {
		StringBuilder hql = new StringBuilder();
		hql.append("select um from UnidadMedida um ");
		hql.append("where um.activo = 1");
		hql.append("order by um.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		
		return query.list();
	}

	@Override
	public List<UnidadMedida> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select um from UnidadMedida um ");
		hql.append("where um.activo = 1 and um.empresa.idEmpresa=:idEmpresa ");
		hql.append("order by um.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}
}