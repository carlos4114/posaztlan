package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosCorte;

public interface ArticulosCorteDAOI extends GlobalHibernateDAOI<ArticulosCorte>{
	
	List<ArticulosCorte> getArticulosCorte(Integer idPuntoVenta,Integer estatusConteo);
	Integer updateEstatusConteoByEstatus(Integer idPuntoVenta,Integer estatusActual,Integer estatusFinal, Integer usuario);
	
}
