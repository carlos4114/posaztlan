package mx.com.aztlan.pos.servicios.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.HttpResponseVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosCorteVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosBusquedaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.SalidaVO;
import mx.com.aztlan.pos.servicios.inventarios.controller.InventarioController;

@Service
public class InventarioFacade implements InventarioFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(InventarioFacade.class);

	@Autowired
	InventarioController inventarioController;

	@Override
	public ResponseEntity<List<ArticulosXPuntoVentaVO>> getarticulosXPuntoVentaByNombre(HttpServletRequest request,
			String nombre) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("GetArticulosInventario:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		List<ArticulosXPuntoVentaVO>  articulosPuntoVenta = inventarioController.getArticulosPuntoVenta(idPuntoVenta, nombre);
		
		if (articulosPuntoVenta == null || articulosPuntoVenta.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ArticulosXPuntoVentaVO> >(articulosPuntoVenta, HttpStatus.OK);
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
	public ResponseEntity<List<InventarioVO> > getArticulosInventario(HttpServletRequest request, String nombreArticulo) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("GetArticulosInventario:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		List<InventarioVO>  articulosInventario = inventarioController.getArticulosInventario(idPuntoVenta, nombreArticulo);

		if (articulosInventario == null || articulosInventario.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<InventarioVO> >(articulosInventario, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<InventarioVO>> getExistenciaArticuloPorProveedor(HttpServletRequest request,
			Integer idArticulo) throws BusinessGlobalException, NotFoundException {
		
			Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
			Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
			Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
			
			logger.info("GetArticulosInventario:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
			
			List<InventarioVO>  articulosInventario = inventarioController.getExistenciaArticuloPorProveedores(idPuntoVenta, idArticulo);
	
			if (articulosInventario == null || articulosInventario.isEmpty()) {
				throw new NotFoundException("No encontrado");
			}
	
			return new ResponseEntity<List<InventarioVO> >(articulosInventario, HttpStatus.OK);
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
	public ResponseEntity<List<InventarioVO> > getArticulosInventarioSinConteo(HttpServletRequest request, String nombreArticulo) throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta=(Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		
		logger.info("GetArticulosInventario:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		List<InventarioVO>  articulosInventario = inventarioController.getArticulosInventarioSinConteo(idPuntoVenta, nombreArticulo);

		if (articulosInventario == null || articulosInventario.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<InventarioVO> >(articulosInventario, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> createArticulosCorte(HttpServletRequest request,
			@RequestBody ArticulosCorteVO articulosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		logger.info("createArticulosCorte:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		response = inventarioController.createArticulosCorte(articulosCorteVO,idCine,idPuntoVenta,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Integer> updateArticulosCorte(HttpServletRequest request,
			@RequestBody ArticulosCorteVO articulosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		logger.info("updateArticulosCorte:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		response = inventarioController.updateArticulosCorte(articulosCorteVO,idCine,idPuntoVenta,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> updateArticulosCorteMovimiento(HttpServletRequest request,
			@RequestBody ArticulosCorteVO articulosCorteVO) throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		logger.info("updateArticulosCorteMovimiento:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		response = inventarioController.updateArticulosCorteMovimiento(articulosCorteVO,idCine,idPuntoVenta,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> removeArticulosCorte(HttpServletRequest request, Integer idArticuloCorte)
			throws BusinessGlobalException, NotFoundException {
		
		int response = 0;
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		logger.info("updateArticulosCorte:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		response = inventarioController.removeArticulosCorte(idArticuloCorte,idCine,idPuntoVenta,idUsuario);
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ArticulosCorteVO>> getArticulosCorte(HttpServletRequest request, String fecha)
			throws BusinessGlobalException, NotFoundException,ParseException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("getArticulosCorte:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFormatter = formatter.parse(fecha);
		
		List<ArticulosCorteVO> articulosCorteVO = inventarioController.getArticulosCorteEnConteo(idPuntoVenta);
		
		return new ResponseEntity<List<ArticulosCorteVO>>(articulosCorteVO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Integer> updateArticulosCorteFinConteo(HttpServletRequest request,Integer estatusConteo ) 
			 throws BusinessGlobalException, NotFoundException{
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		int response = 0;
		
		logger.info("updateArticulosCorteFinConteo:::IdCine[{}]:::IdPuntoVenta[{}]",idCine,idPuntoVenta);
		response = inventarioController.finalizarConteo(idCine,idPuntoVenta,idUsuario);
		
		return new ResponseEntity<Integer>(response, HttpStatus.OK);
	}
	
}
