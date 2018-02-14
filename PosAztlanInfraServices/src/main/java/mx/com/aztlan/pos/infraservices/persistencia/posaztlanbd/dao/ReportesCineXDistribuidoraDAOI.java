package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ReportesCineXDistribuidora;

public interface ReportesCineXDistribuidoraDAOI extends GlobalHibernateDAOI<ReportesCineXDistribuidora>{
	List<ReportesCineXDistribuidora> findActivos();
}
