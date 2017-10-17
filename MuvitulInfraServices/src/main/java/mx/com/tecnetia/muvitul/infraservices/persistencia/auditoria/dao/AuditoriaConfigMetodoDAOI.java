package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaConfigMetodo;

public interface AuditoriaConfigMetodoDAOI extends GlobalHibernateDAOI<AuditoriaConfigMetodo>
{
	List<AuditoriaConfigMetodo> obtenerMetodosActivos() throws Exception;
}
