package mx.com.tecnetia.muvitul.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.ArticuloVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CatalogoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.CineVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EstadoProductoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.FormaPagoVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoCancelacionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.MotivoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.PuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.TipoDevolucionVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ProveedorVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/catalogo")
public interface CatalogoFacadeI {


	@RequestMapping(value = "/cajas/{idPuntoVenta}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getCajas(@PathVariable("idPuntoVenta") Integer idPuntoVenta)
			throws BusinessGlobalException;

	@RequestMapping(value = "/cargoAjuste", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getCargoAjuste()
			throws BusinessGlobalException;

	@RequestMapping(value = "/formaspago", method = RequestMethod.GET)
	public ResponseEntity<List<FormaPagoVO>> getFormasPago(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/articulos", method = RequestMethod.GET)
	public ResponseEntity<List<ArticuloVO>> getArticulos(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/puntosVenta", method = RequestMethod.GET)
	public ResponseEntity<List<PuntoVentaVO>> getPuntosVenta(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/puntosVenta/{idCine}", method = RequestMethod.GET)
	public ResponseEntity<List<PuntoVentaVO>> getPuntosVenta(@PathVariable("idCine") Integer idCine) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/proveedor", method = RequestMethod.GET)
	public ResponseEntity<List<ProveedorVO>> getProveedor(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;
		
	@RequestMapping(value = "/motivosDevolucion", method = RequestMethod.GET)
	public ResponseEntity<List<MotivoDevolucionVO>> getMotivosDevolucion(HttpServletRequest request, Integer idPuntoVenta )
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/tiposDevolucion", method = RequestMethod.GET)
	public ResponseEntity<List<TipoDevolucionVO>> getTiposDevolucion(HttpServletRequest request, Integer idTipoPuntoVenta)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/estadosProducto", method = RequestMethod.GET)
	public ResponseEntity<List<EstadoProductoVO>> getEstadosProducto(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/motivosCancelacion", method = RequestMethod.GET)
	public ResponseEntity<List<MotivoCancelacionVO>> getMotivosCancelacion(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/cinesEmpresa", method = RequestMethod.GET)
	public ResponseEntity<List<CineVO>> getCinesEmpresa(HttpServletRequest request)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/cinesEmpresa/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CineVO>> getCinesEmpresa(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
}
