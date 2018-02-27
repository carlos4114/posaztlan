package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Medida;

@Repository 
public class MedidaDAO extends GlobalHibernateDAO<Medida> implements MedidaDAOI {

	@Override
	public List<Medida> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select me from Medida me ");
		hql.append("where me.empresa.idEmpresa=:idEmpresa and me.activo =1");
		hql.append("order by me.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}

}