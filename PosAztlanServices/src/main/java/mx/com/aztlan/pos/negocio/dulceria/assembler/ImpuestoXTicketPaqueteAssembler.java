package mx.com.aztlan.pos.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestosXTicketPaquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetalleImpuestoPdfVO;

public class ImpuestoXTicketPaqueteAssembler {

	public static ImpuestosXTicketPaquete getImpuestoXTicketPaquete(TicketVenta ticketVenta, BigDecimal importe,  BigDecimal porcentaje){

		if(ticketVenta==null || importe==null || porcentaje==null)
			return null;
		
		ImpuestosXTicketPaquete impuestoXTicketPaquete = new ImpuestosXTicketPaquete();
		impuestoXTicketPaquete.setTicketVenta(ticketVenta);
		impuestoXTicketPaquete.setImporte(importe);
		impuestoXTicketPaquete.setPorcentaje(porcentaje);

		return impuestoXTicketPaquete;
	}

	public static List<DetalleImpuestoPdfVO> getDetallesImpuestoPdfVO(Set<ImpuestosXTicketPaquete> impuestosXTicketPaquetes) {

		if(impuestosXTicketPaquetes==null || impuestosXTicketPaquetes.isEmpty())
			return null;
		
		List<DetalleImpuestoPdfVO> detallesImpuestoPdfVO = new ArrayList<DetalleImpuestoPdfVO>();
		BigDecimal impuestoTotal = new BigDecimal(0);

		for (ImpuestosXTicketPaquete impuestoXTicketPaquete : impuestosXTicketPaquetes) {
			impuestoTotal =impuestoTotal.add(impuestoXTicketPaquete.getImporte());
		}
		
		DetalleImpuestoPdfVO detalleImpuestoPdfVO= new DetalleImpuestoPdfVO();
		detalleImpuestoPdfVO.setConcepto("IVA Paq.");
		detalleImpuestoPdfVO.setCantidad(impuestoTotal);
		detallesImpuestoPdfVO.add(detalleImpuestoPdfVO);
		
		return detallesImpuestoPdfVO;
	}
	
}
