package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaConfigMetodo;

@Transactional
public class AuditoriaConfigMetodoDAO extends GlobalHibernateDAO<AuditoriaConfigMetodo> implements AuditoriaConfigMetodoDAOI
{
	@SuppressWarnings("unchecked")
	public List<AuditoriaConfigMetodo> obtenerMetodosActivos() throws Exception{
		if(log.isDebugEnabled())
			log.debug("Entrando al DAO de AuditoriaConfigMetodo para obtenerMetodosAcivos de la aplicacion");
		
		Criteria criteria = getSession().createCriteria(AuditoriaConfigMetodo.class);

		criteria.add(Restrictions.eq("activo", Boolean.TRUE.booleanValue()));		
		
		List<AuditoriaConfigMetodo> metodos = criteria.list();
		
    	return metodos;
	}
}
