package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsientosXSala;

public interface AsientosXSalaDAOI extends GlobalHibernateDAOI<AsientosXSala>{
	List<AsientosXSala> getActivos(Integer idSala);
	void actualizarEstatus(Integer idSala, boolean activo);
	String getMaxFila(Integer idSala);
	Integer getMaxNoAsientos(Integer idSala);

}
