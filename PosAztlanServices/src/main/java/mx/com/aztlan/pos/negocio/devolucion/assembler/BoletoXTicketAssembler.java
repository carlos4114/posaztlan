package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.BoletosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PromocionesXTicket;
import mx.com.aztlan.pos.negocio.devolucion.vo.BoletoXTicketVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DetalleTicketPdfVO;

public class BoletoXTicketAssembler {
	
	public static List<BoletoXTicketVO> getBoletosXTicketVO(Set<BoletosXTicket> boletosXTicket) {

		if (boletosXTicket == null || boletosXTicket.isEmpty())
			return null;

		List<BoletoXTicketVO> boletosXTicketVO = new ArrayList<BoletoXTicketVO>();

		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletosXTicketVO.add(BoletoXTicketAssembler.getBoletoXTicketVO(boletoXTicket));
		}

		return boletosXTicketVO;
	}
	
	
	public static BoletoXTicketVO getBoletoXTicketVO(BoletosXTicket boletoXTicket) {

		if (boletoXTicket == null)
			return null;

		BoletoXTicketVO boletoXTicketVO = new BoletoXTicketVO();
		boletoXTicketVO.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(boletoXTicket.getProgramacion()));
		boletoXTicketVO.setTipoClienteVO(TipoClienteAssembler.getTipoClienteVO(boletoXTicket.getTipoCliente()));
		boletoXTicketVO.setCantidad(boletoXTicket.getCantidad());
		boletoXTicketVO.setImporte(boletoXTicket.getImporte());
		boletoXTicketVO.setFechaExhibicion(boletoXTicket.getFechaExhibicion());
		
		return boletoXTicketVO;
	}
	
	
	public static List<BoletoXTicketVO> getBoletosXTicketPromocionesVO(Set<PromocionesXTicket> promocionesXTicket) {

		if (promocionesXTicket == null || promocionesXTicket.isEmpty())
			return null;

		List<BoletoXTicketVO> boletosXTicketVO = new ArrayList<BoletoXTicketVO>();

		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			boletosXTicketVO.add(BoletoXTicketAssembler.getBoletoXTicketPromocionVO(promocionXTicket));
		}

		return boletosXTicketVO;
	}
	
	
	public static BoletoXTicketVO getBoletoXTicketPromocionVO(PromocionesXTicket promocionXTicket) {

		if (promocionXTicket == null)
			return null;

		BoletoXTicketVO boletoXTicketVO = new BoletoXTicketVO();
		boletoXTicketVO.setTipoClienteVO(TipoClienteAssembler.getTipoClientePromocionVO(promocionXTicket.getPromocion()));
		boletoXTicketVO.setCantidad(promocionXTicket.getCantidad());
		boletoXTicketVO.setImporte(promocionXTicket.getImporte().negate());

		return boletoXTicketVO;
	}
	
	public static List<DetalleTicketPdfVO> getDetallesTicketPdfVO(Set<BoletosXTicket> boletosXTicket) {

		if (boletosXTicket == null || boletosXTicket.isEmpty())
			return null;

		List<DetalleTicketPdfVO> detallesTicketVO = new ArrayList<DetalleTicketPdfVO>();

		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			detallesTicketVO.add(BoletoXTicketAssembler.getDetalleTicketPdfVO(boletoXTicket));
		}

		return detallesTicketVO;
	}
	
	
	public static DetalleTicketPdfVO getDetalleTicketPdfVO(BoletosXTicket boletoXTicket) {

		if (boletoXTicket == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(boletoXTicket.getImporte());
		precio=precio.divide(new BigDecimal(boletoXTicket.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		DetalleTicketPdfVO detalleTicketVO = new DetalleTicketPdfVO();
		detalleTicketVO.setCantidad(boletoXTicket.getCantidad());
		detalleTicketVO.setDescripcion(boletoXTicket.getTipoCliente().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(boletoXTicket.getImporte());

		return detalleTicketVO;
	}
}