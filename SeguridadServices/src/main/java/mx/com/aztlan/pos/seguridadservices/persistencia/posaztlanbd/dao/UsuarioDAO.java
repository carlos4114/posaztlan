package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

@Repository
@Transactional
public class UsuarioDAO extends GlobalHibernateDAO<Usuario> implements UsuarioDAOI{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios(Integer idCine) throws Exception {

		Criteria criteria = getSession().createCriteria(Usuario.class);
		
		criteria.add(Restrictions.eq("cine.idCine", idCine));
		
		
		return criteria.list();
	}
	
	
	@Override
	public Usuario getUsuario(String correo) throws Exception {

		Criteria criteria = getSession().createCriteria(Usuario.class);
		
		criteria.add(Restrictions.eq("correo", correo));
		
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = criteria.list();
		
		return usuarios==null?null:(usuarios.size()<=0?null:usuarios.get(0));
	}
	
}
