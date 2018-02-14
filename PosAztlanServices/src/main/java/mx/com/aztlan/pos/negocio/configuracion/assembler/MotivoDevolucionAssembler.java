package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MotivoDevolucion;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoDevolucionVO;

public class MotivoDevolucionAssembler {

	public static MotivoDevolucionVO getMotivoDevolucionVO(MotivoDevolucion motivoDevolucion){

		if(motivoDevolucion==null )
			return null;
		
		MotivoDevolucionVO motivoDevolucionVO = new MotivoDevolucionVO();
		motivoDevolucionVO.setIdMotivoDevolucion(motivoDevolucion.getIdMotivoDevolucion());
		motivoDevolucionVO.setNombre(motivoDevolucion.getNombre());
		motivoDevolucionVO.setActivo(motivoDevolucion.isActivo());

		return motivoDevolucionVO;
	}
	
	public static List<MotivoDevolucionVO> getMotivosDevolucionVO(List<MotivoDevolucion> motivosDevolucion){

		if(motivosDevolucion==null || motivosDevolucion.isEmpty())
			return null;
		
		List<MotivoDevolucionVO> motivosDevolucionVO = new ArrayList<MotivoDevolucionVO>();
		
		for (MotivoDevolucion motivoDevolucion : motivosDevolucion) {
			motivosDevolucionVO.add(MotivoDevolucionAssembler.getMotivoDevolucionVO(motivoDevolucion));
		}

		return motivosDevolucionVO;
	}
	
}
