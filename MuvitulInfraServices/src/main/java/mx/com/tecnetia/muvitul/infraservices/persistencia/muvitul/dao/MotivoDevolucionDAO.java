package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MotivoDevolucion;

@Repository 
public class MotivoDevolucionDAO extends GlobalHibernateDAO<MotivoDevolucion> implements MotivoDevolucionDAOI {

	@Override
	public List<MotivoDevolucion> findByPuntoVenta(Integer idPuntoVenta) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select md from MotivoDevolucion md ");
		hql.append("where tipoPuntoVenta.idTipoPuntoVenta = :idPuntoVenta " );
		hql.append("order by md.nombre asc " );
				
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idPuntoVenta", idPuntoVenta);	
 
		return query.list();
		
	}


}
