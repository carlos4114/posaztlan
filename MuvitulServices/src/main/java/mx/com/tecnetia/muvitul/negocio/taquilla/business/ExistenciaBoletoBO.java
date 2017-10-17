package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.BoletosXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CupoXSalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ExistenciaBoletoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;

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
