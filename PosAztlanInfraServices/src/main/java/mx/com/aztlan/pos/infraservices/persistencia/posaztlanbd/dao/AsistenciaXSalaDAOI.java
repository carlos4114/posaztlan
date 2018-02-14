package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;


import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSala;

public interface AsistenciaXSalaDAOI extends GlobalHibernateDAOI<AsistenciaXSala>{
	List<AsistenciaXSala> getByTicket(Integer idTicket);
	List<AsistenciaXSala> getActivos(Integer idProgramacion, Date fechaExhibicion);
	List<AsistenciaXSala> getWithEstatus(Integer idProgramacion, Date fechaExhibicion, Integer idUsuario, Integer idEstatusAsiento);
	void borrarReservadosUsuario(Integer idUsuario);
	void borrarPorTicket(Integer idTicket);
	
}
