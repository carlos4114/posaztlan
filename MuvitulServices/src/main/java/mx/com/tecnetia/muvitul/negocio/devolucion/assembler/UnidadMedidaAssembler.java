package mx.com.tecnetia.muvitul.negocio.devolucion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.UnidadMedida;
import mx.com.tecnetia.muvitul.negocio.devolucion.vo.UnidadMedidaVO;

public class UnidadMedidaAssembler {

	public static UnidadMedidaVO getUnidadMedidaVO(UnidadMedida unidadMedida){
		if(unidadMedida==null)
			return null;
		
		UnidadMedidaVO unidadMedidaVO = new UnidadMedidaVO();
		unidadMedidaVO.setIdUnidadMedida(unidadMedida.getIdUnidadMedida());
		unidadMedidaVO.setNombre(unidadMedida.getNombre());
		unidadMedidaVO.setActivo(unidadMedida.isActivo());

		return unidadMedidaVO;
	}
	
}
