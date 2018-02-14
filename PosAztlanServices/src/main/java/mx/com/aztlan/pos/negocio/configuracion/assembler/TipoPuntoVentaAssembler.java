package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoPuntoVenta;
import mx.com.aztlan.pos.negocio.configuracion.vo.TipoPuntoVentaVO;

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
