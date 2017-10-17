package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao;


import org.springframework.stereotype.Repository;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;

@Repository
public class AuditoriaObjetoDAO extends GlobalHibernateDAO<AuditoriaObjeto> implements AuditoriaObjetoDAOI
{

}
