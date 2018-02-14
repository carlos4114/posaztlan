package mx.com.aztlan.pos.infraservices.persistencia.auditoria.dao;


import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaAtributoObjeto;


@Repository
public class AuditoriaAtributoObjetoDAO extends GlobalHibernateDAO<AuditoriaAtributoObjeto> implements AuditoriaAtributoObjetoDAOI
{

}
