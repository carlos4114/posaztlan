package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Promocion;

public interface PromocionDAOI extends GlobalHibernateDAOI<Promocion>  {
	List<Promocion> findByCinePromocionAndExhibicion(Integer idCine,Integer idPromocionPara,Date fechaExhibicion);
	List<Promocion> findByCineAndExhibicion(Integer idCine,Date fechaExhibicion);
}
