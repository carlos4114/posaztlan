package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXFormato;

@Repository
public class PrecioXFormatoDAO extends GlobalHibernateDAO<PrecioXFormato> implements PrecioXFormatoDAOI {

	@Override
	public List<PrecioXFormato> findPreciosByFormatoCine(Integer idCine, Integer idFormato) {
		StringBuilder hql = new StringBuilder();
		hql.append("select pxf from PrecioXFormato pxf inner join pxf.formato frm inner join pxf.tipoCliente tc ");
		hql.append("where frm.cine.idCine=:idCine and frm.idFormato=:idFormato  and pxf.activo=1 and tc.activo=1 ");
		hql.append("order by pxf.idPrecioXFormato asc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("idCine", idCine);
		query.setParameter("idFormato", idFormato);	
		return query.list();

	}

}
