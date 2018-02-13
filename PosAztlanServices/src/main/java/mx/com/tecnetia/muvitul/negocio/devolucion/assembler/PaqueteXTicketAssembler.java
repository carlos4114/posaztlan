package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PaquetesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ProductosXTicket;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.PaqueteXTicketVO;

public class PaqueteXTicketAssembler {

	public static List<PaqueteXTicketVO> getPaquetesXTicketVO(Set<PaquetesXTicket> paquetesXTicket) {

		if (paquetesXTicket == null || paquetesXTicket.isEmpty())
			return null;

		List<PaqueteXTicketVO> paquetesXTicketVO = new ArrayList<PaqueteXTicketVO>();

		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {

			paquetesXTicketVO.add(PaqueteXTicketAssembler.getPaqueteXTicketVO(paqueteXTicket));
		}

		return paquetesXTicketVO;
	}
	
	public static List<PaqueteXTicketVO> getPaquetesXTicketCustomVO(List<PaquetesXTicket> paquetesXTicket) {

		if (paquetesXTicket == null || paquetesXTicket.isEmpty())
			return null;

		List<PaqueteXTicketVO> paquetesXTicketVO = new ArrayList<PaqueteXTicketVO>();

		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			
			for (int i = 0; i < paqueteXTicket.getCantidad(); i++) {
				paquetesXTicketVO.add(PaqueteXTicketAssembler.getPaqueteXTicketCustomVO(paqueteXTicket));
			}

		}

		return paquetesXTicketVO;
	}
	
	
	public static PaqueteXTicketVO getPaqueteXTicketVO(PaquetesXTicket paqueteXTicket) {

		if (paqueteXTicket == null)
			return null;

		PaqueteXTicketVO paqueteXTicketVO = new PaqueteXTicketVO();
		paqueteXTicketVO.setPaqueteVO(PaqueteAssembler.getPaqueteVO(paqueteXTicket.getPaquete()));
		paqueteXTicketVO.setCantidad(paqueteXTicket.getCantidad());
		paqueteXTicketVO.setImporte(paqueteXTicket.getImporte());

		return paqueteXTicketVO;
	}

	public static PaqueteXTicketVO getPaqueteXTicketCustomVO(PaquetesXTicket paqueteXTicket) {

		if (paqueteXTicket == null)
			return null;

		BigDecimal importe = new BigDecimal(0);
		importe = importe.add(paqueteXTicket.getImporte());
		importe = importe.divide(new BigDecimal(paqueteXTicket.getCantidad()), 3, BigDecimal.ROUND_HALF_EVEN);
		 
		PaqueteXTicketVO paqueteXTicketVO = new PaqueteXTicketVO();
		paqueteXTicketVO.setPaqueteVO(PaqueteAssembler.getPaqueteVO(paqueteXTicket.getPaquete()));
		paqueteXTicketVO.setCantidad(1);
		paqueteXTicketVO.setImporte(importe);

		return paqueteXTicketVO;
	}


	public static List<PaqueteXTicketVO> getPaquetesXTicketProductosVO(Set<ProductosXTicket> productosXTickets) {
		if (productosXTickets == null || productosXTickets.isEmpty())
			return null;

		List<PaqueteXTicketVO> paquetesXTicketVO = new ArrayList<PaqueteXTicketVO>();

		for (ProductosXTicket productoXTicket : productosXTickets) {
			paquetesXTicketVO.add(PaqueteXTicketAssembler.getPaqueteXTicketProductoVO(productoXTicket));
		}
		return paquetesXTicketVO;

	}

	public static List<PaqueteXTicketVO> getPaquetesXTicketProductosCustomVO(List<ProductosXTicket> productosXTickets) {
		if (productosXTickets == null || productosXTickets.isEmpty())
			return null;

		List<PaqueteXTicketVO> paquetesXTicketVO = new ArrayList<PaqueteXTicketVO>();

		for (ProductosXTicket productoXTicket : productosXTickets) {
			
			for (int i = 0; i < productoXTicket.getCantidad(); i++) {
				paquetesXTicketVO.add(PaqueteXTicketAssembler.getPaqueteXTicketProductoCustomVO(productoXTicket));
			}
			
		}
		return paquetesXTicketVO;

	}
	
	private static PaqueteXTicketVO getPaqueteXTicketProductoVO(ProductosXTicket productoXTicket) {
		if (productoXTicket == null)
			return null;

		PaqueteXTicketVO paqueteXTicketVO = new PaqueteXTicketVO();
		paqueteXTicketVO.setPaqueteVO(PaqueteAssembler.getPaqueteProductoVO(productoXTicket.getProducto()));
		paqueteXTicketVO.setCantidad(productoXTicket.getCantidad());
		paqueteXTicketVO.setImporte(productoXTicket.getImporte());

		return paqueteXTicketVO;
	}
	
	private static PaqueteXTicketVO getPaqueteXTicketProductoCustomVO(ProductosXTicket productoXTicket) {
		if (productoXTicket == null)
			return null;

		BigDecimal importe = new BigDecimal(0);
		importe = importe.add(productoXTicket.getImporte());
		importe = importe.divide(new BigDecimal(productoXTicket.getCantidad()), 3, BigDecimal.ROUND_HALF_EVEN);
		
		PaqueteXTicketVO paqueteXTicketVO = new PaqueteXTicketVO();
		paqueteXTicketVO.setPaqueteVO(PaqueteAssembler.getPaqueteProductoVO(productoXTicket.getProducto()));
		paqueteXTicketVO.setCantidad(1);
		paqueteXTicketVO.setImporte(importe);

		return paqueteXTicketVO;
	}
	
}
