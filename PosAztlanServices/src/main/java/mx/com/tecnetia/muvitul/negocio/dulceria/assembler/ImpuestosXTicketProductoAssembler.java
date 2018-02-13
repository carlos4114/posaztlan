package mx.com.tecnetia.muvitul.negocio.dulceria.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoXProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketProducto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketProductoId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.DetalleImpuestoPdfVO;

public class ImpuestosXTicketProductoAssembler {

	public static ImpuestosXTicketProducto getImpuestosXTicketProducto(TicketVenta ticketVenta, ImpuestoXProducto impuestoXProducto, BigDecimal importeImpProducto){

		if(impuestoXProducto==null || ticketVenta==null || importeImpProducto==null )
			return null;
		
		ImpuestosXTicketProductoId id= new ImpuestosXTicketProductoId();
		id.setIdImpuestoXProducto(impuestoXProducto.getIdImpuestoXProducto());
		id.setIdTicket(ticketVenta.getIdTicket());
		ImpuestosXTicketProducto impuestoXTicketProducto = new ImpuestosXTicketProducto();
		impuestoXTicketProducto.setId(id);
		impuestoXTicketProducto.setImpuestoXProducto(impuestoXProducto);
		impuestoXTicketProducto.setTicketVenta(ticketVenta);
		impuestoXTicketProducto.setImporte(importeImpProducto);

		return impuestoXTicketProducto;
	}
	
	
	public static List<DetalleImpuestoPdfVO> getDetallesImpuestoPdfVO(Set<ImpuestosXTicketProducto> impuestosXTicketProducto){
		
		if(impuestosXTicketProducto==null || impuestosXTicketProducto.isEmpty())
			return null;
		
		
		Map<String, BigDecimal> mapImpProductos= new HashMap<String, BigDecimal>();
		
		for (ImpuestosXTicketProducto impuestoXTicketProducto : impuestosXTicketProducto) {
			String key= impuestoXTicketProducto.getImpuestoXProducto().getNombre();
			
			if (!mapImpProductos.containsKey(key)) {
				BigDecimal importeIva = new BigDecimal(0);
				mapImpProductos.put(key,importeIva);
			}
			
			BigDecimal importeIva = mapImpProductos.get(key);
			importeIva= importeIva.add(impuestoXTicketProducto.getImporte());
			mapImpProductos.put(key, importeIva);
			
		}
		
		return getDetallesImpuestoPdfVO(mapImpProductos);
		
	}

	public static List<DetalleImpuestoPdfVO> getDetallesImpuestoPdfVO(Map<String, BigDecimal> mapImpProductos){

		if(mapImpProductos==null || mapImpProductos.isEmpty())
			return null;
		
		List<DetalleImpuestoPdfVO> detallesImpuestoPdfVO = new ArrayList<DetalleImpuestoPdfVO>();
		
		for (Map.Entry<String, BigDecimal> entry : mapImpProductos.entrySet()) {
			DetalleImpuestoPdfVO detalleImpuestoPdfVO = new DetalleImpuestoPdfVO();
			detalleImpuestoPdfVO.setConcepto(entry.getKey());
			detalleImpuestoPdfVO.setCantidad(entry.getValue());
			detallesImpuestoPdfVO.add(detalleImpuestoPdfVO);
		}

		return detallesImpuestoPdfVO;
	}
	
}
