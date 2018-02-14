package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PrecioXFormato;

public interface PrecioXFormatoDAOI extends GlobalHibernateDAOI<PrecioXFormato> {

	List<PrecioXFormato> findPreciosByFormatoCine(Integer idCine, Integer idFormato);

}
