package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MotivoDevolucion;

public interface MotivoDevolucionDAOI extends GlobalHibernateDAOI<MotivoDevolucion>{
	List<MotivoDevolucion> findByPuntoVenta(Integer idPuntoVenta);
}
