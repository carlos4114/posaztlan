package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;

public interface UsuarioDAOI extends GlobalHibernateDAOI<Usuario>{
	Usuario getUsuario(String correo) throws Exception;
	List<Usuario> getUsuarios(Integer idCanal) throws Exception;

}
