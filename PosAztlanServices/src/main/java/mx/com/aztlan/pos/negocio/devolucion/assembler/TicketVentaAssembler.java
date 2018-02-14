package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.devolucion.vo.BoletoXTicketVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.PaqueteXTicketVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaVO;

public class TicketVentaAssembler {

	public static TicketVenta getTicketVenta(Integer idTicket){

		if(idTicket==null)
			return null;
		
		TicketVenta ticketVenta = new TicketVenta();
		ticketVenta.setIdTicket(idTicket);
		
		return ticketVenta;
	}
	
	public static TicketVentaVO getTicketVentaVO(TicketVenta ticketVenta) {
		
		if (ticketVenta == null)
			return null;
		
		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());

		TicketVentaVO ticketVentaVO = new TicketVentaVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getDescuento());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		//ticketVentaVO.setPromocionesXTicketVO(PromocionXTicketAssembler.getPromocionesXTicketVO(ticketVenta.getPromocionesXTickets()));
		
		List<BoletoXTicketVO> boletosXTicketVO=BoletoXTicketAssembler.getBoletosXTicketVO(ticketVenta.getBoletosXTickets());
		if (ticketVenta.getPromocionesXTickets()!= null && !ticketVenta.getPromocionesXTickets().isEmpty()){
			boletosXTicketVO.addAll(BoletoXTicketAssembler.getBoletosXTicketPromocionesVO(ticketVenta.getPromocionesXTickets()));
		}
		ticketVentaVO.setBoletosXTicketVO(boletosXTicketVO);
		ticketVentaVO.setPagosVO(PagoAssembler.getPagosVO(ticketVenta.getPagos()));
		
		
		List<PaqueteXTicketVO> paquetesXTicketVO = new ArrayList<PaqueteXTicketVO>();
		
		if (ticketVenta.getPaquetesXTickets()!= null && !ticketVenta.getPaquetesXTickets().isEmpty()){
			paquetesXTicketVO.addAll(PaqueteXTicketAssembler.getPaquetesXTicketVO(ticketVenta.getPaquetesXTickets()));
		}

		
		if (ticketVenta.getProductosXTickets()!= null && !ticketVenta.getProductosXTickets().isEmpty()){
			paquetesXTicketVO.addAll(PaqueteXTicketAssembler.getPaquetesXTicketProductosVO(ticketVenta.getProductosXTickets()));
		}

		ticketVentaVO.setPaquetesXTicketVO(paquetesXTicketVO);
		
		if (ticketVentaVO.getBoletosXTicketVO()!=null && !ticketVentaVO.getBoletosXTicketVO().isEmpty()){
			ticketVentaVO.setProgramacionVO(ticketVentaVO.getBoletosXTicketVO().get(0).getProgramacionVO());
			ticketVentaVO.setFechaExhibicion(ticketVentaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
		}
		
		ticketVentaVO.setSubtotal(totalPago);
		
		return ticketVentaVO;
	}
	
	public static TicketVentaBoletoVO getTicketVentaBoletoVO(TicketVenta ticketVenta) {
		
		if (ticketVenta == null)
			return null;
		
		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());

		TicketVentaBoletoVO ticketVentaVO = new TicketVentaBoletoVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getDescuento());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		//ticketVentaVO.setPromocionesXTicketVO(PromocionXTicketAssembler.getPromocionesXTicketVO(ticketVenta.getPromocionesXTickets()));
		
		List<BoletoXTicketVO> boletosXTicketVO=BoletoXTicketAssembler.getBoletosXTicketVO(ticketVenta.getBoletosXTickets());
		if (ticketVenta.getPromocionesXTickets()!= null && !ticketVenta.getPromocionesXTickets().isEmpty()){
			boletosXTicketVO.addAll(BoletoXTicketAssembler.getBoletosXTicketPromocionesVO(ticketVenta.getPromocionesXTickets()));
		}
		ticketVentaVO.setBoletosXTicketVO(boletosXTicketVO);
		ticketVentaVO.setPagosVO(PagoAssembler.getPagosVO(ticketVenta.getPagos()));
		
		if (ticketVentaVO.getBoletosXTicketVO()!=null && !ticketVentaVO.getBoletosXTicketVO().isEmpty()){
			ticketVentaVO.setProgramacionVO(ticketVentaVO.getBoletosXTicketVO().get(0).getProgramacionVO());
			//ticketVentaVO.setFechaExhibicion(ticketVentaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
			
			Calendar calExhibicion = Calendar.getInstance();
			calExhibicion.setTime(ticketVentaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
			
			Calendar calHorario = Calendar.getInstance();
			calHorario.setTime(ticketVentaVO.getBoletosXTicketVO().get(0).getProgramacionVO().getHorario());

			calExhibicion.set(Calendar.HOUR_OF_DAY,calHorario.get(Calendar.HOUR_OF_DAY) ); 
			calExhibicion.set(Calendar.MINUTE, calHorario.get(Calendar.MINUTE) );
			calExhibicion.set(Calendar.SECOND, calHorario.get(Calendar.SECOND) );

			Date fechaExhibicion = calExhibicion.getTime();

			ticketVentaVO.setFechaExhibicion(fechaExhibicion);
			Date today= new Date();
			ticketVentaVO.setExhibicionVencida(fechaExhibicion.getTime() >= today.getTime() ? false : true);
		}
		
		ticketVentaVO.setSubtotal(totalPago);
		
		ticketVentaVO.setDevolucionesVO(DevolucionAssembler.getDevolucionesVO(ticketVenta.getDevolucions()));
		
		return ticketVentaVO;
	}
	
	public static TicketVentaProductoVO getTicketVentaProductoVO(TicketVenta ticketVenta, List<PaquetesXTicket> paquetesXTicket, List<ProductosXTicket> productosXTicket) {
		
		if (ticketVenta == null)
			return null;

		BigDecimal totalPago= new BigDecimal(0);
		totalPago=totalPago.add(ticketVenta.getTotal());
		totalPago=totalPago.subtract(ticketVenta.getDescuento());
		
		TicketVentaProductoVO ticketVentaVO = new TicketVentaProductoVO();
		ticketVentaVO.setIdTicket(ticketVenta.getIdTicket());
		ticketVentaVO.setPuntoVentaVO(PuntoVentaAssembler.getPuntoVentaVO(ticketVenta.getPuntoVenta()));
		ticketVentaVO.setUsuarioVO(UsuarioAssembler.getUsuarioVO(ticketVenta.getUsuario().getIdUsuario()));
		ticketVentaVO.setFecha(ticketVenta.getFecha());
		ticketVentaVO.setDescuento(ticketVenta.getImporte());
		ticketVentaVO.setImporte(ticketVenta.getImporte());
		ticketVentaVO.setTotal(ticketVenta.getTotal());
		//ticketVentaVO.setProductosXTicketVO(ProductoXTicketAssembler.getProductosXTicketVO(ticketVenta.getProductosXTickets()));
		ticketVentaVO.setPagosVO(PagoAssembler.getPagosVO(ticketVenta.getPagos()));

		List<PaqueteXTicketVO> paquetesXTicketVO = new 	ArrayList<PaqueteXTicketVO>();
		
		if (paquetesXTicket!= null && !paquetesXTicket.isEmpty()){
			paquetesXTicketVO.addAll(PaqueteXTicketAssembler.getPaquetesXTicketCustomVO(paquetesXTicket));
		}
		
		if (productosXTicket!= null && !productosXTicket.isEmpty()){
			paquetesXTicketVO.addAll(PaqueteXTicketAssembler.getPaquetesXTicketProductosCustomVO(productosXTicket));
		}

		ticketVentaVO.setPaquetesXTicketVO(paquetesXTicketVO);
		ticketVentaVO.setSubtotal(totalPago);
		
		ticketVentaVO.setDevolucionesVO(DevolucionAssembler.getDevolucionesVO(ticketVenta.getDevolucions()));

		return ticketVentaVO;
	}
	
}
