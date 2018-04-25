package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;

@Repository 
public class ImpuestoXProductoDAO extends GlobalHibernateDAO<ImpuestoXProducto> implements ImpuestoXProductoDAOI {

	@Override
	public List<ImpuestoXProducto> findByIdEmpresaAndIdProducto(Integer idEmpresa, Integer idProducto) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ixp  from ImpuestoXProducto ixp join ixp.empresa cne join ixp.producto pdt ");
		hql.append("where cne.idEmpresa=:idEmpresa and pdt.idProducto=:idProducto and ixp.activo=1 " );
		hql.append("order by ixp.idImpuestoXProducto desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idEmpresa);
		query.setParameter("idProducto", idProducto);
		
		return query.list();
	}
	
	@Override
	public List<ImpuestoXProducto> findByIdProducto(Integer idProducto) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ixp  from ImpuestoXProducto ixp ");
		hql.append("where ixp.producto.idProducto=:idProducto " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProducto", idProducto);
		
		return query.list();
	}

	@Override
	public List<ImpuestoXProducto> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ixp.idImpuestoXProducto, ixp.nombre from ImpuestoXProducto ixp ");
		hql.append("where ixp.empresa.idEmpresa=:idEmpresa and ixp.activo=1 " );
		hql.append("order by ixp.idImpuestoXProducto asc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}

}
