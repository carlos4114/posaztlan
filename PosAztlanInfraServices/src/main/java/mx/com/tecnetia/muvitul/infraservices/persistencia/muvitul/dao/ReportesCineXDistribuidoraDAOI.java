package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ReportesCineXDistribuidora;

public interface ReportesCineXDistribuidoraDAOI extends GlobalHibernateDAOI<ReportesCineXDistribuidora>{
	List<ReportesCineXDistribuidora> findActivos();
}
