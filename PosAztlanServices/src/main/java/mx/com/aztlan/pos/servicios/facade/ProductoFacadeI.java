package mx.com.aztlan.pos.servicios.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/productos")
public interface ProductoFacadeI {
	
	@RequestMapping(value = "/obtenerExistencia", method = RequestMethod.POST)
	public List<ProductoExistenciaVO> getProductosExistencia(@RequestBody FiltrosVO filtrosVO) throws Exception;

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public HttpResponseVO guardar(@RequestBody ProductoVO productoVO) throws BusinessGlobalException, Exception;
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public HttpResponseVO actualizar(@RequestBody ProductoVO productoVO) throws BusinessGlobalException, Exception;
	
	
	@RequestMapping(value = "/obtener/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoVO>> obtener(@PathVariable("idEmpresa") Integer idEmpresa) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/consultaUnidadMedida/{idArticulo}", method = RequestMethod.GET)
	public ResponseEntity<UnidadMedidaVO> consultaUnidadMedida(@PathVariable("idArticulo") Integer idArticulo) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/consultaPrecioUnitario/{idArticulo}", method = RequestMethod.GET)
	public ResponseEntity<BigDecimal> consultaPrecioUnitario(@PathVariable("idArticulo") Integer idArticulo) 
			throws BusinessGlobalException, Exception;
	
}
