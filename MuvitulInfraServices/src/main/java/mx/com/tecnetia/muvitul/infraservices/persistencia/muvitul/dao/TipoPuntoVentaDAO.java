package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPuntoVenta;

@Repository 
public class TipoPuntoVentaDAO extends GlobalHibernateDAO<TipoPuntoVenta> implements TipoPuntoVentaDAOI {

	@Override
	public TipoPuntoVenta findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tpv from TipoPuntoVenta tpv  ");
		hql.append("where tpv.clave=:clave ");
		hql.append("order by tpv.idTipoPuntoVenta desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<TipoPuntoVenta>  tipoPuntoVenta = query.list();
		
		if (tipoPuntoVenta!= null && !tipoPuntoVenta.isEmpty()){
			return tipoPuntoVenta.get(0);
		}
		
		return null;
	}
		

}
