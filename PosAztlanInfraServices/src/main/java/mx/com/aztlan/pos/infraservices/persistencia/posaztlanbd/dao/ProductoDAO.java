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
	
	@Override
	public List<Producto> findByFiltros(Integer idEmpresa, Integer idFamilia, 
			Integer idMarca, Integer idTipoProducto, Integer idMedida, String nombre) {
		boolean F = false;
		boolean M = false;
		boolean T = false;
		boolean Me = false; 
		boolean N = false; 
		
		StringBuilder hql = new StringBuilder();
		hql.append("select pdt ");
		hql.append("from Producto pdt ");
		hql.append("where pdt.empresa.idEmpresa =:idEmpresa ");
		if (idFamilia > 0) {
			hql.append("and pdt.familia.idFamilia =:idFamilia ");
			F = true;
		}
		if (idMarca > 0) {
			hql.append("and pdt.marca.idMarca =:idMarca ");
			M = true;
		}
		if (idTipoProducto > 0) {
			hql.append("and pdt.tipoProducto.idTipoProducto=:idTipoProducto ");
			T = true;
		}
		if (idMedida > 0) {
			hql.append("and pdt.medida.idMedida=:idMedida ");
			Me = true;
		}
		if (nombre.length() > 0) {
			hql.append("and pdt.nombre like :nombre");
			N = true;
		}
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		if(F == true) {
			query.setParameter("idFamilia", idFamilia);
		}
		if(M == true) {
			query.setParameter("idMarca", idMarca);
		}
		if(T==true) {
			query.setParameter("idTipoProducto", idTipoProducto);
		}
		if(Me==true) {
			query.setParameter("idMedida", idMedida);
		}
		if(N==true) {
			query.setParameter("nombre", "%" + nombre + "%");
		}
	
		
		return query.list();
	}
}