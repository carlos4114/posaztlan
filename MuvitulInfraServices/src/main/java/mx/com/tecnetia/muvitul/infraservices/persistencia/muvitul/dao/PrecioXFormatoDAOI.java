package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PrecioXFormato;

public interface PrecioXFormatoDAOI extends GlobalHibernateDAOI<PrecioXFormato> {

	List<PrecioXFormato> findPreciosByFormatoCine(Integer idCine, Integer idFormato);

}
