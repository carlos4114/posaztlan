package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoCostoVO;

public interface ProductoXTicketDAOI extends GlobalHibernateDAOI<ProductosXTicket>{
	
	List <ProductosXTicket> findByTicket (Integer idTicket , Integer idTipoPuntoVenta);
	
	List<ProductoCostoVO> getPrecioPromedio(Integer idCine,Date startDate, Date endDate, int dias);
	
}
