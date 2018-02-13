package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Caja;

public interface CajaDAOI extends GlobalHibernateDAOI<Caja>{

	List<Caja> getActivos(Integer idPuntoVenta);
}
