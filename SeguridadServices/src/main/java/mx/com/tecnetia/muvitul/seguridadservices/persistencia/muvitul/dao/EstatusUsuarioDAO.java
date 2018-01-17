package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusUsuario;

@Repository
@Transactional
public class EstatusUsuarioDAO extends GlobalHibernateDAO<EstatusUsuario> implements EstatusUsuarioDAOI{
	
	
}
