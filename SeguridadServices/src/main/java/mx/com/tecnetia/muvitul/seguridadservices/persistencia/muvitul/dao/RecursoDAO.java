package mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Recurso;

@Repository
@Transactional
public class RecursoDAO extends GlobalHibernateDAO<Recurso> implements RecursoDAOI{

}
