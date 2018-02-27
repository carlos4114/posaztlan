package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;

@Repository 
public class ProductoDAO extends GlobalHibernateDAO<Producto> implements ProductoDAOI {

	@Override
	public List<Producto> findByCine(Integer idCine) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt from Producto pdt join pdt.cine cne ");
		hql.append("where cne.idCine=:idCine and pdt.activo=1 ");
		hql.append("order by pdt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		
		return query.list();

	}

	@Override
	public List<Producto> findByEmpresa(Integer idEmpresa) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt from Producto pdt ");
		hql.append("where pdt.empresa.idEmpresa=:idEmpresa ");
		hql.append("order by pdt.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();

	}
	
	@Override
	public List<Producto> findByName(Integer idCine, String nombre) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt ");
		hql.append("from Producto pdt ");
		hql.append("where pdt.nombre =:nombre and pdt.cine.idCine =:idCine ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("nombre", nombre);
		query.setParameter("idCine", idCine);
		
		return query.list();
	}

	@Override
	public List<Producto> findByIdProducto(Integer idProducto) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt ");
		hql.append("from Producto pdt ");
		hql.append("where pdt.idProducto =:idProducto ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idProducto", idProducto);
		
		return query.list();
	}
}