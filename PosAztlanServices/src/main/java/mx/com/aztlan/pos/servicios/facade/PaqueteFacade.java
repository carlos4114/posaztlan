package mx.com.aztlan.pos.servicios.facade;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.configuracion.vo.PaqueteVO;
import mx.com.aztlan.pos.servicios.configuracion.controller.PaqueteController;

@Service
public class PaqueteFacade implements PaqueteFacadeI {

	@Autowired
	PaqueteController paqueteController;
		
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(@RequestBody PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		 return this.paqueteController.guardar(paqueteVO);
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(@RequestBody PaqueteVO paqueteVO) throws BusinessGlobalException, Exception{
		 return this.paqueteController.actualizar(paqueteVO);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PaqueteVO>> obtener(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<PaqueteVO>>(this.paqueteController.obtener(idCine), HttpStatus.OK);		
	}
	
}

