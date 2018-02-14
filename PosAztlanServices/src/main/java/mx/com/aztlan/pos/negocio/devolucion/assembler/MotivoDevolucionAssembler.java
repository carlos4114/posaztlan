package mx.com.aztlan.pos.negocio.devolucion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MotivoDevolucion;
import mx.com.aztlan.pos.negocio.devolucion.vo.MotivoDevolucionVO;

public class MotivoDevolucionAssembler {
	
	public static MotivoDevolucion getMotivoDevolucion(Integer idMotivoDevolucion){

		if(idMotivoDevolucion==null)
			return null;
		
		MotivoDevolucion motivoDevolucion = new MotivoDevolucion();
		motivoDevolucion.setIdMotivoDevolucion(idMotivoDevolucion);

		return motivoDevolucion;
	}
	
	public static MotivoDevolucionVO getMotivoDevolucionVO(MotivoDevolucion motivoDevolucion){

		if(motivoDevolucion==null)
			return null;
		
		MotivoDevolucionVO motivoDevolucionVO = new MotivoDevolucionVO();
		motivoDevolucionVO.setIdMotivoDevolucion(motivoDevolucion.getIdMotivoDevolucion());
		motivoDevolucionVO.setNombre(motivoDevolucion.getNombre());
		motivoDevolucionVO.setActivo(motivoDevolucion.isActivo());

		return motivoDevolucionVO;
	}
	
}