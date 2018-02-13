package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Proveedor;

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


}