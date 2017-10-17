package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoMovimientoInv;

public interface TipoMovimientoInvDAOI extends GlobalHibernateDAOI<TipoMovimientoInv>{
	
	TipoMovimientoInv findById(Integer id);
	TipoMovimientoInv findByClave(String clave);
	TipoMovimientoInv findByClaveIsEntrada(String clave,Boolean esEntrada);
	List<TipoMovimientoInv> findByIsEntrada(Boolean esEntrada);
	List<TipoMovimientoInv> findByTypeClave(String clave);
}
