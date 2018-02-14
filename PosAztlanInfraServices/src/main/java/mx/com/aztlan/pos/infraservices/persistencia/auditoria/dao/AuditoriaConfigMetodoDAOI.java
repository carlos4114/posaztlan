package mx.com.aztlan.pos.infraservices.persistencia.auditoria.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaConfigMetodo;

public interface AuditoriaConfigMetodoDAOI extends GlobalHibernateDAOI<AuditoriaConfigMetodo>
{
	List<AuditoriaConfigMetodo> obtenerMetodosActivos() throws Exception;
}
