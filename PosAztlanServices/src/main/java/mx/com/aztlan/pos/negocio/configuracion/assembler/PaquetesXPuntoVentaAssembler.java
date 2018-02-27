package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVentaId;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaquetesXPuntoVentaVO;

public class PaquetesXPuntoVentaAssembler {

	public static PaquetesXPuntoVenta getPaqueteXPuntoVenta(PaquetesXPuntoVentaVO paquetesXPuntoVentaVO){
		
		if(paquetesXPuntoVentaVO==null)
			return null;
		
		PaquetesXPuntoVenta paquetesXPuntoVenta = new PaquetesXPuntoVenta();
		paquetesXPuntoVenta.setId(new PaquetesXPuntoVentaId(paquetesXPuntoVentaVO.getPuntoVenta().getIdPuntoVenta(), paquetesXPuntoVentaVO.getPaquete().getIdPaquete()));
		paquetesXPuntoVenta.setPaquete(paquetesXPuntoVentaVO.getPaquete());
		paquetesXPuntoVenta.setPuntoVenta(paquetesXPuntoVentaVO.getPuntoVenta());
		
		return paquetesXPuntoVenta;
	}
	
}
