package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsientosXSala;

public interface AsientosXSalaDAOI extends GlobalHibernateDAOI<AsientosXSala>{
	List<AsientosXSala> getActivos(Integer idSala);
	void actualizarEstatus(Integer idSala, boolean activo);
	String getMaxFila(Integer idSala);
	Integer getMaxNoAsientos(Integer idSala);
}
