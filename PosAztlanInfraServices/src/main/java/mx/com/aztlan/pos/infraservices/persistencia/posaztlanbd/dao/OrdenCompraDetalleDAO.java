package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import org.springframework.stereotype.Repository;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;

@Repository 
public class OrdenCompraDetalleDAO extends GlobalHibernateDAO<OrdenCompraDetalle> implements OrdenCompraDetalleDAOI {

}