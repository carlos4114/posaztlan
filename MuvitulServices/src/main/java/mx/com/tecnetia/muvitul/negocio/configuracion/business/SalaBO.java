package mx.com.tecnetia.muvitul.negocio.configuracion.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.AsientosXSalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CupoXSalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.SalaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AsientosXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.CupoXSala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Sala;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.AsientosXSalaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.CupoXSalaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.assembler.SalaAssembler;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.AsientoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.SalaCupoVO;

@Service
@Transactional
public class SalaBO {

	@Autowired
	private SalaDAOI salaDAO;
	@Autowired
	private CupoXSalaDAOI cupoXsalaDAO;
	@Autowired
	private AsientosXSalaDAOI asientosXSalaDAO;
	
	/**
     * Servicio para actualizar una sala con su cupo y mapa de sala
     */
	@Transactional(readOnly=false)
	public HttpResponseVO actualizarSala(SalaCupoVO salaVO) throws BusinessGlobalException {
		if(salaVO == null)
			throw new BusinessGlobalException("No se pudo actualizar la Sala. SalaVO no puede ser nulo.");
	
		////se guarda la sala primero
		//se valida el nombre de la sala, en caso de existir
		salaVO.setNombre(salaVO.getNombre()==null?null:salaVO.getNombre().trim());
		if(this.salaDAO.findNombreRepetido(salaVO.getIdCine(),salaVO.getIdSala(),salaVO.getNombre())){
			return new HttpResponseVO(1,"El nombre de esta sala ya existe o ha existido");
		}	
		//validamos si coincide el tama�o del mapa contra el nuemero de asientos
		int contAsientos = 0;
		for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
			for(AsientoVO asientoVO : filaAsientos){
				if(asientoVO.isExistente())
					contAsientos++;
			}
		}
		if(contAsientos!=(salaVO.getCupo()==null?0:salaVO.getCupo().intValue())){
			return new HttpResponseVO(2,"El n�mero de butacas no coincide con el mapa");
		}		
		
		Sala sala = this.salaDAO.findById(salaVO.getIdSala());
		CupoXSala cupo = this.cupoXsalaDAO.findById(salaVO.getIdCupoSala());
		
		// si se dio de baja la sala
		if(sala.isActivo() && !salaVO.isActivo()){
			//se da de baja la sala el cupo y los asientos
			cupo.setActivo(false);
			cupo.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
			this.cupoXsalaDAO.update(cupo);
			this.asientosXSalaDAO.actualizarEstatus(salaVO.getIdSala(),false);
		}
		//actualizamos la sala
		sala = SalaAssembler.getSala(salaVO, sala);
		this.salaDAO.update(sala);	
		
		//se guarda ahora el cupo de la sala. Se calida si hubo un cambio en el cupo
		boolean cupoConNumerado = cupo.isTieneNumerado();
		if((salaVO.getCupo()==null?0:salaVO.getCupo().intValue())!=cupo.getNoAsientos()){
			// se da de baja el cupo y se da de alta un nuevo cupo, para guardar historico
			cupo.setActivo(false);
			cupo.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
			this.cupoXsalaDAO.update(cupo);
			salaVO.setIdCupoSala(null);
			this.cupoXsalaDAO.save(CupoXSalaAssembler.getCupoSala(salaVO, sala));
		}else{
			if(salaVO.isTieneNumerado()!=cupo.isTieneNumerado()){ //si solo se agrego el numerado o se quito, unicamente se actualiza el cupo
				cupo.setTieneNumerado(salaVO.isTieneNumerado());
				cupo.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
				this.cupoXsalaDAO.update(cupo);
			}
		}
		
