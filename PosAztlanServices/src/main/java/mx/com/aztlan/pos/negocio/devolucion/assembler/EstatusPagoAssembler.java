package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;
import mx.com.aztlan.pos.negocio.devolucion.vo.EstatusPagoVO;

public class EstatusPagoAssembler {

	public static EstatusPagoVO getEstatusPagoVO(EstatusPago  estatusPago){

		if(estatusPago==null )
			return null;

		EstatusPagoVO estatusPagoVO= new EstatusPagoVO();
		estatusPagoVO.setIdEstatus(estatusPago.getIdEstatus());
		estatusPagoVO.setNombre(estatusPago.getNombre());
		estatusPagoVO.setClave(estatusPago.getClave());
		
		return estatusPagoVO;
	}
	
}
