package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;

@Repository 
public class AlmacenDAO extends GlobalHibernateDAO<Almacen> implements AlmacenDAOI {

	@Override
	public List<Almacen> findByIdCanal(Integer idCanal) {
		StringBuilder hql = new StringBuilder();
		hql.append("select alm from Almacen alm ");
		hql.append("where alm.canal.idCanal=:idCanal ");
		hql.append("order by alm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCanal", idCanal);
		
		return query.list();
	}
	
	@Override
	public List<Almacen> findByAlmacenPadre(Integer idAlmacen) {
		StringBuilder hql = new StringBuilder();
		hql.append("select alm from Almacen alm ");
		hql.append("where alm.idAlmacenPadre=:idAlmacen ");
		hql.append("order by alm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idAlmacen", idAlmacen);
		
		return query.list();
	}
	
	@Override
	public List<Almacen> findSubAlmacenesByIdCanal(Integer idCanal) {
		StringBuilder hql = new StringBuilder();
		hql.append("select alm from Almacen alm ");
		hql.append("where alm.canal.idCanal=:idCanal and alm.idAlmacenPadre is not null ");
		hql.append("order by alm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCanal", idCanal);
		
		return query.list();
	}

	@Override
	public List<Almacen> findByIdEmpresa(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select alm from Almacen alm ");
		hql.append("where alm.empresa.idEmpresa=:idEmpresa ");
		hql.append("order by alm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		return query.list();
	}
	
	@Override
	public Integer getAlmacenCentral(Integer idEmpresa) {
		StringBuilder hql = new StringBuilder();
		hql.append("select alm.idAlmacen from Almacen alm ");
		hql.append("where alm.canal.idCanal is null and alm.idAlmacenPadre is null ");
		hql.append("and alm.empresa.idEmpresa=:idEmpresa");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idEmpresa", idEmpresa);
		
		List result = query.list();
		Integer idAlmacen = 0;
		
		for(Object obj: result){			
			if(obj!=null){
				idAlmacen = (Integer)obj;
				break;
			}
		}
		
		return idAlmacen;
	}

}