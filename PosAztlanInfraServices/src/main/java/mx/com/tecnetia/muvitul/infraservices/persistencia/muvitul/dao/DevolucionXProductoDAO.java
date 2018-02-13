package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.DevolucionXProducto;

@Repository 
public class DevolucionXProductoDAO extends GlobalHibernateDAO<DevolucionXProducto> implements DevolucionXProductoDAOI {

	@Override
	public List<DevolucionXProducto> findByTicket(Integer idTicket) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select dxp from DevolucionXProducto dxp join dxp.ticketVenta tv ");
		hql.append("where tv.idTicket=:idTicket ");
		hql.append("order by dxp.idDevolucionXProducto asc ");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idTicket", idTicket);
		return 	query.list();
		
	}


}
