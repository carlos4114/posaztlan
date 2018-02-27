package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PuntoVenta;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntoVentaVO;

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
		puntoVentaVO.setTipoPuntoVentaVO(TipoPuntoVentaAssembler.getTipoPuntoVentaVO(puntoVenta.getTipoPuntoVenta()));
		puntoVentaVO.setNombre(puntoVenta.getNombre());
		
		return puntoVentaVO;
	}
	
	
	public static List<PuntoVentaVO> getPuntosVentaVO(List<PuntoVenta> puntosVenta){

		if(puntosVenta==null || puntosVenta.isEmpty())
			return null;
		
		List<PuntoVentaVO> puntosVentaVO = new ArrayList<PuntoVentaVO>();
		
		for (PuntoVenta puntoVenta : puntosVenta) {
			puntosVentaVO.add(PuntoVentaAssembler.getPuntoVentaVO(puntoVenta));
		}

		return puntosVentaVO;
	}
	
	
}
