package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ExistenciaBoletos;

public interface ExistenciaBoletoDAOI extends GlobalHibernateDAOI<ExistenciaBoletos>{
	
	ExistenciaBoletos findByIdProgramacion(Integer idProgramacion, Date fechaExhibicion);
	
}
