package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacion;

public interface TipoAutorizacionDAOI extends GlobalHibernateDAOI<TipoAutorizacion>{

	long getAutorizacionMovimiento(String correo, String contrasenia, Integer idTipoAutorizacion);
}
