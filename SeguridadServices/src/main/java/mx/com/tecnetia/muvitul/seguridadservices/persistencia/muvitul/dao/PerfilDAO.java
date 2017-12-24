package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;

@Repository
@Transactional
public class PerfilDAO extends GlobalHibernateDAO<Perfil> implements PerfilDAOI{
	
	@Override
	public List<Perfil> findByEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select perf from Perfil perf ");
		hql.append("where perf.empresa.idEmpresa=:idEmpresa ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		@SuppressWarnings("unchecked")
		List<Perfil>  perfiles = query.list();
		
		return perfiles;
	}
	
}
