package mx.com.aztlan.pos.negocio.devolucion.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.negocio.devolucion.vo.ProductoXTicketVO;


public class ProductoXTicketAssembler {

	public static List<ProductoXTicketVO> getProductosXTicketVO(Set<ProductosXTicket> productosXTicket) {

		if (productosXTicket == null || productosXTicket.isEmpty())
			return null;

		List<ProductoXTicketVO> productosXTicketVO = new ArrayList<ProductoXTicketVO>();

		for (ProductosXTicket productoXTicket : productosXTicket) {
			productosXTicketVO.add(ProductoXTicketAssembler.getProductoXTicketVO(productoXTicket));
		}

		return productosXTicketVO;
	}
	
	
	public static ProductoXTicketVO getProductoXTicketVO(ProductosXTicket productoXTicket) {

		if (productoXTicket == null)
			return null;

		ProductoXTicketVO productoXTicketVO = new ProductoXTicketVO();
		productoXTicketVO.setProductoVO(ProductoAssembler.getProductoVO(productoXTicket.getProducto()));
		productoXTicketVO.setCantidad(productoXTicket.getCantidad());
		productoXTicketVO.setImporte(productoXTicket.getImporte());

		return productoXTicketVO;
	}
	
	
}
