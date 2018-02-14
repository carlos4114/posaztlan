package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;

@Repository 
public class FormaPagoDAO extends GlobalHibernateDAO<FormaPago> implements FormaPagoDAOI {

	public List<FormaPago> findAll(){
		StringBuilder hql = new StringBuilder();
		hql.append("select fdp  from FormaPago fdp ");
		hql.append("where fdp.activo=1 " );
		hql.append("order by fdp.idFormaPago asc ");

		Query query = getSession().createQuery(hql.toString());
		return query.list();
	}

	@Override
	public FormaPago findByClave(String clave) {
		StringBuilder hql = new StringBuilder();
		hql.append("select fdp from FormaPago fdp  ");
		hql.append("where fdp.clave=:clave ");
		hql.append("order by fdp.idFormaPago desc");
		
		Query query = getSession().createQuery(hql.toString());
		query.setParameter("clave", clave);
		
		List<FormaPago>  formaPago = query.list();
		
		if (formaPago!= null && !formaPago.isEmpty()){
			return formaPago.get(0);
		}
		
		return null;
	}

}
