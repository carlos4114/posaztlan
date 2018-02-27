package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoProducto;

@Repository 
public class TipoProductoDAO extends GlobalHibernateDAO<TipoProducto> implements TipoProductoDAOI {

	@Override
	public List<TipoProducto> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select tp from TipoProducto tp ");
		hql.append("where tp.empresa.idEmpresa=:idEmpresa and tp.activo =1 ");
		hql.append("order by tp.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}

}