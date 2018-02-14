package mx.com.aztlan.pos.servicios.configuracion.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.business.SalaBO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.SalaCupoVO;

@Service
public class SalaController {
	@Autowired
	private SalaBO salaBO;
	
	/**
     * Servicio para borrar los asientos reservados de un usuario
     */
	@Transactional(readOnly=false)
	public void borrarAsientosReservadosUsuario(Integer idUsuario) throws BusinessGlobalException {
		if(idUsuario == null)
			throw new BusinessGlobalException("No se puede obtener el mapa con asistencia. El usuario no puede ser nulo.");
		
		this.salaBO.borrarAsientosReservadosUsuario(idUsuario);
	}
	
	/**
     * Servicio para obtener el mapa de una sala con su asistencia
     */
	@Transactional(readOnly=true)
	public List<List<AsientoVO>> obtenerMapaConAsistencia(Integer idProgramacion, Date fechaExhibicion,Integer idUsuario) throws BusinessGlobalException {
		if(idProgramacion == null)
			throw new BusinessGlobalException("No se puede obtener el mapa con asistencia. La programacion no puede ser nulo.");

		return this.salaBO.obtenerMapaConAsistencia(idProgramacion, fechaExhibicion,idUsuario);
	}
	
	/**
     * Servicio para crear un mapa nuevo de sala en base al numero de filas y asientos maximos por fila
     */
	@Transactional(readOnly=true)
	public List<List<AsientoVO>> crearMapaNuevo(Integer filas, Integer maxAsientos) throws BusinessGlobalException {
		if(filas == null)
			throw new BusinessGlobalException("No se pudo crear el mapa de asientos. Filas no puede ser nulo.");
		if(maxAsientos == null)
			throw new BusinessGlobalException("No se pudo crear el mapa de asientos. Max Asientos no puede ser nulo.");

		return this.salaBO.crearMapaNuevo(filas, maxAsientos);
	}
	
	/**
     * Servicio para actualizar el asiento en la configuracion de un mapa
     */
	public List<List<AsientoVO>> actualizarAsiento(List<List<AsientoVO>> asientosVOList, AsientoVO asientoVO) throws BusinessGlobalException {
		if(asientosVOList== null)
			throw new BusinessGlobalException("No se pudo actualizar el asiento. AsientoVOList no puede ser nulo.");
		if(asientoVO == null)
			throw new BusinessGlobalException("No se pudo actualizar el asiento. AsientoVO no puede ser nulo.");

		return this.salaBO.actualizarAsiento(asientosVOList, asientoVO);
	}
	
	/**
     * Servicio para guardar una sala con su cupo y mapa de sala
     */
	@Transactional(readOnly=false)
	public HttpResponseVO guardarSalaNueva(SalaCupoVO salaVO) throws BusinessGlobalException {
		if(salaVO == null)
			throw new BusinessGlobalException("No se pudo guardar la Sala. SalaVO no puede ser nulo.");
	
		return this.salaBO.guardarSalaNueva(salaVO);
	}
	
	/**
     * Servicio para actualizar una sala con su cupo y mapa de sala
     */
	@Transactional(readOnly=false)
	public HttpResponseVO actualizarSala(SalaCupoVO salaVO) throws BusinessGlobalException {
		if(salaVO == null)
			throw new BusinessGlobalException("No se pudo actualizar la Sala. SalaVO no puede ser nulo.");
	
		return this.salaBO.actualizarSala(salaVO);
	}
	
	
	/**
     * Servicio para obtener salas de un cine
     */
	@Transactional(readOnly = true)
	public List<SalaCupoVO> obtenerSalas(Integer idCine) throws BusinessGlobalException{		
		return this.salaBO.obtenerSalas(idCine);
	}

}