		//ahora se actualizan los asientos por sala (en caso de existir)
		if(!salaVO.isTieneNumerado() && cupoConNumerado){ // si cambian de cupo numerado a no numerado se dan de baja los asientos
			this.asientosXSalaDAO.actualizarEstatus(salaVO.getIdSala(),false);
		}else{
			if(salaVO.isTieneNumerado() && !cupoConNumerado){ // si activan numerado cuando no habia, se dan de baja actuales (si hay) y se crean nuevos
				this.asientosXSalaDAO.actualizarEstatus(salaVO.getIdSala(),false);
				for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
					for(AsientoVO asientoVO : filaAsientos){
						asientoVO.setActivo(true);
						asientoVO.setIdAisento(null);
						this.asientosXSalaDAO.save(AsientosXSalaAssembler.getAsientosXSala(asientoVO, sala));
					}
				}
			}else{
				if(salaVO.isTieneNumerado()){
					//validamos si cambio el numero de asientos por fila o el numero de filas
					Integer maxNoAsientosActual = this.asientosXSalaDAO.getMaxNoAsientos(salaVO.getIdSala());
					String maxFila = this.asientosXSalaDAO.getMaxFila(salaVO.getIdSala());
					Integer maxFilaActual = maxFila==null?null:(maxFila.length()<=0?null:((int)maxFila.charAt(0))-64);					
					if(!salaVO.getMaxAsientos().equals(maxNoAsientosActual) || !salaVO.getFilas().equals(maxFilaActual)){
						//se dan de baja los asientos actuales y se dan de alta los nuevos, para guardar historico
						this.asientosXSalaDAO.actualizarEstatus(salaVO.getIdSala(),false);
						for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
							for(AsientoVO asientoVO : filaAsientos){	
								asientoVO.setActivo(true);
								asientoVO.setIdAisento(null);
								this.asientosXSalaDAO.save(AsientosXSalaAssembler.getAsientosXSala(asientoVO, sala));
							}
						}						
					}else{
						// solo validar si hubo cambios en los asientos como existente o inexistente y se actualiza el registro
						for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
							for(AsientoVO asientoVO : filaAsientos){	
								AsientosXSala asiento = this.asientosXSalaDAO.findById(asientoVO.getIdAsiento());
								if(asientoVO.isExistente()!=asiento.isExistente()){
									asiento.setExistente(asientoVO.isExistente());
									asiento.setUltimaActualizacion(FechasUtilsBO.getCurrentDate());
									this.asientosXSalaDAO.update(asiento);
								}
							}
						}
					}
				}
			}
		}
		
		return new HttpResponseVO();
	}
	
	
	/**
     * Servicio para obtener salas de un cine
     */
	@Transactional(readOnly = true)
	public List<SalaCupoVO> obtenerSalas(Integer idCine) throws BusinessGlobalException{
		List<Sala> salas = this.salaDAO.findByIdCine(idCine);
		List<SalaCupoVO> salasVO = new ArrayList<SalaCupoVO>();
		
		for(Sala sala:salas){
			CupoXSala cupoXSala = this.cupoXsalaDAO.findByIdSala(sala.getIdSala());
			List<AsientosXSala> asientos = this.asientosXSalaDAO.getActivos(sala.getIdSala());
			SalaCupoVO salasListVO = SalaAssembler.getSalaCupoVO(sala, cupoXSala, asientos);
			salasVO.add(salasListVO);
		}
		
		return salasVO;
		
	}
	
	/**
     * Servicio para guardar una sala con su cupo y mapa de sala
     */
	@Transactional(readOnly=false)
	public HttpResponseVO guardarSalaNueva(SalaCupoVO salaVO) throws BusinessGlobalException {
		if(salaVO == null)
			throw new BusinessGlobalException("No se pudo guardar la Sala. SalaVO no puede ser nulo.");
	
		//validamos si coincide el tama�o del mapa contra el nuemero de asientos
		if(salaVO.isTieneNumerado()){
			int contAsientos = 0;
			for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
				for(AsientoVO asientoVO : filaAsientos){	
					if(asientoVO.isExistente())
						contAsientos++;
				}
			}
			if(contAsientos!=(salaVO.getCupo()==null?0:salaVO.getCupo().intValue())){
				return new HttpResponseVO(2,"El n�mero de butacas no coincide con el mapa");
			}	
		}
		
		//se guarda la sala primero
		salaVO.setIdSala(null);
		salaVO.setActivo(true);
		Sala sala = SalaAssembler.getSala(salaVO);
		sala = this.salaDAO.save(sala);
		
		//se guarda ahora el cupo de la sala
		salaVO.setCupoActivo(true);
		salaVO.setIdCupoSala(null);
		this.cupoXsalaDAO.save(CupoXSalaAssembler.getCupoSala(salaVO, sala));
		
		//se guarda el numerado de la sala, en caso de existir
		if(salaVO.isTieneNumerado()){
			for(List<AsientoVO> filaAsientos : salaVO.getAsientosListVO()){
				for(AsientoVO asientoVO : filaAsientos){	
					asientoVO.setActivo(true);
					asientoVO.setIdAisento(null);
					this.asientosXSalaDAO.save(AsientosXSalaAssembler.getAsientosXSala(asientoVO, sala));
				}
			}
		}
		
		return new HttpResponseVO();
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

		
		List<List<AsientoVO>> asientosListVO = new ArrayList<List<AsientoVO>>();		

		for(int i=65;i<(65+filas);i++){
			List<AsientoVO> filaAsientos = new ArrayList<AsientoVO>();
			for(int j=1;j<=maxAsientos;j++){
				AsientoVO asientoVO = new AsientoVO();
				asientoVO.setExistente(true);
				asientoVO.setFila(Character.toString((char) i));
				asientoVO.setNumeroAsiento(j);
				filaAsientos.add(asientoVO);
			}
			asientosListVO.add(filaAsientos);
		}
			
		return asientosListVO;
	}

}