package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXPuntoVenta;


@Repository 
public class PaqueteXPuntoVentaDAO extends GlobalHibernateDAO<PaquetesXPuntoVenta> implements PaqueteXPuntoVentaDAOI {

	@Override
	public List<PaquetesXPuntoVenta> findByPuntoVenta(Integer idPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ppv from PaquetesXPuntoVenta ppv join ppv.puntoVenta pdv join ppv.paquete pqt ");
		hql.append("where pdv.idPuntoVenta=:idPuntoVenta and pqt.activo=1 ");
		hql.append("order by pqt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);
		
		return query.list();
	}
	
}