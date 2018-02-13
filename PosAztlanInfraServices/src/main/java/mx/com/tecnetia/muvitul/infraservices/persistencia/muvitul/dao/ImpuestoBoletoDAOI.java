package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;

public interface ImpuestoBoletoDAOI extends GlobalHibernateDAOI<ImpuestoBoleto>{
	List<ImpuestoBoleto> findByIdCine(Integer idCine);
}
