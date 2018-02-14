package mx.com.aztlan.pos.seguridadservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Recurso;

@Repository
@Transactional
public class RecursoDAO extends GlobalHibernateDAO<Recurso> implements RecursoDAOI{

}
