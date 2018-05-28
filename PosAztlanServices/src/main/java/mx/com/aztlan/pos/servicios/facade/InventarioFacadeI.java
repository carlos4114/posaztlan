package mx.com.aztlan.pos.servicios.facade;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ConteoVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosBusquedaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProductosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.SalidaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/inventario")
public interface InventarioFacadeI {
	
	@RequestMapping(value = "/productosConteo", method = RequestMethod.POST)
	ResponseEntity<List<ProductoExistenciaVO>> getProductosConteo(@RequestBody ParametrosBusquedaVO parametroBusquedaVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/buscarProducto", method = RequestMethod.POST)
	ResponseEntity<List<ProductoVO>> getProductosByNombre(@RequestBody ParametrosBusquedaVO parametroBusquedaVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/buscarProductoXsku", method = RequestMethod.POST)
	ResponseEntity<List<ProductoVO>> getProductosBySku(@RequestBody ParametrosBusquedaVO parametroBusquedaVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/producto/existencia", method = RequestMethod.GET)
	ResponseEntity<List<InventarioVO>> getExistenciaProductoPorProveedor(HttpServletRequest request,@RequestParam(value = "idArticulo") Integer idArticulo)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/producto/salida", method = RequestMethod.POST)
	ResponseEntity<Integer> createSalidas(HttpServletRequest request,@RequestBody SalidaVO salidaVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/traspaso", method = RequestMethod.POST)
	ResponseEntity<Integer> createTraspaso(HttpServletRequest request,@RequestBody SalidaVO salidaVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/producto/entrada", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/productosCorte", method = RequestMethod.POST)
	ResponseEntity<Integer> createProductosCorte(HttpServletRequest request,@RequestBody ProductosCorteVO productosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productosCorte", method = RequestMethod.PUT)
	ResponseEntity<Integer> updateProductosCorte(HttpServletRequest request,@RequestBody ProductosCorteVO productosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productosCorteMovimiento", method = RequestMethod.PUT)
	ResponseEntity<Integer> updateProductosCorteMovimiento(HttpServletRequest request,@RequestBody ProductosCorteVO productosCorteVO)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productosCorte", method = RequestMethod.DELETE)
	ResponseEntity<Integer> removeProductosCorte(HttpServletRequest request,@RequestParam(value = "idProductoCorte") Integer idProductoCorte)			
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/productosCorte", method = RequestMethod.GET)
	ResponseEntity<List<ProductosCorteVO>> getProductosCorte(HttpServletRequest request,@RequestParam(value = "fecha") String fecha)			
			throws BusinessGlobalException, NotFoundException,ParseException;
	
	@RequestMapping(value = "/productosSinConteo", method = RequestMethod.GET)
	 ResponseEntity<List<InventarioVO> > getProductosInventarioSinConteo(HttpServletRequest request, @RequestParam(value = "nombreProducto") String nombreArticulo) 
			 throws BusinessGlobalException, NotFoundException; 
	
	@RequestMapping(value = "/productosFinConteo", method = RequestMethod.PUT)
	 ResponseEntity<Integer> updateProductosCorteFinConteo(HttpServletRequest request,@RequestParam(value = "estatusConteo") Integer estatusConteo ) 
			 throws BusinessGlobalException, NotFoundException; 
	
	@RequestMapping(value = "/entradaOrdenCompra", method = RequestMethod.POST)
	public ResponseEntity<Integer> createEntradaOrdenCompra(HttpServletRequest request,@RequestBody OrdenCompraVO ordenCompraVO) throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/consultaTipoMovimientoInv/{isEntrada}", method = RequestMethod.GET)
	ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInv(HttpServletRequest request, @PathVariable("isEntrada") Boolean isEntrada)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/obtenerConteo", method = RequestMethod.POST)
	ResponseEntity<ConteoVO> obtenerConteo(@RequestBody ParametrosBusquedaVO parametrosBusquedaVO)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/guardarConteo", method = RequestMethod.POST)
	ResponseEntity<Integer> guardarConteo(HttpServletRequest request,@RequestBody ConteoVO conteoVO)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/autorizarConteo", method = RequestMethod.POST)
	ResponseEntity<Integer> autorizarConteo(HttpServletRequest request,@RequestBody ConteoVO conteoVO)
			throws BusinessGlobalException, NotFoundException;
}
