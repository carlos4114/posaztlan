package mx.com.tecnetia.muvitul.negocio.taquilla.assembler;

import java.util.Date;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsistenciaXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsistenciaXSalaId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.EstatusAsiento;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Usuario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;

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
