package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CargoAjuste;

public interface CargoAjusteDAOI extends GlobalHibernateDAOI<CargoAjuste>{

	List<CargoAjuste> getActivos();
}
