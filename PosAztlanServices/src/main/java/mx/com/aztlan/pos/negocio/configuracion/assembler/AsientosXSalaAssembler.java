package mx.com.aztlan.pos.negocio.configuracion.assembler;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsientosXSala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Sala;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;

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
		asiento.setPosicion(asientoVO.getPosicion());
		asiento.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
		
		return asiento;
	}
		
}
