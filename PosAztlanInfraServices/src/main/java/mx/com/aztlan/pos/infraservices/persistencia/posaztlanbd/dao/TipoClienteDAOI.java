package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoCliente;

public interface TipoClienteDAOI extends GlobalHibernateDAOI<TipoCliente>{

	List<TipoCliente> getTipoClientesOrdered();
}
