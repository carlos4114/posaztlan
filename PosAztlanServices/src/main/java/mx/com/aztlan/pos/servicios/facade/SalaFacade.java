package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.vo.ActualizaAsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.SalaCupoVO;
import mx.com.aztlan.pos.servicios.configuracion.controller.SalaController;

@Service
public class SalaFacade implements SalaFacadeI {

	@Autowired
	SalaController salaController;
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizarSala(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException{				
		return this.salaController.actualizarSala(salaVO);
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardarSalaNueva(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException{				
		return this.salaController.guardarSalaNueva(salaVO);
	}
	
	@Override
	public List<List<AsientoVO>> actualizaAsiento(@RequestBody ActualizaAsientoVO actualizaAsientoVO) throws BusinessGlobalException {
		return this.salaController.actualizarAsiento(actualizaAsientoVO.getAsientosVOList(), actualizaAsientoVO.getAsientoVO());
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<List<AsientoVO>> getMapaNuevo(@PathVariable("filas") Integer filas,@PathVariable("maxAsientos") Integer maxAsientos) throws BusinessGlobalException{
		return this.salaController.crearMapaNuevo(filas, maxAsientos);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<SalaCupoVO> getSalas(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException{
		return this.salaController.obtenerSalas(idCine);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<List<AsientoVO>> getMapaConAsistencia(HttpServletRequest request, Integer idProgramacion,String fechaExhibicion) throws BusinessGlobalException{		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		return this.salaController.obtenerMapaConAsistencia(idProgramacion, FechasUtilsBO.stringToDate(fechaExhibicion, "/"),idUsuario);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void borrarAsientosReservadosUsuario(HttpServletRequest request) throws BusinessGlobalException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		this.salaController.borrarAsientosReservadosUsuario(idUsuario);
	}
	
}
