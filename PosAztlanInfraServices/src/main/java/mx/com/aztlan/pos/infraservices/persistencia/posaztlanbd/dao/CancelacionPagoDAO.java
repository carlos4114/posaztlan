package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CancelacionPago;

@Repository 
public class CancelacionPagoDAO extends GlobalHibernateDAO<CancelacionPago> implements CancelacionPagoDAOI {


}
