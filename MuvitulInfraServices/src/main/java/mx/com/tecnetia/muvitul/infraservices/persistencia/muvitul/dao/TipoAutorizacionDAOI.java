package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoAutorizacion;

public interface TipoAutorizacionDAOI extends GlobalHibernateDAOI<TipoAutorizacion>{

	long getAutorizacionMovimiento(String correo, String contrasenia, Integer idTipoAutorizacion);
}
