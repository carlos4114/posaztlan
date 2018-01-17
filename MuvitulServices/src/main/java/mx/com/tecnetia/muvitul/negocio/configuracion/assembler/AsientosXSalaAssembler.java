package mx.com.tecnetia.muvitul.negocio.configuracion.assembler;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsientosXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;

public class AsientosXSalaAssembler {

	public static AsientosXSala getAsientosXSala(AsientoVO asientoVO, Sala sala){
		
		if(asientoVO==null)
			return null;
		
		AsientosXSala asiento = new AsientosXSala();
		
		asiento.setActivo(asientoVO.isActivo());
		asiento.setExistente(asientoVO.isExistente());
		asiento.setFila(asientoVO.getFila());
		asiento.setIdAsientosXSala(asientoVO.getIdAsiento());
		asiento.setNumeroAsiento(asientoVO.getNumeroAsiento());
		asiento.setSala(sala);
		asiento.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
		
		return asiento;
	}
		
}
