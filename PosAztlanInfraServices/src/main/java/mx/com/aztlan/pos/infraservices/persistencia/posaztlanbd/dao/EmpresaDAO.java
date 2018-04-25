package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Empresa;

@Repository 
public class EmpresaDAO extends GlobalHibernateDAO<Empresa> implements EmpresaDAOI {

	@Override
	public List<Empresa> findByEstatus(Integer idEstatus) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Empresa e where e.estatusEmpresa.idEstatus = :idEstatus  ");
		hql.append(" order by e.nombre desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEstatus", idEstatus);
		
		return query.list();
	}


}
