package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicketId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleTicketPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;

public class PromocionXTicketAssembler {

	public static PromocionesXTicket getPromocionXTicket(PromocionXTicketVO promocionXTicketVO, TicketVenta  ticketVenta){

		if(promocionXTicketVO==null )
			return null;
		
		PromocionesXTicket promocionXTicket = new PromocionesXTicket();
		PromocionesXTicketId id= new PromocionesXTicketId();
		id.setIdPromocion(promocionXTicketVO.getPromocionVO().getIdPromocion());
		id.setIdTicket(ticketVenta.getIdTicket());
		promocionXTicket.setId(id);
		promocionXTicket.setPromocion(PromocionAssembler.getPromocion(promocionXTicketVO.getPromocionVO().getIdPromocion()));
		promocionXTicket.setTicketVenta(ticketVenta);
		promocionXTicket.setCantidad(promocionXTicketVO.getCantidad());
		promocionXTicket.setImporte(promocionXTicketVO.getImporte());

		return promocionXTicket;
		
	}
	
	public static List<PromocionesXTicket> getPromocionesXTicket(List<PromocionXTicketVO> promocionesXTicketVO,TicketVenta  ticketVenta){

		if(promocionesXTicketVO==null || promocionesXTicketVO.isEmpty())
			return null;
		
		List<PromocionesXTicket> promocionesXTicket = new ArrayList<PromocionesXTicket>();
		
		for (PromocionXTicketVO promocionXTicketVO : promocionesXTicketVO) {
			if(promocionXTicketVO.getCantidad() > 0){
				promocionesXTicket.add(PromocionXTicketAssembler.getPromocionXTicket(promocionXTicketVO, ticketVenta));
			}
		}

		return promocionesXTicket;
	}
	
	public static DetalleTicketPdfVO getDetalleTicketPdfVO(PromocionesXTicket promocionXTicket) {

		if (promocionXTicket == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(promocionXTicket.getImporte());
		precio=precio.divide(new BigDecimal(promocionXTicket.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		
		DetalleTicketPdfVO detalleTicketVO = new DetalleTicketPdfVO();
		detalleTicketVO.setCantidad(promocionXTicket.getCantidad());
		detalleTicketVO.setDescripcion(promocionXTicket.getPromocion().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(promocionXTicket.getImporte().negate());

		return detalleTicketVO;
	}

	public static List<DetalleTicketPdfVO> getDetallesTicketPdfVO(Set<PromocionesXTicket>  promocionesXTicket) {

		if (promocionesXTicket == null || promocionesXTicket.isEmpty())
			return null;

		List<DetalleTicketPdfVO> detallesTicketVO = new ArrayList<DetalleTicketPdfVO>();

		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			detallesTicketVO.add(PromocionXTicketAssembler.getDetalleTicketPdfVO(promocionXTicket));
		}

		return detallesTicketVO;
	}

	
}
