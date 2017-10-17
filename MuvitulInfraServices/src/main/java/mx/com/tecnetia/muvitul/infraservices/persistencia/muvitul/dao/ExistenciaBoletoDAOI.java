package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;

public interface ExistenciaBoletoDAOI extends GlobalHibernateDAOI<ExistenciaBoletos>{
	
	ExistenciaBoletos findByIdProgramacion(Integer idProgramacion, Date fechaExhibicion);
	
}
