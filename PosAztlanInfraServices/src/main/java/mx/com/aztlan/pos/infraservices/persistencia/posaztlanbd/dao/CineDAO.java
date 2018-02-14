package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;

@Repository 
public class CineDAO extends GlobalHibernateDAO<Cine> implements CineDAOI {

	@Override
	public List<Cine> findByEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cne from Cine cne join cne.empresa emp  ");
		hql.append("where emp.idEmpresa=:idEmpresa and cne.activo=1 ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		List<Cine>  cines = query.list();
		
		return cines;
	}
	
	@Override
	public List<Cine> findActivos() {
		StringBuilder hql = new StringBuilder();
		hql.append("select cne from Cine cne ");
		hql.append("where cne.activo=1");
		
		Query query = getSession().createQuery(hql.toString());
		
		List<Cine>  cines = query.list();
		
		return cines;
	}
	


}
