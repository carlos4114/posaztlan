package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Devolucion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DevolucionXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstadoProducto;

public class DevolucionXProductoAssembler {

	public static DevolucionXProducto getDevolucionXProducto(Devolucion devolucion,EstadoProducto estadoProducto,Integer idTicket, Integer id, Integer idProducto){
		
		if(devolucion==null)
			return null;
		
		String clave=String.valueOf(idTicket)+String.valueOf(id)+String.valueOf(idProducto);
		DevolucionXProducto devolucionXProducto = new DevolucionXProducto();
		devolucionXProducto.setDevolucion(devolucion);
		devolucionXProducto.setTicketVenta(TicketVentaAssembler.getTicketVenta(idTicket));
		devolucionXProducto.setProducto(ProductoAssembler.getProducto(idProducto));
		devolucionXProducto.setEstadoProducto(estadoProducto);
		devolucionXProducto.setClave(clave);
		
		return devolucionXProducto;
	}
	
//	public static List<DevolucionVO> getDevolucionesVO(Set<Devolucion> devoluciones){
//		
//		if(devoluciones==null)
//			return null;
//		
//		List<DevolucionVO> devolucionesVO= new ArrayList<DevolucionVO>();
//		
//		for (Devolucion devolucion : devoluciones) {
//			devolucionesVO.add(DevolucionXProductoAssembler.getDevolucionVO(devolucion));
//		}
//
//		return devolucionesVO;
//	
//	}


}
