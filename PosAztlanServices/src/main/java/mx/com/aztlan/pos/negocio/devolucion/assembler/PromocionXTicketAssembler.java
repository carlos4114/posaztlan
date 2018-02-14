package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionesXTicket;
import mx.com.aztlan.pos.negocio.devolucion.vo.DetalleTicketPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.PromocionXTicketVO;


public class PromocionXTicketAssembler {

	public static List<PromocionXTicketVO> getPromocionesXTicketVO(Set<PromocionesXTicket> promocionesXTicket) {

		if (promocionesXTicket == null || promocionesXTicket.isEmpty())
			return null;

		List<PromocionXTicketVO> promocionesXTicketVO = new ArrayList<PromocionXTicketVO>();

		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionesXTicketVO.add(PromocionXTicketAssembler.getPromocionXTicketVO(promocionXTicket));
		}

		return promocionesXTicketVO;
	}
	
	
	public static PromocionXTicketVO getPromocionXTicketVO(PromocionesXTicket promocionXTicket) {

		if (promocionXTicket == null)
			return null;

		PromocionXTicketVO promocionXTicketVO = new PromocionXTicketVO();
		promocionXTicketVO.setPromocionVO(PromocionAssembler.getPromocionVO(promocionXTicket.getPromocion()));
		promocionXTicketVO.setCantidad(promocionXTicket.getCantidad());
		promocionXTicketVO.setImporte(promocionXTicket.getImporte());
		

		return promocionXTicketVO;
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

}
