package mx.com.aztlan.pos.servicios.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ConteoVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosBusquedaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProductosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.SalidaVO;
import mx.com.aztlan.pos.servicios.inventarios.controller.InventarioController;

@Service
public class InventarioFacade implements InventarioFacadeI {

	@Autowired
	InventarioController inventarioController;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoExistenciaVO>> getProductosConteo(@RequestBody ParametrosBusquedaVO parametroBusquedaVO) 
			throws BusinessGlobalException, NotFoundException {
		
		List<ProductoExistenciaVO> productosConteo = inventarioController.getProductosConteo(parametroBusquedaVO);
		
		if (productosConteo == null || productosConteo.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProductoExistenciaVO> >(productosConteo, HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoVO>> getProductosByNombre(@RequestBody ParametrosBusquedaVO parametrosBusquedaVO) 
			throws BusinessGlobalException, NotFoundException {
		
		List<ProductoVO> productos = inventarioController.getProductos(parametrosBusquedaVO.getNombre(), parametrosBusquedaVO.getIdEmpresa());
		
		if (productos == null || productos.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProductoVO> >(productos, HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<ProductoVO>> getProductosBySku(@RequestBody ParametrosBusquedaVO parametrosBusquedaVO) 
			throws BusinessGlobalException, NotFoundException {
		
		List<ProductoVO> productos = inventarioController.getProductosXsku(parametrosBusquedaVO.getSku(), parametrosBusquedaVO.getIdEmpresa());
		
		if (productos == null || productos.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProductoVO> >(productos, HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<List<InventarioVO> > getArticulosInventario(HttpServletRequest request, String nombreProducto) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idAlmacen=(Integer) claims.get(ClaimsEnum.ALMACEN);
		
		List<InventarioVO>  articulosInventario = inventarioController.getProductosInventario(idAlmacen, nombreProducto);

		if (articulosInventario == null || articulosInventario.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<InventarioVO> >(articulosInventario, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<InventarioVO>> getExistenciaProductoPorProveedor(HttpServletRequest request,
			Integer idProducto) throws BusinessGlobalException, NotFoundException {
		
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			Integer idAlmacen=(Integer) claims.get(ClaimsEnum.ALMACEN);
			
			List<InventarioVO>  productosInventario = inventarioController.getExistenciaProductoPorProveedores(idAlmacen, idProducto);
	
			if (productosInventario == null || productosInventario.isEmpty()) {
				throw new NotFoundException("No encontrado");
			}
	
			return new ResponseEntity<List<InventarioVO> >(productosInventario, HttpStatus.OK);
	}

	@Override	
	public ResponseEntity<Integer> createSalidas(HttpServletRequest request,@RequestBody SalidaVO salidaVO) throws BusinessGlobalException, NotFoundException {
			
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			//Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
			//Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
			Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
				
			int response = 0;			
			
			inventarioController.createSalidas(salidaVO,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}

	@Override	
	public ResponseEntity<Integer> createTraspaso(HttpServletRequest request,@RequestBody SalidaVO salidaVO) throws BusinessGlobalException, NotFoundException {
			
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);

			Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
				
			int response = 0;			
			
			inventarioController.createTraspaso(salidaVO,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}
	/*@Override
	public ResponseEntity<Integer> createEntrada(HttpServletRequest request,@RequestBody ParametrosInventarioVO movimientoInventarioVO)
			throws BusinessGlobalException, NotFoundException {
			
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
			Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
			Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
			logger.info("createEntrada:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
				
			int response = 0;			
			response = inventarioController.createEntrada(movimientoInventarioVO,idCine,idPuntoVenta,idUsuario);	
			return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}*/
	
	@Override
	public ResponseEntity<Integer> createEntrada(HttpServletRequest request,@RequestBody ParametrosInventarioVO movimientoInventarioVO)
			throws BusinessGlobalException, NotFoundException {
			
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
				
			int response = 0;			
			response = inventarioController.createEntrada(movimientoInventarioVO,idUsuario);	
			return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}
	
	
	@Override
	public ResponseEntity<Integer> createEntradaOrdenCompra(HttpServletRequest request,@RequestBody OrdenCompraVO ordenCompraVO) throws BusinessGlobalException, NotFoundException
	{
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
				
			int response = 0;			
			inventarioController.createEntradaOrdenCompra(ordenCompraVO,idUsuario);	
			return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInvByIsEntrada(HttpServletRequest request,
			Boolean isEntrada) throws BusinessGlobalException, NotFoundException {
			List<TipoMovimientoInvVO> 	tipoMovimientoInvVO = inventarioController.getTiposMovimientoByIsEntrada(isEntrada);
		
			return new ResponseEntity<List<TipoMovimientoInvVO> >(tipoMovimientoInvVO, HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInv(HttpServletRequest request,
			@PathVariable("isEntrada") Boolean isEntrada) throws BusinessGlobalException, NotFoundException {
			List<TipoMovimientoInvVO> 	tipoMovimientoInvVO = inventarioController.getTiposMovimientoByIsEntrada(isEntrada);
		
			return new ResponseEntity<List<TipoMovimientoInvVO> >(tipoMovimientoInvVO, HttpStatus.OK); 
	}
	
	@Override
	public ResponseEntity<List<TipoMovimientoInvVO>> getTipoMovimientoInvByClave(HttpServletRequest request,
			String clave) throws BusinessGlobalException, NotFoundException {
		List<TipoMovimientoInvVO> 	tipoMovimientoInvVO = inventarioController.getTiposMovimientoByClave(clave);
		
		return new ResponseEntity<List<TipoMovimientoInvVO> >(tipoMovimientoInvVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<InventarioVO> > getProductosInventarioSinConteo(HttpServletRequest request, String nombreProducto) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen=(Integer) claims.get(ClaimsEnum.ALMACEN);
		
		List<InventarioVO>  productosInventario = inventarioController.getProductosInventarioSinConteo(idAlmacen, nombreProducto);

		if (productosInventario == null || productosInventario.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<InventarioVO> >(productosInventario, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> createProductosCorte(HttpServletRequest request,
			@RequestBody ProductosCorteVO productosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal= (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		response = inventarioController.createProductosCorte(productosCorteVO,idCanal,idAlmacen,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Integer> updateProductosCorte(HttpServletRequest request,
			@RequestBody ProductosCorteVO productosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		response = inventarioController.updateProductosCorte(productosCorteVO,idCanal,idAlmacen,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> updateProductosCorteMovimiento(HttpServletRequest request,
			@RequestBody ProductosCorteVO productosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		response = inventarioController.updateProductosCorteMovimiento(productosCorteVO,idCanal,idAlmacen,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> removeProductosCorte(HttpServletRequest request, Integer idProductoCorte)
			throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		response = inventarioController.removeProductosCorte(idProductoCorte,idCanal,idAlmacen,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductosCorteVO>> getProductosCorte(HttpServletRequest request, String fecha)
			throws BusinessGlobalException, NotFoundException,ParseException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFormatter = formatter.parse(fecha);
		
		List<ProductosCorteVO> productosCorteVO = inventarioController.getProductosCorteEnConteo(idAlmacen);
		
		return new ResponseEntity<List<ProductosCorteVO>>(productosCorteVO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> updateProductosCorteFinConteo(HttpServletRequest request,Integer estatusConteo ) 
			 throws BusinessGlobalException, NotFoundException{
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen= (Integer) claims.get(ClaimsEnum.ALMACEN);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		int response = 0;
		
		response = inventarioController.finalizarConteo(idCanal,idAlmacen,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ConteoVO> obtenerConteo(@RequestBody ParametrosBusquedaVO parametrosBusquedaVO) throws BusinessGlobalException, NotFoundException
	{
		ConteoVO response = inventarioController.obtenerConteo(parametrosBusquedaVO);
		
		return new ResponseEntity<ConteoVO>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> guardarConteo(HttpServletRequest request, @RequestBody ConteoVO conteoVO) throws BusinessGlobalException, NotFoundException
	{
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		
		conteoVO.setIdUsuarioCreador(idUsuario);
		
		Integer response = inventarioController.guardarConteo(conteoVO);
		
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> autorizarConteo(HttpServletRequest request, @RequestBody ConteoVO conteoVO) throws BusinessGlobalException, NotFoundException
	{
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario=(Integer) claims.get(ClaimsEnum.USUARIO);
		
		conteoVO.setIdUsuarioAutorizador(idUsuario);
		
		Integer response = this.inventarioController.autorizarConteo(conteoVO);
		
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
}
