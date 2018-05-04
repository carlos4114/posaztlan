package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;

public interface TipoMovimientoInvDAOI extends GlobalHibernateDAOI<TipoMovimientoInv>{
	
	TipoMovimientoInv findById(Integer id);
	TipoMovimientoInv findByClave(String clave);
	TipoMovimientoInv findByClaveIsEntrada(String clave,Boolean esEntrada);
	List<TipoMovimientoInv> findByIsEntrada(Boolean esEntrada);
	List<TipoMovimientoInv> findByTypeClave(String clave);
	
	
}
