package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Promocion;

@Repository
public class PromocionDAO extends GlobalHibernateDAO<Promocion> implements PromocionDAOI{

	@Override
	public List<Promocion> findByCinePromocionAndExhibicion(Integer idCine, Integer idPromocionPara, Date fechaExhibicion) {

		StringBuilder hql = new StringBuilder();
		hql.append("select prm from Promocion prm inner join prm.tipoPromocion tprm inner join prm.promocionPara prmp ");
		hql.append("where prm.cine.idCine=:idCine and prmp.idPromocionPara=:idPromocionPara ");
		hql.append("and :fechaExhibicion between prm.fechaInicio and prm.fechaFin and prm.activo=1 ");
		hql.append("order by prm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idPromocionPara", idPromocionPara);
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();

	}

	@Override
	public List<Promocion> findByCineAndExhibicion(Integer idCine, Date fechaExhibicion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select prm from Promocion prm inner join prm.tipoPromocion tprm inner join prm.promocionPara prmp ");
		hql.append("where prm.cine.idCine=:idCine and :fechaExhibicion between prm.fechaInicio and prm.fechaFin and prm.activo=1 ");
		hql.append("order by prm.nombre asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("fechaExhibicion", fechaExhibicion);	
		
		return query.list();
	}

}
