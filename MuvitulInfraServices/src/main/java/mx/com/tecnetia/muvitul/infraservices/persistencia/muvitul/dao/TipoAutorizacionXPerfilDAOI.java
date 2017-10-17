package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Perfil;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoAutorizacionXPerfil;

public interface TipoAutorizacionXPerfilDAOI extends GlobalHibernateDAOI<TipoAutorizacionXPerfil>{

	List<TipoAutorizacionXPerfil> findByTipoAndPerfiles(Integer idTipoAutorizacion, List<Perfil> perfiles);
}
