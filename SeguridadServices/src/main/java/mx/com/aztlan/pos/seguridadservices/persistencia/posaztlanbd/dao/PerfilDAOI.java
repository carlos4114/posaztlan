package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Perfil;

public interface PerfilDAOI extends GlobalHibernateDAOI<Perfil>{
	
	List<Perfil> findByEmpresa(Integer idEmpresa);

}
