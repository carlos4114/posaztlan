package mx.com.aztlan.pos.servicios.facade;

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

import io.jsonwebtoken.Claims;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.ClaimsEnum;
import mx.com.aztlan.pos.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.configuracion.vo.AlmacenVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ArticuloVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CanalVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.CatalogoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.ClasificacionArtVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.FormaPagoVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.TipoDevolucionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.UnidadMedidaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;
import mx.com.aztlan.pos.servicios.configuracion.controller.CatalogoController;


@Service
public class CatalogoFacade implements CatalogoFacadeI {

	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	CatalogoController catalogoController;
	
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<List<CatalogoVO>> getCajas(@PathVariable("idAlmacen") Integer idAlmacen) throws BusinessGlobalException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getCajas(idAlmacen), HttpStatus.OK);		
	}
	
	@Override
	@Transactional (readOnly = true)
	public ResponseEntity<List<CatalogoVO>> getCargoAjuste() throws BusinessGlobalException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getCargoAjuste(), HttpStatus.OK);		
	}
	
	/*@Override
	public ResponseEntity<List<CineVO>> getCinesEmpresa(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CineVO>>(this.catalogoController.getCines(idEmpresa), HttpStatus.OK);		
	}*/
	
	@Override
	public ResponseEntity<List<AlmacenVO>> getAlmacenes(@PathVariable("idCanal") Integer idCanal) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<AlmacenVO>>(this.catalogoController.getAlmacenes(idCanal), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<FormaPagoVO>> getFormasPago(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetFormasPago:::IdUsuario[{}]:::IdCanal[{}]:::IdAlmacen[{}]", idUsuario, idCanal, idAlmacen);

		List<FormaPagoVO> formasPago = catalogoController.getFormasPagos();

		if (formasPago == null || formasPago.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<FormaPagoVO>>(formasPago, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ArticuloVO>> getArticulos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetArticulos:::IdUsuario[{}]:::IdCanal[{}]:::IdAlmacen[{}]", idUsuario, idCanal, idAlmacen);

		List<ArticuloVO> articulos = catalogoController.getArticulos( idCanal, idAlmacen);
		
		if (articulos == null || articulos.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ArticuloVO>>(articulos, HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<List<AlmacenVO>> getAlmacenes(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);

		List<AlmacenVO> almacenes = catalogoController.getAlmacenes(idCanal);

		if (almacenes == null || almacenes.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<AlmacenVO>>(almacenes, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<ProveedorVO>> getProveedor(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetProveedor:::IdUsuario[{}]:::IdCanal[{}]:::IdAlmacen[{}]", idUsuario, idCanal, idAlmacen);

		List<ProveedorVO> proveedor = catalogoController.getProveedor(idCanal);

		if (proveedor == null || proveedor.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<ProveedorVO>>(proveedor, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<MotivoDevolucionVO>> getMotivosDevolucion(HttpServletRequest request, Integer idPuntoVenta)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCanal = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idAlmacen = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetMotivosDevolucion:::IdUsuario[{}]:::IdCanal[{}]:::IdAlmacen[{}]", idUsuario, idCanal);

		List<MotivoDevolucionVO> motivosDevolucion = catalogoController.getMotivosDevolucion(idAlmacen);

		if (motivosDevolucion == null || motivosDevolucion.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<MotivoDevolucionVO>>(motivosDevolucion, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<List<TipoDevolucionVO>> getTiposDevolucion(HttpServletRequest request, Integer idTipoPuntoVenta)
			throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetTiposDevolucion:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<TipoDevolucionVO> tiposDevolucion = catalogoController.getTiposDevolucion(idTipoPuntoVenta);

		if (tiposDevolucion == null || tiposDevolucion.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<TipoDevolucionVO>>(tiposDevolucion, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<EstadoProductoVO>> getEstadosProducto(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetEstadosProducto:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<EstadoProductoVO> estadosProducto = catalogoController.getEstadosProducto();

		if (estadosProducto == null || estadosProducto.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<EstadoProductoVO>>(estadosProducto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<MotivoCancelacionVO>> getMotivosCancelacion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CANAL);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.ALMACEN);

		logger.info("GetMotivosCancelacion:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<MotivoCancelacionVO> motivosCancelacion = catalogoController.getMotivosCancelacion();

		if (motivosCancelacion == null || motivosCancelacion.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<MotivoCancelacionVO>>(motivosCancelacion, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CanalVO>> getCanalesEmpresa(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CanalVO>>(this.catalogoController.getCanales(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<ClasificacionArtVO>> getClasificacionesArt(@PathVariable("idCine") Integer idCine) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<ClasificacionArtVO>>(this.catalogoController.getClasificacionesArt(idCine), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<CatalogoVO>> getUnidadesMedida(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getUnidadesMedida(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<CatalogoVO>> getFamilias(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getFamilias(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<CatalogoVO>> getMarcas(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getMarcas(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<CatalogoVO>> getMedidas(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getMedidas(idEmpresa), HttpStatus.OK);		
	}
	
	@Override
	public ResponseEntity<List<CatalogoVO>> getTipos(@PathVariable("idEmpresa") Integer idEmpresa) throws BusinessGlobalException, NotFoundException {
		return new ResponseEntity<List<CatalogoVO>>(this.catalogoController.getTipos(idEmpresa), HttpStatus.OK);		
	}
}
