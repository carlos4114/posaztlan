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
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.PuntosVentaListVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ordenesCompra")
public interface OrdenCompraFacadeI {
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<List<ProductoVO>> buscar(@RequestBody FiltrosVO filtrosVO) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public HttpResponseVO guardar(@RequestBody OrdenCompraVO ordenCompraVO) throws BusinessGlobalException, Exception;
}
