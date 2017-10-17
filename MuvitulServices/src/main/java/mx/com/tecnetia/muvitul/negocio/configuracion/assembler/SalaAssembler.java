package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import java.util.ArrayList;
import java.util.List;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaVO;

public class SalaAssembler {

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
