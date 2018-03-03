package mx.com.aztlan.pos.servicios.facade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import mx.com.aztlan.pos.negocio.inventarios.vo.ProveedorVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/catalogo")
public interface CatalogoFacadeI {


	@RequestMapping(value = "/cajas/{idAlmacen}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getCajas(@PathVariable("idAlmacen") Integer idAlmacen)
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

	@RequestMapping(value = "/almacenes", method = RequestMethod.GET)
	public ResponseEntity<List<AlmacenVO>> getAlmacenes(HttpServletRequest request)
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
	
	@RequestMapping(value = "/canalesEmpresa/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CanalVO>> getCanalesEmpresa(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/almacenes/{idCanal}", method = RequestMethod.GET)
	public ResponseEntity<List<AlmacenVO>> getAlmacenes(@PathVariable("idCanal") Integer idCanal) 
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/clasificaciones/{idCine}", method = RequestMethod.GET)
	public ResponseEntity<List<ClasificacionArtVO>> getClasificacionesArt(@PathVariable("idCine") Integer idCine) 
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/unidadesMedida/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getUnidadesMedida(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/familias/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getFamilias(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/marcas/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getMarcas(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;

	@RequestMapping(value = "/tipos/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getTipos(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/medidas/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getMedidas(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	@RequestMapping(value = "/proveedores/{idEmpresa}", method = RequestMethod.GET)
	public ResponseEntity<List<CatalogoVO>> getProveedores(@PathVariable("idEmpresa") Integer idEmpresa)
			throws BusinessGlobalException, NotFoundException;
	
	
}
