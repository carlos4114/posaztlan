package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DevolucionXProducto;

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
