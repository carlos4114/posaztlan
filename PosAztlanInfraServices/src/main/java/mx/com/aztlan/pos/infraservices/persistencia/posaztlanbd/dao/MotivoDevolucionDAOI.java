package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MotivoDevolucion;

public interface MotivoDevolucionDAOI extends GlobalHibernateDAOI<MotivoDevolucion>{
	List<MotivoDevolucion> findByPuntoVenta(Integer idPuntoVenta);
}
