package mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao;

import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.GlobalHibernateDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.IngresoVO;

public interface TicketVentaDAOI extends GlobalHibernateDAOI<TicketVenta>{
//	TicketVenta findByTickedAndTipoVenta (Integer idTicket , Integer idTipoPuntoVenta);
	TicketVenta findByCineAndTipoVenta2 (Integer idCine, Integer idTicket , Integer idTipoPuntoVenta);
	List<IngresoVO> getIngresosDiarios2(Integer idCine, Date fechaActual, int dias, String clavePuntoVenta);
	public List<IngresoVO> getIngresosPeliculas(Integer idCine);
	List<IngresoVO> getIngresosPeliculas(Integer idCine, int noSemana);
	List<IngresoVO> getAsistencia(Integer idCine, Date fechaActual, int semanas);
	TicketVenta findByCineOfTaquilla(Integer idCine, Integer idTicket);
	TicketVenta findByCineOfDulceria(Integer idCine, Integer idTicket);
	List<IngresoVO> getIngresosDiariosDeDulceria(Integer idCine, Date fechaActual, int dias); 
	List<IngresoVO> getIngresosDiariosDeTaquilla(Integer idCine, Date fechaActual, int dias);
}
