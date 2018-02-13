package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CargoAjuste;

public interface CargoAjusteDAOI extends GlobalHibernateDAOI<CargoAjuste>{

	List<CargoAjuste> getActivos();
}
