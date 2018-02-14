package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Sala;

public interface SalaDAOI extends GlobalHibernateDAOI<Sala>{
	
	List<Sala> findByIdCine(Integer idCine);
	List<Sala> findAllByIdCine(Integer idCine);
	List<Sala> findByNombre(Integer idCine, String nombre);
	boolean findNombreRepetido(Integer idCine, Integer idSala, String nombre);

}
