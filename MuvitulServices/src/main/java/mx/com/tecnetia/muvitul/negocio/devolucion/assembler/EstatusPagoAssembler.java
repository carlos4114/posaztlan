package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusPago;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.EstatusPagoVO;

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
