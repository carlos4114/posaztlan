package mx.com.aztlan.pos.servicios.facade;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.dulceria.vo.MovimientoInventarioVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/inventario")
public interface InventarioFacadeI {
	
	@RequestMapping(value = "/puntoVenta/articulo", method = RequestMethod.GET)
	ResponseEntity<List<ArticulosXPuntoVentaVO>> getarticulosXPuntoVentaByNombre(HttpServletRequest request,@RequestParam(value = "nombre") String nombre)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulo/existencia", method = RequestMethod.GET)
	ResponseEntity<List<InventarioVO>> getExistenciaArticuloPorProveedor(HttpServletRequest request,@RequestParam(value = "idArticulo") Integer idArticulo)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulo/salida", method = RequestMethod.POST)
	ResponseEntity<Integer> createSalida(HttpServletRequest request,@RequestBody ParametrosInventarioVO movimientoInventarioVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulo/entrada", method = RequestMethod.POST)
	ResponseEntity<Integer> createEntrada(HttpServletRequest request,@RequestBody ParametrosInventarioVO movimientoInventarioVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulo", method = RequestMethod.GET)
	 ResponseEntity<List<InventarioVO> > getArticulosInventario(HttpServletRequest request, @RequestParam(value = "nombreArticulo") String nombreArticulo) 
			 throws BusinessGlobalException, NotFoundException; 
	
	@RequestMapping(value = "/tipoMovimientoInv/entrada", method = RequestMethod.GET)
	ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInvByIsEntrada(HttpServletRequest request,@RequestParam(value = "isEntrada") Boolean isEntrada)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/tipoMovimientoInv/clave", method = RequestMethod.GET)
	ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInvByClave(HttpServletRequest request,@RequestParam(value = "clave") String clave)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulosCorte", method = RequestMethod.POST)
	ResponseEntity<Integer> createArticulosCorte(HttpServletRequest request,@RequestBody ArticulosCorteVO articulosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulosCorte", method = RequestMethod.PUT)
	ResponseEntity<Integer> updateArticulosCorte(HttpServletRequest request,@RequestBody ArticulosCorteVO articulosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulosCorteMovimiento", method = RequestMethod.PUT)
	ResponseEntity<Integer> updateArticulosCorteMovimiento(HttpServletRequest request,@RequestBody ArticulosCorteVO articulosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulosCorte", method = RequestMethod.DELETE)
	ResponseEntity<Integer> removeArticulosCorte(HttpServletRequest request,@RequestParam(value = "idArticuloCorte") Integer idArticuloCorte)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/articulosCorte", method = RequestMethod.GET)
	ResponseEntity<List<ArticulosCorteVO>> getArticulosCorte(HttpServletRequest request,@RequestParam(value = "fecha") String fecha)			
			throws BusinessGlobalException, NotFoundException,ParseException;
	
	@RequestMapping(value = "/articulosSinConteo", method = RequestMethod.GET)
	 ResponseEntity<List<InventarioVO> > getArticulosInventarioSinConteo(HttpServletRequest request, @RequestParam(value = "nombreArticulo") String nombreArticulo) 
			 throws BusinessGlobalException, NotFoundException; 
	
	@RequestMapping(value = "/articulosFinConteo", method = RequestMethod.PUT)
	 ResponseEntity<Integer> updateArticulosCorteFinConteo(HttpServletRequest request,@RequestParam(value = "estatusConteo") Integer estatusConteo ) 
			 throws BusinessGlobalException, NotFoundException; 
}
