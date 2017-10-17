package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

@Repository
@Transactional
public class UsuarioDAO extends GlobalHibernateDAO<Usuario> implements UsuarioDAOI{
	
	@Override
	public Usuario getUsuario(String correo) throws Exception {

		Criteria criteria = getSession().createCriteria(Usuario.class);
		
		criteria.add(Restrictions.eq("correo", correo));
		
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = criteria.list();
		
		return usuarios==null?null:(usuarios.size()<=0?null:usuarios.get(0));
	}
	
}
