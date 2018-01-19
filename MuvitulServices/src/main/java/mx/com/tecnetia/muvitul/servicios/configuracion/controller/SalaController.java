package mx.com.tecnetia.muvitul.servicios.configuracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.business.SalaBO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaCupoVO;

@Service
public class SalaController {
	@Autowired
	private SalaBO salaBO;
	
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