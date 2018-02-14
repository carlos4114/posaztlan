package mx.com.aztlan.pos.negocio.caja.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Caja;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;

public class CajaAssembler {
	
	public static CatalogoVO getCajaVO(Caja caja){
		
		if(caja==null)
			return null;
		
		CatalogoVO cajaVO = new CatalogoVO();
		
		cajaVO.setId(caja.getIdCaja());
		cajaVO.setNombre(caja.getNombre());
		
		return cajaVO;
	}
	
	
	public static List<CatalogoVO> getListaVO(List<Caja> cajasList){
		
		List<CatalogoVO> cajasListVO = new ArrayList<CatalogoVO>();
		
		if(cajasList==null)
			return cajasListVO;
		
		for(Caja caja:cajasList){
			cajasListVO.add(getCajaVO(caja));
		}
		
		return cajasListVO;
	}
	
}
