package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Perfil;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacionXPerfil;

public interface TipoAutorizacionXPerfilDAOI extends GlobalHibernateDAOI<TipoAutorizacionXPerfil>{

	List<TipoAutorizacionXPerfil> findByTipoAndPerfiles(Integer idTipoAutorizacion, List<Perfil> perfiles);
}
