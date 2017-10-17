package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.ProductoCostoVO;

public interface ProductoXTicketDAOI extends GlobalHibernateDAOI<ProductosXTicket>{
	
	List <ProductosXTicket> findByTicket (Integer idTicket , Integer idTipoPuntoVenta);
	
	List<ProductoCostoVO> getPrecioPromedio(Integer idCine,Date startDate, Date endDate, int dias);
	
}
