package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MotivoCancelacion;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoCancelacionVO;

public class MotivoCancelacionAssembler {
	
	public static MotivoCancelacionVO getMotivoCancelacionVO(MotivoCancelacion motivoCancelacion){

		if(motivoCancelacion==null )
			return null;
		
		MotivoCancelacionVO motivoCancelacionVO = new MotivoCancelacionVO();
		motivoCancelacionVO.setIdMotivoCancelacion(motivoCancelacion.getIdMotivoCancelacion());
		motivoCancelacionVO.setNombre(motivoCancelacion.getNombre());
		motivoCancelacionVO.setActivo(motivoCancelacion.isActivo());
		
		return motivoCancelacionVO;
	}
	
	public static List<MotivoCancelacionVO> getMotivosCancelacionVO(List<MotivoCancelacion> motivosCancelacion){

		if(motivosCancelacion==null || motivosCancelacion.isEmpty())
			return null;
		
		List<MotivoCancelacionVO> motivosCancelacionVO = new ArrayList<MotivoCancelacionVO>();
		
		for (MotivoCancelacion motivoCancelacion : motivosCancelacion) {
			motivosCancelacionVO.add(MotivoCancelacionAssembler.getMotivoCancelacionVO(motivoCancelacion));
		}

		return motivosCancelacionVO;
	}
	
}
