package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

@Repository 
public class UsuariosDAO extends GlobalHibernateDAO<Usuario> implements UsuariosDAOI {

	@Override
	public Usuario findByCorreoAndPwd(String correo, String contrasenia) {
		StringBuilder hql = new StringBuilder();
		hql.append("select usr from Usuario usr join usr.estatusUsuario eu ");
		hql.append("where usr.correo=:correo and usr.contrasenia=:contrasenia and eu.idEstatus=1 " );

		Query query = getSession().createQuery(hql.toString());
		query.setParameter("correo", correo);
		query.setParameter("contrasenia", contrasenia);
		
		List<Usuario> result=query.list();
		
		if (result!=null && !result.isEmpty()){
			return result.get(0);
		}
		
		return null;
			
	}


}
