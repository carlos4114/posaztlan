package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoDevolucion;

public interface TipoDevolucionDAOI extends GlobalHibernateDAOI<TipoDevolucion>{

	List<TipoDevolucion> findByTipoPuntoVenta(Integer idTipoPuntoVenta);
}
