package mx.com.aztlan.pos.negocio.taquilla.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AsistenciaXSalaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.BoletosXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CupoXSalaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ExistenciaBoletoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProgramacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AsistenciaXSalaId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.CupoXSala;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusAsiento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ExistenciaBoletos;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Programacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusAsientoEnum;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.HttpResponseAsientosVO;
import mx.com.aztlan.pos.negocio.taquilla.assembler.AsistenciaXSalaAssembler;
import mx.com.aztlan.pos.negocio.taquilla.assembler.ExistenciaBoletoAssembler;
import mx.com.aztlan.pos.negocio.taquilla.vo.ExistenciaBoletoVO;

@Service
@Transactional
public class ExistenciaBoletoBO {
	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;

	@Autowired
	private CupoXSalaDAOI cupoXSalaDAO;

	@Autowired
	private BoletosXTicketDAOI boletosXTicketDAO;

	@Autowired
	private ProgramacionDAOI programacionDAO;
	
	@Autowired
	private AsistenciaXSalaDAOI asistenciaXSalaDAO;
		
	
	public ExistenciaBoletoVO findByProgramacionSalaAndExhibicion(Integer idProgramacion, Integer idSala, Date fechaExhibicion)
			throws BusinessGlobalException {

		CupoXSala cupoXSala = cupoXSalaDAO.findByIdSala(idSala);

		if (cupoXSala == null) {
			throw new BusinessGlobalException("Error al consultar existencia boletos.");
		}

		long vendidos = boletosXTicketDAO.sumByProgramacion(idProgramacion, fechaExhibicion);
		ExistenciaBoletos existenciaBoleto = existenciaBoletoDAO.findByIdProgramacion(idProgramacion, fechaExhibicion);

		if (existenciaBoleto == null) {
			long disponibles = cupoXSala.getNoAsientos() - vendidos;
			Programacion programacion = programacionDAO.getById(idProgramacion);
			return ExistenciaBoletoAssembler.getExistenciaBoletoVO(programacion, fechaExhibicion, disponibles, cupoXSala.getNoAsientos() );
		}

		long ocupados = vendidos + existenciaBoleto.getBoletosReservados();

		if (cupoXSala.getNoAsientos() < ocupados) {
			throw new BusinessGlobalException("Boletos no disponibles.");
		}

		return ExistenciaBoletoAssembler.getExistenciaBoletoVO(existenciaBoleto, cupoXSala.getNoAsientos() - ocupados, cupoXSala.getNoAsientos());

	}
	
	@Transactional(readOnly = false)
	public HttpResponseAsientosVO reservaAsiento(AsientoVO asientoVO, Date fechaExhibicion,Integer idUsuario){
		
		AsistenciaXSala asistencia = this.asistenciaXSalaDAO.getById(new AsistenciaXSalaId(asientoVO.getIdAsiento(),asientoVO.getIdProgramacion(),fechaExhibicion));
		
		//si ya existe solo actualizamos, si no existe guardamos uno nuevo
		if(asistencia!=null){
			//validamos el estatus del asiento, si se quiere reservar se valida que no esté YA reservado por alguien (evitar asignar doblemente)
			if(EstatusAsientoEnum.COMPRADO==asistencia.getEstatusAsiento().getIdEstatusAsiento().intValue()){
				return new HttpResponseAsientosVO(1,"El asiento "+asientoVO.getFila()+asientoVO.getNumeroAsiento()+" ya está vendido.");
			}else{
				if(EstatusAsientoEnum.RESERVADO==asistencia.getEstatusAsiento().getIdEstatusAsiento().intValue()
				   && EstatusAsientoEnum.DISPONIBLE==asientoVO.getIdEstatusAsiento().intValue()){
					return new HttpResponseAsientosVO(1,"El asiento "+asientoVO.getFila()+asientoVO.getNumeroAsiento()+" ya está reservado.");					
				}
				asistencia.setEstatusAsiento(new EstatusAsiento(EstatusAsientoEnum.DISPONIBLE==asientoVO.getIdEstatusAsiento()?EstatusAsientoEnum.RESERVADO:EstatusAsientoEnum.DISPONIBLE));
				asistencia.setFechaReserva(FechasUtilsBO.getCurrentDate());
				this.asistenciaXSalaDAO.update(asistencia);	
			}
		}else{
			asientoVO.setIdEstatusAsiento(EstatusAsientoEnum.RESERVADO);
			this.asistenciaXSalaDAO.save(AsistenciaXSalaAssembler.getAsistenciaXSala(asientoVO, fechaExhibicion,idUsuario));
		}
		
		return new HttpResponseAsientosVO();
	}

	public void update(ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException {

		CupoXSala cupoXSala = cupoXSalaDAO.findByIdSala(existenciaBoletoVO.getProgramacionVO().getSalaVO().getIdSala());
		long vendidos = boletosXTicketDAO.sumByProgramacion(existenciaBoletoVO.getProgramacionVO().getIdProgramacion(),
				existenciaBoletoVO.getFechaExhibicion());
		
		
		ExistenciaBoletos existenciaBoleto = existenciaBoletoDAO.findByIdProgramacion(
				existenciaBoletoVO.getProgramacionVO().getIdProgramacion(), existenciaBoletoVO.getFechaExhibicion());

		if (existenciaBoleto == null) {
			existenciaBoleto= ExistenciaBoletoAssembler.getExistenciaBoleto(existenciaBoletoVO);
			existenciaBoleto.setBoletosReservados(existenciaBoleto.getBoletosReservados() + existenciaBoletoVO.getReservar());
			existenciaBoletoDAO.save(existenciaBoleto);
			
		}else{
			
			long ocupados = vendidos + existenciaBoleto.getBoletosReservados();

			if (cupoXSala.getNoAsientos() < ocupados) {
				throw new BusinessGlobalException("Boletos no disponibles.");
			}
			
			existenciaBoleto.setBoletosReservados(existenciaBoleto.getBoletosReservados() + existenciaBoletoVO.getReservar());
			existenciaBoletoDAO.update(existenciaBoleto);

		}
		
	}

}
