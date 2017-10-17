package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.DetalleTicketPdfVO;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.PaqueteVO;

public class PaqueteXTicketAssembler {
	
	public static PaquetesXTicket getPaqueteXTicket(PaqueteVO paqueteVO, TicketVenta  ticketVenta){

		if(paqueteVO==null )
			return null;
		
		PaquetesXTicket paqueteXTicket = new PaquetesXTicket();
		PaquetesXTicketId id= new PaquetesXTicketId();
		id.setIdPaquete(paqueteVO.getIdPaquete());
		id.setIdTicket(ticketVenta.getIdTicket());
		paqueteXTicket.setId(id);
		paqueteXTicket.setPaquete(PaqueteAssembler.getPaquete(paqueteVO.getIdPaquete()));
		paqueteXTicket.setTicketVenta(ticketVenta);
		paqueteXTicket.setCantidad(paqueteVO.getCantidad());
		paqueteXTicket.setImporte(paqueteVO.getImporte());

		return paqueteXTicket;
		
	}
	

	public static List<PaquetesXTicket> getPaquetesXTicket(List<PaqueteVO> paquetesVO, TicketVenta  ticketVenta) {
		
		if(paquetesVO==null || paquetesVO.isEmpty())
			return null;
		
		List<PaquetesXTicket> paquetesXTicket = new ArrayList<PaquetesXTicket>();
		
		for (PaqueteVO paqueteVO : paquetesVO) {
			if(paqueteVO.isPaquete() &&  paqueteVO.getCantidad() > 0){
				paquetesXTicket.add(PaqueteXTicketAssembler.getPaqueteXTicket(paqueteVO, ticketVenta));
			}
		}

		return paquetesXTicket;
	}

	public static DetalleTicketPdfVO getDetalleTicketVO(PaquetesXTicket paqueteXTickett) {

		if (paqueteXTickett == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(paqueteXTickett.getImporte());
		precio=precio.divide(new BigDecimal(paqueteXTickett.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		DetalleTicketPdfVO detalleTicketVO = new DetalleTicketPdfVO();
		detalleTicketVO.setCantidad(paqueteXTickett.getCantidad());
		detalleTicketVO.setDescripcion(paqueteXTickett.getPaquete().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(paqueteXTickett.getImporte());

		return detalleTicketVO;
	}

	public static List<DetalleTicketPdfVO> getDetallesTicketVO(Set<PaquetesXTicket> paquetesXTicket) {

		if (paquetesXTicket == null || paquetesXTicket.isEmpty())
			return null;

		List<DetalleTicketPdfVO> detallesTicketVO = new ArrayList<DetalleTicketPdfVO>();

		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			detallesTicketVO.add(PaqueteXTicketAssembler.getDetalleTicketVO(paqueteXTicket));
		}

		return detallesTicketVO;
	}	
	
}
