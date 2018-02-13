package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquillaId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleImpuestoPdfVO;

public class ImpuestoXTicketTaquillaAssembler {
	
	public static  ImpuestosXTicketTaquilla getImpuestosXTicketTaquilla(Integer idImpuestoBoleto,TicketVenta  ticketVenta, BigDecimal importe){
		
		if(idImpuestoBoleto==null && ticketVenta==null )
			return null;
		
		ImpuestosXTicketTaquilla impuestosXTicketTaquilla= new ImpuestosXTicketTaquilla();
		ImpuestosXTicketTaquillaId id= new ImpuestosXTicketTaquillaId();
		id.setIdImpuestoBoleto(idImpuestoBoleto);
		id.setIdTicket(ticketVenta.getIdTicket());
		impuestosXTicketTaquilla.setId(id);
		impuestosXTicketTaquilla.setImpuestoBoleto(ImpuestoBoletoAssembler.getImpuestoBoleto(idImpuestoBoleto));
		impuestosXTicketTaquilla.setTicketVenta(ticketVenta);
		impuestosXTicketTaquilla.setImporte(importe);
		
		return impuestosXTicketTaquilla;
	}
	
	public static List<DetalleImpuestoPdfVO> getDetallesImpuestoPdfVO(Set<ImpuestosXTicketTaquilla> impuestosXTicketTaquilla ){

		if(impuestosXTicketTaquilla==null || impuestosXTicketTaquilla.isEmpty())
			return null;
		
		List<DetalleImpuestoPdfVO> detalleImpuestoPdfVO = new ArrayList<DetalleImpuestoPdfVO>();
		
		for (ImpuestosXTicketTaquilla impuestoXTicketTaquilla : impuestosXTicketTaquilla) {
			detalleImpuestoPdfVO.add(ImpuestoXTicketTaquillaAssembler.getDetalleImpuestoPdfVO(impuestoXTicketTaquilla));
		}

		return detalleImpuestoPdfVO;
	}
	
	
	public static DetalleImpuestoPdfVO getDetalleImpuestoPdfVO(ImpuestosXTicketTaquilla impuestoXTicketTaquilla ){
		
		if(impuestoXTicketTaquilla==null )
			return null;

		DetalleImpuestoPdfVO detalleImpuestoPdfVO = new DetalleImpuestoPdfVO();
		detalleImpuestoPdfVO.setConcepto(impuestoXTicketTaquilla.getImpuestoBoleto().getNombre());
		detalleImpuestoPdfVO.setCantidad(impuestoXTicketTaquilla.getImporte());

		return detalleImpuestoPdfVO;
		
	}

		

}
