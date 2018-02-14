package mx.com.aztlan.pos.negocio.taquilla.assembler;

import java.util.Date;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ExistenciaBoletos;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;
import mx.com.aztlan.pos.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.aztlan.pos.servicios.util.ColorType;
import mx.com.aztlan.pos.servicios.util.Constantes;

public class ExistenciaBoletoAssembler {

	public static ExistenciaBoletoVO getExistenciaBoletoVO(ExistenciaBoletos existenciaBoleto, long disponibles, int cupo) {

		if (existenciaBoleto == null)
			return null;

		ExistenciaBoletoVO existenciaBoletoVO = new ExistenciaBoletoVO();
		existenciaBoletoVO.setIdExistenciaBoletos(existenciaBoleto.getIdExistenciaBoletos());
		existenciaBoletoVO.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(existenciaBoleto.getProgramacion()));
		existenciaBoletoVO.setFechaExhibicion(existenciaBoleto.getFechaExhibicion());
		existenciaBoletoVO.setFechaReserva(existenciaBoleto.getFechaReserva());
		existenciaBoletoVO.setBoletosReservados(existenciaBoleto.getBoletosReservados());
		existenciaBoletoVO.setDisponibles(disponibles);
		existenciaBoletoVO.setColor(getColor((int) disponibles, cupo));
		return existenciaBoletoVO;
	}

	public static ExistenciaBoletoVO getExistenciaBoletoVO(Programacion programacion, Date fechaExhibicion,
			long disponibles, int cupo) {

		if (programacion == null && fechaExhibicion == null)
			return null;

		ExistenciaBoletoVO existenciaBoleto = new ExistenciaBoletoVO();
		existenciaBoleto.setProgramacionVO(ProgramacionAssembler.getProgramacionVO(programacion));
		existenciaBoleto.setFechaExhibicion(fechaExhibicion);
		existenciaBoleto.setBoletosReservados(0);
		existenciaBoleto.setFechaReserva(new Date());
		existenciaBoleto.setDisponibles(disponibles);
		existenciaBoleto.setColor(getColor((int) disponibles, cupo));
		return existenciaBoleto;
	}

	public static ExistenciaBoletos getExistenciaBoleto(ExistenciaBoletoVO existenciaBoletoVO) {
		
		if (existenciaBoletoVO == null)
			return null;

		ExistenciaBoletos existenciaBoleto = new ExistenciaBoletos();
		existenciaBoleto.setIdExistenciaBoletos(existenciaBoletoVO.getIdExistenciaBoletos());
		existenciaBoleto.setProgramacion(ProgramacionAssembler.getProgramacion(existenciaBoletoVO.getProgramacionVO().getIdProgramacion()));
		existenciaBoleto.setFechaExhibicion(existenciaBoletoVO.getFechaExhibicion());
		existenciaBoleto.setBoletosReservados(existenciaBoletoVO.getBoletosReservados());
		existenciaBoleto.setFechaReserva(existenciaBoletoVO.getFechaReserva());
		
		return existenciaBoleto;
	}

	private static String getColor(int disponibles, int cupo) {
		String color;
		int porcentaje= disponibles*100/cupo;
		if (porcentaje <=Constantes.UPPER_LIMIT_RED){
			color=ColorType.RED.getColor();
		}else if(porcentaje <= Constantes.UPPER_LIMIT_YELLOW){
			color=ColorType.YELLOW.getColor();
		}else{
			color=ColorType.BLUE.getColor();
		}
		return color;
	}

}
