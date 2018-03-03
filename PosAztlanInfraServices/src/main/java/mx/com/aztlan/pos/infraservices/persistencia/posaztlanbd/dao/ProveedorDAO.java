package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;

@Repository 
public class ProveedorDAO extends GlobalHibernateDAO<Proveedor> implements ProveedorDAOI {

	@Override
	public List<Proveedor> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdv from Proveedor pdv join pdv.cine cne ");
		hql.append("where cne.idCine=:idCine ");
		hql.append("order by pdv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();
	}


	@Override
	public List<Proveedor> findByEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pv from Proveedor pv ");
		hql.append("where pv.empresa.idEmpresa=:idEmpresa ");
		hql.append("order by pv.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}
}