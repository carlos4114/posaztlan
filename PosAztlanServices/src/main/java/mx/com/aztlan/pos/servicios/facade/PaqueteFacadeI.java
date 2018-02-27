package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/paquetes")
public interface PaqueteFacadeI {

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public HttpResponseVO guardar(@RequestBody PaqueteVO paqueteVO) throws BusinessGlobalException, Exception;
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public HttpResponseVO actualizar(@RequestBody PaqueteVO paqueteVO) throws BusinessGlobalException, Exception;
	
	
	@RequestMapping(value = "/obtener/{idCine}", method = RequestMethod.GET)
	public ResponseEntity<List<PaqueteVO>> obtener(@PathVariable("idCine") Integer idCine) 
			throws BusinessGlobalException, NotFoundException;
	
}
