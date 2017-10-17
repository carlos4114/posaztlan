package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public interface UsuarioDAOI extends GlobalHibernateDAOI<Usuario>{
	Usuario getUsuario(String correo) throws Exception;

}
