package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompraDetalle;

public interface OrdenCompraDetalleDAOI extends GlobalHibernateDAOI<OrdenCompraDetalle>{

	List<OrdenCompraDetalle> findByIdOrdenCompra(Integer idOrdenCompra);
}
