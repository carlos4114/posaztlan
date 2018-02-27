package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;

@Repository 
public class CanalDAO extends GlobalHibernateDAO<Canal> implements CanalDAOI {

	@Override
	public List<Canal> findByEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cn from Canal cn  ");
		hql.append("where cn.empresa.idEmpresa=:idEmpresa and cn.activo=1 ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		List<Canal>  canales = query.list();
		
		return canales;
	}
	
	@Override
	public List<Canal> findActivos() {
		StringBuilder hql = new StringBuilder();
		hql.append("select cn from Canal cn ");
		hql.append("where cn.activo=1");
		
		Query query = getSession().createQuery(hql.toString());
		
		List<Canal> canales = query.list();
		
		return canales;
	}
	


}
