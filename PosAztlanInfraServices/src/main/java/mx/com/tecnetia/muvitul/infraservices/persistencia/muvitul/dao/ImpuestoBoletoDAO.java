package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;

@Repository 
public class ImpuestoBoletoDAO extends GlobalHibernateDAO<ImpuestoBoleto> implements ImpuestoBoletoDAOI {

	@Override
	public List<ImpuestoBoleto> findByIdCine(Integer idCine) {
		StringBuilder hql = new StringBuilder();
		hql.append("select ixb  from ImpuestoBoleto ixb ");
		hql.append("where ixb.cine.idCine=:idCine and ixb.activo=1 " );
		hql.append("order by ixb.idImpuestoBoleto desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		return query.list();
	}

}
