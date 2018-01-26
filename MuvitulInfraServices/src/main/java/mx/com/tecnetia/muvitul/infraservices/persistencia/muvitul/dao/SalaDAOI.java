package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;

public interface SalaDAOI extends GlobalHibernateDAOI<Sala>{
	
	List<Sala> findByIdCine(Integer idCine);
	List<Sala> findAllByIdCine(Integer idCine);
	List<Sala> findByNombre(Integer idCine, String nombre);
	boolean findNombreRepetido(Integer idCine, Integer idSala, String nombre);

}
