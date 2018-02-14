package mx.com.aztlan.pos.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicketId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetalleTicketPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteVO;

public class ProductoXTicketAssembler {

	public static ProductosXTicket getProductoXTicket(PaqueteVO paqueteVO, TicketVenta  ticketVenta){

		if(paqueteVO==null )
			return null;
		
		ProductosXTicketId id= new ProductosXTicketId();
		id.setIdProducto(paqueteVO.getIdPaquete());
		id.setIdTicket(ticketVenta.getIdTicket());

		ProductosXTicket productoXTicket = new ProductosXTicket();
		productoXTicket.setId(id);
		productoXTicket.setProducto(ProductoAssembler.getProducto(paqueteVO.getIdPaquete()));
		productoXTicket.setTicketVenta(ticketVenta);
		productoXTicket.setCantidad(paqueteVO.getCantidad());
		productoXTicket.setImporte(paqueteVO.getImporte());
		
		return productoXTicket;
		
	}
	
	public static List<ProductosXTicket> getProductosXTicket(List<PaqueteVO> paquetesVO, TicketVenta  ticketVenta) {
		
		if(paquetesVO==null || paquetesVO.isEmpty())
			return null;
		
		List<ProductosXTicket> productosXTicket = new ArrayList<ProductosXTicket>();
		
		for (PaqueteVO paqueteVO : paquetesVO) {
			if(!paqueteVO.isPaquete() &&  paqueteVO.getCantidad() > 0){
				productosXTicket.add(ProductoXTicketAssembler.getProductoXTicket(paqueteVO, ticketVenta));
			}
		}

		return productosXTicket;
	}

	public static DetalleTicketPdfVO getDetalleTicketPdfVO(ProductosXTicket productoXTicket) {

		if (productoXTicket == null)
			return null;

		BigDecimal precio = new BigDecimal(0);
		precio=	precio.add(productoXTicket.getImporte());
		precio=precio.divide(new BigDecimal(productoXTicket.getCantidad()), 2, BigDecimal.ROUND_HALF_EVEN);
		DetalleTicketPdfVO detalleTicketVO = new DetalleTicketPdfVO();
		detalleTicketVO.setCantidad(productoXTicket.getCantidad());
		detalleTicketVO.setDescripcion(productoXTicket.getProducto().getNombre());
		detalleTicketVO.setPrecio(precio);
		detalleTicketVO.setSubtotal(productoXTicket.getImporte());

		return detalleTicketVO;
	}

	public static List<DetalleTicketPdfVO> getDetallesTicketPdfVO(Set<ProductosXTicket> productosXTicket) {

		if (productosXTicket == null || productosXTicket.isEmpty())
			return null;

		List<DetalleTicketPdfVO> detallesTicketVO = new ArrayList<DetalleTicketPdfVO>();

		for (ProductosXTicket productoXTicket : productosXTicket) {
			detallesTicketVO.add(ProductoXTicketAssembler.getDetalleTicketPdfVO(productoXTicket));
		}

		return detallesTicketVO;
	}

}
