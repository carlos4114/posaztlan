package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

public interface UsuariosDAOI extends GlobalHibernateDAOI<Usuario>{
	Usuario findByCorreoAndPwd (String correo, String contrasenia);
	
}
