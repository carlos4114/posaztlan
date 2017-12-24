package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;

public interface UsuarioDAOI extends GlobalHibernateDAOI<Usuario>{
	Usuario getUsuario(String correo) throws Exception;
	List<Usuario> getUsuarios(Integer idCine) throws Exception;

}
