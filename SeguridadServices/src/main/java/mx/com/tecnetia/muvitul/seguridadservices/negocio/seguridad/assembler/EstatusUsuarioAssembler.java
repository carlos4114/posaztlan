package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.EstatusUsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusUsuario;

public class EstatusUsuarioAssembler {
	
	public static EstatusUsuarioVO getEstatusUsuarioVO(EstatusUsuario estatusUsuario){
		
		if(estatusUsuario==null)
			return null;
		
		EstatusUsuarioVO estatusUsuarioVO = new EstatusUsuarioVO();
		
		estatusUsuarioVO.setId(estatusUsuario.getIdEstatus());
		estatusUsuarioVO.setNombre(estatusUsuario.getNombre());
		
		return estatusUsuarioVO;
	}
	
	
	public static List<EstatusUsuarioVO> getListaVO(List<EstatusUsuario> estatusUsuarioList){
		
		List<EstatusUsuarioVO> estatusUsuarioListVO = new ArrayList<EstatusUsuarioVO>();
		
		if(estatusUsuarioList==null)
			return estatusUsuarioListVO;
		
		for(EstatusUsuario estatusUsuario:estatusUsuarioList){
			estatusUsuarioListVO.add(getEstatusUsuarioVO(estatusUsuario));
		}
		
		return estatusUsuarioListVO;
	}
	
}
