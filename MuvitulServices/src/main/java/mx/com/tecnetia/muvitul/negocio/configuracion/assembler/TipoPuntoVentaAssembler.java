package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoPuntoVenta;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoPuntoVentaVO;

public class TipoPuntoVentaAssembler {


	public static TipoPuntoVentaVO getTipoPuntoVentaVO(TipoPuntoVenta tipoPuntoVenta) {
		if(tipoPuntoVenta == null )
			return null;
		
		TipoPuntoVentaVO tipoPuntoVentaVO= new TipoPuntoVentaVO();
		tipoPuntoVentaVO.setIdTipoPuntoVenta(tipoPuntoVenta.getIdTipoPuntoVenta());
		tipoPuntoVentaVO.setNombre(tipoPuntoVenta.getNombre());
		tipoPuntoVentaVO.setDescripcion(tipoPuntoVenta.getDescripcion());
		
		return tipoPuntoVentaVO;
	}
	
	
}
