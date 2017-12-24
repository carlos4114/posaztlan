package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;

public interface PerfilDAOI extends GlobalHibernateDAOI<Perfil>{
	
	List<Perfil> findByEmpresa(Integer idEmpresa);

}
