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
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.servicios.configuracion.controller.ArticuloController;



@Service
public class ArticuloFacade implements ArticuloFacadeI {

	@Autowired
	ArticuloController articuloController;
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO guardar(@RequestBody ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		 return this.articuloController.guardar(articuloVO);
	}
	
	@Override
	@Transactional(readOnly = false)
	public HttpResponseVO actualizar(@RequestBody ArticuloVO articuloVO) throws BusinessGlobalException, Exception{
		 return this.articuloController.actualizar(articuloVO);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ArticuloVO>> obtener(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<ArticuloVO>>(this.articuloController.obtener(idCine), HttpStatus.OK);		
	}
}
