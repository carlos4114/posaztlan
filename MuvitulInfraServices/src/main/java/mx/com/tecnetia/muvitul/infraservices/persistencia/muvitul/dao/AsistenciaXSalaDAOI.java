package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;


import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsistenciaXSala;

public interface AsistenciaXSalaDAOI extends GlobalHibernateDAOI<AsistenciaXSala>{
	List<AsistenciaXSala> getByTicket(Integer idTicket);
	List<AsistenciaXSala> getActivos(Integer idProgramacion, Date fechaExhibicion);
	List<AsistenciaXSala> getWithEstatus(Integer idProgramacion, Date fechaExhibicion, Integer idUsuario, Integer idEstatusAsiento);
}
