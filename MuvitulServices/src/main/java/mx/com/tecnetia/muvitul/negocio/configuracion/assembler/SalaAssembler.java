package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsientosXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaCupoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaVO;

public class SalaAssembler {
	
	public static SalaCupoVO getSalaCupoVO(Sala sala, CupoXSala cupo, List<AsientosXSala> asientos){
		
		if(sala == null)
			return null;
		
		SalaCupoVO salaVO = new SalaCupoVO();
		salaVO.setActivo(sala.isActivo());
		salaVO.setCupo(cupo.getNoAsientos());
		salaVO.setCupoActivo(cupo.isActivo());
		salaVO.setIdCine(sala.getCine()==null?null:sala.getCine().getIdCine());
		salaVO.setIdCupoSala(cupo.getIdCupoXSala());
		salaVO.setIdSala(sala.getIdSala());
		salaVO.setNombre(sala.getNombre());
		salaVO.setTieneNumerado(cupo.isTieneNumerado());
		
		List<List<AsientoVO>> asientosListVO = new ArrayList<List<AsientoVO>>();
		List<AsientoVO> filaAsientos = new ArrayList<AsientoVO>();
		String filaAnterior =asientos.size()>0?asientos.get(0).getFila():"";
		for(AsientosXSala asiento : asientos){						
			if(!asiento.getFila().equals(filaAnterior)){
                asientosListVO.add(filaAsientos);    	    		
                filaAsientos = new ArrayList<AsientoVO>();
                filaAnterior =asiento.getFila();
    		}
			AsientoVO asientoVO = new AsientoVO();
    		asientoVO.setActivo(asiento.isActivo());
    		asientoVO.setExistente(asiento.isExistente());
    		asientoVO.setFila(asiento.getFila());
    		asientoVO.setIdAisento(asiento.getIdAsientosXSala());
    		asientoVO.setIdSala(sala.getIdSala());
    		asientoVO.setNumeroAsiento(asiento.getNumeroAsiento());
    		filaAsientos.add(asientoVO);                	 		
		}
		if(asientos.size()>0){
			asientosListVO.add(filaAsientos);
		}
		
		salaVO.setAsientosListVO(asientosListVO);
		
		return salaVO;
	}

	public static Sala getSala(SalaCupoVO salaVO){
		
		if(salaVO==null)
			return null;
		
		Sala sala = new Sala();
		
		sala.setActivo(salaVO.isActivo());
		sala.setCine(new Cine(salaVO.getIdCine()));
		sala.setIdSala(salaVO.getIdSala());
		sala.setNombre(salaVO.getNombre());

		return sala;
	}
	
	public static Sala getSala(SalaCupoVO salaVO, Sala sala){
		
		if(salaVO==null || sala==null)
			return null;
				
		sala.setActivo(salaVO.isActivo());
		sala.setCine(new Cine(salaVO.getIdCine()));
		sala.setIdSala(salaVO.getIdSala());
		sala.setNombre(salaVO.getNombre());

		return sala;
	}
	
	public static SalaVO getSalaVO(Sala sala){
		
		if(sala==null)
			return null;
		
		SalaVO salaVO = new SalaVO();
		salaVO.setIdSala(sala.getIdSala());
		salaVO.setCineVO(CineAssembler.getCineVO(sala.getCine()));
		salaVO.setNombre(sala.getNombre());
		salaVO.setActivo(sala.isActivo());
		
		return salaVO;
	}
	
	public static List<SalaVO> getSalasVO(List<Sala> salas){
		
		if(salas==null || salas.isEmpty())
			return null;
		
		List<SalaVO> salasVO= new ArrayList<SalaVO>();
		
		for (Sala sala : salas) {
			salasVO.add(SalaAssembler.getSalaVO(sala));
		}
		
		return salasVO;
	}
	
	public static Sala getSala(Integer idSala){
		
		if(idSala==null)
			return null;
		
		Sala sala = new Sala();
		sala.setIdSala(idSala);

		return sala;
	}
	
	public static SalaProgramacionVO getSalaProgramacionVO(Sala sala){
		
		if(sala==null)
			return null;
		
		SalaProgramacionVO salaProgramacionVO = new SalaProgramacionVO();
		salaProgramacionVO.setIdSala(sala.getIdSala());
		salaProgramacionVO.setCineVO(CineAssembler.getCineVO(sala.getCine()));
		salaProgramacionVO.setNombre(sala.getNombre());
		salaProgramacionVO.setActivo(sala.isActivo());
		

		return salaProgramacionVO;
	}
	
	
}
