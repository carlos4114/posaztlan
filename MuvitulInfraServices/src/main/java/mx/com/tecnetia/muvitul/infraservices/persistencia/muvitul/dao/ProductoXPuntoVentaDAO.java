package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXPuntoVenta;


@Repository 
public class ProductoXPuntoVentaDAO extends GlobalHibernateDAO<ProductosXPuntoVenta> implements ProductoXPuntoVentaDAOI {

	@Override
	public List<ProductosXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ppv from ProductosXPuntoVenta ppv join ppv.puntoVenta pdv join ppv.producto pdt ");
		hql.append("where pdv.idPuntoVenta=:idPuntoVenta and pdt.activo=1 ");
		hql.append("order by pdt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.list();
	}
	
}