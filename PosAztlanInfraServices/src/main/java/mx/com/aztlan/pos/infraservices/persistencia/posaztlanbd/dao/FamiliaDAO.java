package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Familia;

@Repository 
public class FamiliaDAO extends GlobalHibernateDAO<Familia> implements FamiliaDAOI {

	@Override
	public List<Familia> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select fam from Familia fam ");
		hql.append("where fam.empresa.idEmpresa=:idEmpresa and fam.activo = 1 ");
		hql.append("order by fam.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}

}