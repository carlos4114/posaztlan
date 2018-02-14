package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CupoXSala;

@Repository 
public class CupoXSalaDAO extends GlobalHibernateDAO<CupoXSala> implements CupoXSalaDAOI {

	@Override
	public CupoXSala findByIdSala(Integer idSala) {
		StringBuilder hql = new StringBuilder();
		hql.append("select cxs  from CupoXSala cxs ");
		hql.append("where cxs.sala.idSala=:idSala and cxs.activo=1 " );
		hql.append("order by cxs.idCupoXSala desc ");

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idSala", idSala);
		List<CupoXSala> result =query.list();
		
		if (!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}


}
