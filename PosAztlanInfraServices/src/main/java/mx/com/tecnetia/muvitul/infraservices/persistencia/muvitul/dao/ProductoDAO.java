package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Producto;

@Repository 
public class ProductoDAO extends GlobalHibernateDAO<Producto> implements ProductoDAOI {

	@Override
	public List<Producto> findByCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt from Producto pdt join pdt.cine cne ");
		hql.append("where cne.idCine=:idCine and pdt.activo=1 ");
		hql.append("order by pdt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();

	}
	
}