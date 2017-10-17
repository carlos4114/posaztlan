package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PuntoVenta;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;

public class PuntoVentaAssembler {


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
