package mx.com.aztlan.pos.negocio.caja.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CargoAjuste;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;

public class CargoAjusteAssembler {
	
	public static CatalogoVO getCargoAjusteVO(CargoAjuste cargoAjuste){
		
		if(cargoAjuste==null)
			return null;
		
		CatalogoVO cargoAjusteVO = new CatalogoVO();
		
		cargoAjusteVO.setId(cargoAjuste.getIdCargoAjuste());
		cargoAjusteVO.setNombre(cargoAjuste.getNombre());
		
		return cargoAjusteVO;
	}
	
	
	public static List<CatalogoVO> getListaVO(List<CargoAjuste> cargoAjusteList){
		
		List<CatalogoVO> cargoAjusteListVO = new ArrayList<CatalogoVO>();
		
		if(cargoAjusteList==null)
			return cargoAjusteListVO;
		
		for(CargoAjuste cargoAjuste:cargoAjusteList){
			cargoAjusteListVO.add(getCargoAjusteVO(cargoAjuste));
		}
		
		return cargoAjusteListVO;
	}
	
}
