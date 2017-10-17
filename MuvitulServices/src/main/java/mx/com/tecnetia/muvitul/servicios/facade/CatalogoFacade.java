package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller.UsuarioFirmadoBean;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CineVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ProveedorVO;
import mx.com.tecnetia.muvitul.servicios.configuracion.controller.CatalogoController;

@Service
public class CatalogoFacade implements CatalogoFacadeI {

	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);

	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	CatalogoController catalogoController;

	@Override
	public ResponseEntity<List<FormaPagoVO>> getFormasPago(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetFormasPago:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<FormaPagoVO> formasPago = catalogoController.getFormasPagos();

		if (formasPago == null || formasPago.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<FormaPagoVO>>(formasPago, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PuntoVentaVO>> getPuntosVenta(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetPPuntosVenta:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<PuntoVentaVO> puntosVenta = catalogoController.getPuntosVenta(idCine);

		if (puntosVenta == null || puntosVenta.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PuntoVentaVO>>(puntosVenta, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<ProveedorVO>> getProveedor(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetProveedor:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<ProveedorVO> proveedor = catalogoController.getProveedor(idCine);

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
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		//Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetMotivosDevolucion:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine);

		List<MotivoDevolucionVO> motivosDevolucion = catalogoController.getMotivosDevolucion(idPuntoVenta);

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
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

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
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

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
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetMotivosCancelacion:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		List<MotivoCancelacionVO> motivosCancelacion = catalogoController.getMotivosCancelacion();

		if (motivosCancelacion == null || motivosCancelacion.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<MotivoCancelacionVO>>(motivosCancelacion, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CineVO>> getCinesEmpresa(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);

		logger.info("GetCinesEmpresa:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);
		
		List<CineVO> cines = catalogoController.getCinesEmpresa(idCine);
		
		if (cines == null || cines.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<CineVO>>(cines, HttpStatus.OK);
	}

}
