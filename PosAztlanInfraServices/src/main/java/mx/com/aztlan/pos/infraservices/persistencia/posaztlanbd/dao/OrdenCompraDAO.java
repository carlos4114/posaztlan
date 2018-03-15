package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;

@Repository 
public class OrdenCompraDAO extends GlobalHibernateDAO<OrdenCompra> implements OrdenCompraDAOI {	
}