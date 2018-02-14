package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoBoleto;

public interface ImpuestoBoletoDAOI extends GlobalHibernateDAOI<ImpuestoBoleto>{
	List<ImpuestoBoleto> findByIdCine(Integer idCine);
}
