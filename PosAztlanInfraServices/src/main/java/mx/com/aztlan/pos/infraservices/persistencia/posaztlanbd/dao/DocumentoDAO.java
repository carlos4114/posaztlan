package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Documento;

@Repository 
public class DocumentoDAO extends GlobalHibernateDAO<Documento> implements DocumentoDAOI {


}
