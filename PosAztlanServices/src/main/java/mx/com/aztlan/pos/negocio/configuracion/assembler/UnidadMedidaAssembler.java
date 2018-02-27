package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.UnidadMedida;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;

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
	
	public static List<UnidadMedidaVO> getUnidadesMedidaVO(List<UnidadMedida> unidadesMedida){

		List<UnidadMedidaVO> unidadMedidaVO = new ArrayList<UnidadMedidaVO>();
		
		for (UnidadMedida uMedida : unidadesMedida) {
			unidadMedidaVO.add(UnidadMedidaAssembler.getUnidadMedidaVO(uMedida));
		}

		return unidadMedidaVO;

	}
	
}
