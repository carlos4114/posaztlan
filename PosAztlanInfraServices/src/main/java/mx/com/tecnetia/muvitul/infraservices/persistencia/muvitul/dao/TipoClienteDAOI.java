package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoCliente;

public interface TipoClienteDAOI extends GlobalHibernateDAOI<TipoCliente>{

	List<TipoCliente> getTipoClientesOrdered();
}
