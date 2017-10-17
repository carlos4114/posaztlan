package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosCorte;

public interface ArticulosCorteDAOI extends GlobalHibernateDAOI<ArticulosCorte>{
	
	List<ArticulosCorte> getArticulosCorte(Integer idPuntoVenta,Integer estatusConteo);
	Integer updateEstatusConteoByEstatus(Integer idPuntoVenta,Integer estatusActual,Integer estatusFinal, Integer usuario);
	
}
