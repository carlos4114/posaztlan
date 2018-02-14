package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.vo.ActualizaAsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.AsientoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.SalaCupoVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sala")
public interface SalaFacadeI {
	
	@RequestMapping(value = "/actualizaAsiento", method = RequestMethod.POST)
	List<List<AsientoVO>> actualizaAsiento(@RequestBody ActualizaAsientoVO actualizaAsientoVO) throws BusinessGlobalException;

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	HttpResponseVO actualizarSala(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException;
	
	@RequestMapping(value = "/guardarNueva", method = RequestMethod.POST)
	HttpResponseVO guardarSalaNueva(@RequestBody SalaCupoVO salaVO) throws BusinessGlobalException;

	@RequestMapping(value = "/obtenerMapaNuevo/{filas}/{maxAsientos}", method = RequestMethod.GET)
	List<List<AsientoVO>> getMapaNuevo(@PathVariable("filas") Integer filas,@PathVariable("maxAsientos") Integer maxAsientos) throws BusinessGlobalException;

	@RequestMapping(value = "/obtenerLista/{idCine}", method = RequestMethod.GET)
	List<SalaCupoVO> getSalas(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException;
	
	@RequestMapping(value = "/mapaConAsistencia", method = RequestMethod.GET)
	List<List<AsientoVO>> getMapaConAsistencia(HttpServletRequest request,Integer idProgramacion, String fechaExhibicion) throws BusinessGlobalException;

	@RequestMapping(value = "/borrarReservados", method = RequestMethod.GET)
	void borrarAsientosReservadosUsuario(HttpServletRequest request) throws BusinessGlobalException;
}
