package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusUsuario;

@Repository
@Transactional
public class EstatusUsuarioDAO extends GlobalHibernateDAO<EstatusUsuario> implements EstatusUsuarioDAOI{
	
	
}
