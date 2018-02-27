package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Marca;

@Repository 
public class MarcaDAO extends GlobalHibernateDAO<Marca> implements MarcaDAOI {

	@Override
	public List<Marca> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ma from Marca ma ");
		hql.append("where ma.empresa.idEmpresa=:idEmpresa and ma.activo=1 ");
		hql.append("order by ma.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}

}