package mx.com.aztlan.pos.negocio.dulceria.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;
import mx.com.aztlan.pos.negocio.dulceria.vo.UnidadMedidaVO;

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
