package mx.com.aztlan.pos.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Canal;
import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;

public class CanalAssembler {

	public static CanalVO getCanalVO(Canal canal){
		if(canal==null)
			return null;
		
		CanalVO canalVO = new CanalVO();
		canalVO.setIdCanal(canal.getIdCanal());
		canalVO.setNombre(canal.getNombre());
		canalVO.setActivo(canal.isActivo());
		
		return canalVO;
	}
	
	public static Canal getCanal(Integer idCanal){
		
		if(idCanal==null)
			return null;
		
		Canal canal = new Canal();
		canal.setIdCanal(idCanal);

		return canal;
	}
	
	public static List<CanalVO> getCanalesVO(List<Canal> canales){
		
		if(canales==null || canales.isEmpty())
			return null;
		
		List<CanalVO> canalesVO = new ArrayList<CanalVO>();
		
		for (Canal canal: canales) {
			canalesVO.add(CanalAssembler.getCanalVO(canal));
		}

		return canalesVO;
		
	}

	
}
