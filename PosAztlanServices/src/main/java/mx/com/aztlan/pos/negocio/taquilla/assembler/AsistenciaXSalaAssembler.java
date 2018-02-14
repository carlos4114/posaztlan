package mx.com.aztlan.pos.negocio.taquilla.assembler;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSalaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusAsiento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;

public class AsistenciaXSalaAssembler {

	public static AsistenciaXSala getAsistenciaXSala(AsientoVO asientoVO, Date fechaExhibicion, Integer idUsuario){
		if(asientoVO==null)
			return null;
		
		AsistenciaXSala asistenciaXSala = new AsistenciaXSala();
		asistenciaXSala.setEstatusAsiento(new EstatusAsiento(asientoVO.getIdEstatusAsiento()));
		asistenciaXSala.setFechaReserva(FechasUtilsBO.getCurrentDate());
		asistenciaXSala.setId(new AsistenciaXSalaId(asientoVO.getIdAsiento(),asientoVO.getIdProgramacion(),fechaExhibicion));
		asistenciaXSala.setUsuario(new Usuario(idUsuario));
		return asistenciaXSala;
	}
	
}
