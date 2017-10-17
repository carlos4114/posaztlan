package mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao;

import java.util.Date;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.vo.IngresoVO;

public interface TicketVentaDAOI extends GlobalHibernateDAOI<TicketVenta>{
//	TicketVenta findByTickedAndTipoVenta (Integer idTicket , Integer idTipoPuntoVenta);
	TicketVenta findByCineAndTipoVenta (Integer idCine, Integer idTicket , Integer idTipoPuntoVenta);
	List<IngresoVO> getIngresosDiarios(Integer idCine, Date fechaActual, int dias, String clavePuntoVenta);
	public List<IngresoVO> getIngresosPeliculas(Integer idCine);
	List<IngresoVO> getIngresosPeliculas(Integer idCine, int noSemana);
	List<IngresoVO> getAsistencia(Integer idCine, Date fechaActual, int semanas);
}
