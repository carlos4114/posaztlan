package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoDevolucion;

@Repository 
public class TipoDevolucionDAO extends GlobalHibernateDAO<TipoDevolucion> implements TipoDevolucionDAOI {

	@Override
	public List<TipoDevolucion> findByTipoPuntoVenta(Integer idTipoPuntoVenta) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tdd from TipoDevolucion tdd join tdd.tipoPuntoVenta tpv  ");
		hql.append("where tpv.idTipoPuntoVenta=:idTipoPuntoVenta and activo=1 " );
		hql.append("order by tdd.idTipoDevolucion desc " );
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTipoPuntoVenta", idTipoPuntoVenta);
		
		return query.list();
	}


}
