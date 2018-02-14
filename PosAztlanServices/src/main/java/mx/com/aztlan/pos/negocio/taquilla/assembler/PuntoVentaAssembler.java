package mx.com.aztlan.pos.negocio.taquilla.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.negocio.taquilla.vo.PuntoVentaVO;

public class PuntoVentaAssembler {

	public static PuntoVenta getPuntoVenta(Integer idPuntoVenta){

		if(idPuntoVenta==null )
			return null;

		PuntoVenta puntoVenta= new PuntoVenta();
		puntoVenta.setIdPuntoVenta(idPuntoVenta);
		
		return puntoVenta;
	}

	public static PuntoVentaVO getPuntoVentaVO(PuntoVenta puntoVenta) {
		if(puntoVenta == null )
			return null;
		
		PuntoVentaVO puntoVentaVO= new PuntoVentaVO();
		puntoVentaVO.setIdPuntoVenta(puntoVenta.getIdPuntoVenta());
		puntoVentaVO.setCineVO(CineAssembler.getCineVO(puntoVenta.getCine()));
		//puntoVentaVO.setTipoPuntoVentaVO(tipoPuntoVentaVO);
		puntoVentaVO.setNombre(puntoVenta.getNombre());
		
		return puntoVentaVO;
	}
	
	
}
