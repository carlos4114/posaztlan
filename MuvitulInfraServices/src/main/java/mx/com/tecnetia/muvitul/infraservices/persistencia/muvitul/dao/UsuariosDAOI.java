package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public interface UsuariosDAOI extends GlobalHibernateDAOI<Usuario>{
	Usuario findByCorreoAndPwd (String correo, String contrasenia);
	
}
