package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Caja;

public interface CajaDAOI extends GlobalHibernateDAOI<Caja>{

	List<Caja> getActivos(Integer idAlmacen);
}
