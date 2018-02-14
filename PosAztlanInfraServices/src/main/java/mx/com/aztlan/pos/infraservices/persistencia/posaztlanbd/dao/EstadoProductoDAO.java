package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstadoProducto;

@Repository 
public class EstadoProductoDAO extends GlobalHibernateDAO<EstadoProducto> implements EstadoProductoDAOI {

	@Override
	public EstadoProducto findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ep from EstadoProducto ep  ");
		hql.append("where ep.clave=:clave ");
		hql.append("order by ep.idEstadoProducto desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<EstadoProducto>  estadosProduto = query.list();
		
		if (estadosProduto!= null && !estadosProduto.isEmpty()){
			return estadosProduto.get(0);
		}
		
		return null;
	}


}
