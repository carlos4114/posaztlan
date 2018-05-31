package mx.com.aztlan.pos.negocio.inventarios.business;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AlmacenDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticuloIbatisDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticulosXPuntoVentaDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AutorizacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AutorizacionMovimientoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CineDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.DocumentoDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FolioSecuenciaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioConteoDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioConteoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioConteoDetalleDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.InventarioIbatisDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MovimientoInventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PropiedadConfigDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProveedorDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoMovimientoInvDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Almacen;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AutorizacionMovimiento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.AutorizacionMovimientoId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Documento;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FolioSecuencia;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Inventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalle;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.InventarioConteoDetalleId;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.OrdenCompra;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PropiedadConfig;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Proveedor;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.EstatusConteoEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.PropiedadConfigEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.TipoAutorizacionEnum;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.enumeration.TipoMovimientoEnum;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.CorreoElectronicoBO;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.administracion.assembler.OrdenCompraAssembler;
import mx.com.aztlan.pos.negocio.administracion.vo.FiltrosVO;
import mx.com.aztlan.pos.negocio.administracion.vo.OrdenCompraVO;
import mx.com.aztlan.pos.negocio.configuracion.assembler.ProductoAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.assembler.MovimientoInventarioAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.TipoMovimientoInvAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.aztlan.pos.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.aztlan.pos.negocio.inventarios.assembler.ArticulosXPuntoVentaAssembler;
import mx.com.aztlan.pos.negocio.inventarios.assembler.AutorizacionAssembler;
import mx.com.aztlan.pos.negocio.inventarios.assembler.InventarioAssembler;
import mx.com.aztlan.pos.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ConteoVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.InventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosBusquedaVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.negocio.inventarios.vo.SalidaVO;
import mx.com.aztlan.pos.negocio.reportes.business.ReporteJasperBO;
import mx.com.aztlan.pos.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import mx.com.aztlan.pos.servicios.util.Constantes;
import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
public class InventarioBO {
	final static Log log = LogFactory.getLog(InventarioBO.class);

	@Autowired
	ServletContext context;
	
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	
	@Autowired
	private InventarioDAOI inventarioDAO;

	@Autowired
	private AutorizacionDAOI autorizacionDAO;
	
	@Autowired
	private FolioSecuenciaDAOI folioSecuenciaDAO;
	
	@Autowired
	private AlmacenDAOI almacenDAO;
	
	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;

	@Autowired
	private TipoMovimientoInvDAOI tipoMovimientoInvDAO;

	@Autowired
	private AutorizacionMovimientoDAOI autorizacionMovimientoDAO;
	
	@Autowired
	private ProveedorDAOI proveedorDAO;
	
	@Autowired
	private InventarioIbatisDAOI inventarioIbatisDAO;

	@Autowired
	private DocumentoDAO documentoDAO;

	@Autowired
	private InventarioConteoDAOI inventarioConteoDAO;
	
	@Autowired
	private InventarioConteoDetalleDAOI inventarioConteoDetalleDAO;
	
	@Autowired
	ArticuloIbatisDAOI articuloIbatisDAO;	
	
	@Autowired
	private CineDAOI cineDAO;
	
	@Autowired
	CorreoElectronicoBO correoElectronicoBO;
	
	@Autowired
    PropiedadConfigDAOI propiedadConfigDAO;	
	
	@Autowired
	private ProductoDAOI productoDAO;
	
	
	@Autowired
	@Qualifier("appMailSender")
    private JavaMailSenderImpl mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
    
    /**
     * Servicio para obtener productos en base a filtros de busqueda 
     */
	@Transactional (readOnly=true)
	public List<ProductoExistenciaVO> getProductosExistencia(FiltrosVO filtrosVO) throws Exception{
		List<ProductoExistenciaVO> productosVO;
		if(filtrosVO.getSku()==null){
			productosVO = this.inventarioIbatisDAO.getProductosPorNombre(filtrosVO.getIdAlmacen(), "%"+(filtrosVO.getNombre()==null?"":filtrosVO.getNombre().toUpperCase())+"%");
		}else{
			productosVO = this.inventarioIbatisDAO.getProductosPorSku(filtrosVO.getIdAlmacen(), filtrosVO.getSku());			
		}
		
		return productosVO;		
	}
	
	/**
     * Servicio para enviar correo electrónico 
     */
	@Transactional (readOnly=true)
	private void enviarMailAvisoPuntoReorden(String cine, String articulos, String destinatariosStr) throws Exception{
		final String asuntoCorreo = "Pos Aztlan - Avisos de Inventario";
		String[] destinatarios = destinatariosStr.split(",");
		
		Map<String,String> velAttrs = new HashMap<String,String>();
   	  	velAttrs.put("nombreCine", cine);
   	  	velAttrs.put("detalleArticulos", articulos);

   	    this.correoElectronicoBO.setMailSender(mailSender);
   	    this.correoElectronicoBO.setVelocityEngine(velocityEngine);
   	  	this.correoElectronicoBO.setTemplate("mx/com/aztlan/pos/negocio/inventarios/business/PuntoReordenMail.vm");
		this.correoElectronicoBO.setVelAttributes(velAttrs);
		this.correoElectronicoBO.setTo(destinatarios);
		this.correoElectronicoBO.setSubject(asuntoCorreo);	
		
		PropiedadConfig urlLogo = this.propiedadConfigDAO.findById(PropiedadConfigEnum.URL_LOGO.getValue());		
		if(urlLogo!=null)
 		  	this.correoElectronicoBO.setAttachments(new String[]{urlLogo.getValor()});
		
		this.correoElectronicoBO.sendVelocityMail();
	}
	
	@Transactional(readOnly=true)
	public void enviarNotificacionesPuntoReorden() throws Exception{
		
		List<Cine> cines = this.cineDAO.findActivos();
		for(Cine cine:cines){
			List<String> articulos = this.articuloIbatisDAO.obtenerArticulosParaPuntoReorden(cine.getIdCine());
			if(articulos.size()>0){
				String articulosStr = "";
				for(String articulo : articulos){
					articulosStr=articulosStr+articulo;
				}
				this.enviarMailAvisoPuntoReorden(cine.getNombre(), articulosStr, cine.getEmpresa().getContacto().getCorreoNotificacionInv());				
			}			
		}
	}


	public List<ProductoExistenciaVO> getProductosConteo(ParametrosBusquedaVO parametrosBusquedaVO)
			throws BusinessGlobalException {

		List<ProductoExistenciaVO> productosConteoVO = new ArrayList<ProductoExistenciaVO>();
		
		if (parametrosBusquedaVO.getIdAlmacen() == null) {
			List<Almacen> almacenes = almacenDAO.findByIdCanal(parametrosBusquedaVO.getIdCanal());
			
			for(Almacen almacen : almacenes) {
				List<ProductoExistenciaVO> productos = this.inventarioIbatisDAO.getProductosPorAlmacen(almacen.getIdAlmacen());
				for(ProductoExistenciaVO producto: productos) {
					producto.setIdAlmacen(almacen.getIdAlmacen());
					productosConteoVO.add(producto);
				}
			}
		}
		else {
			productosConteoVO = this.inventarioIbatisDAO.getProductosPorAlmacen(parametrosBusquedaVO.getIdAlmacen());
		}

		return productosConteoVO;

	}
	
	public List<ProductoVO> getProductos(String nombre, Integer idEmpresa)
			throws BusinessGlobalException {

		List<Producto> productos = productoDAO.findByName(nombre, idEmpresa);
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		if (productos != null && !productos.isEmpty()) {
			productosVO.addAll(ProductoAssembler.getProductos(productos));
		}

		return productosVO;

	}
	
	public List<ProductoVO> getProductosXsku(String sku, Integer idEmpresa)
			throws BusinessGlobalException {

		List<Producto> productos = productoDAO.findBySku(sku, idEmpresa);
		
		List<ProductoVO> productosVO = new ArrayList<ProductoVO>();
		if (productos != null && !productos.isEmpty()) {
			productosVO.addAll(ProductoAssembler.getProductos(productos));
		}

		return productosVO;

	}
	
	public List<InventarioVO> getProductosInventario(Integer idAlmacen, String nombreProducto)
			throws BusinessGlobalException {

		List<Inventario> productosInventario = inventarioDAO.findByIdPuntoVentaAndNameArticulo(idAlmacen,
				nombreProducto);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (productosInventario != null && !productosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(productosInventario));
		}

		return inventarioVO;

	}

	public List<InventarioVO> getExistenciaProductoPorProveedores(Integer idAlmacen, Integer idProducto)
			throws BusinessGlobalException {

		List<Inventario> productosInventario = inventarioDAO.findByArticuloByProveedores(idAlmacen, idProducto);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (productosInventario != null && !productosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(productosInventario));
		}

		return inventarioVO;
	}

	public TipoMovimientoInvVO geTipoMovimientoPorClave(String clave){
		//Obtiene el tipo de movimiento
		return TipoMovimientoInvAssembler.getTipoMovimientoInvVO(tipoMovimientoInvDAO.findByClave(clave));		
	}
	
	public BigDecimal getCostoUnitario(List<Inventario> inventarios){
		BigDecimal costoUnitario = new BigDecimal(0);
		BigDecimal costoActualTotal = new BigDecimal(0);
		BigDecimal costoUltimasSalidas = new BigDecimal(0);
		long existencia = 0;
		
		// Suma las existencias por entrada de inventario para obtener la // existencia total 		
		for (Inventario inventario : inventarios) {			
			existencia = existencia + inventario.getExistenciaActual();
			costoActualTotal = costoActualTotal.add(inventario.getImporte());
		}
		
		costoUltimasSalidas = inventarioDAO.getCostoUltimasSalidasByArticulo(inventarios.get(0).getAlmacen().getIdAlmacen(), inventarios.get(0).getProducto().getIdProducto());		
		costoActualTotal = costoActualTotal.subtract(costoUltimasSalidas);
		costoUnitario = costoUnitario.add(costoActualTotal);
		costoUnitario = costoUnitario.divide(new BigDecimal(existencia), 3, BigDecimal.ROUND_HALF_EVEN);
		
		return costoUnitario;
	}
	
	public void createSalidas(SalidaVO salidaVO, Integer idUsuario) throws BusinessGlobalException{
		
		if(salidaVO.getIdTipoMovimiento() == null ) {
			TipoMovimientoInv tipoMovInv = tipoMovimientoInvDAO.findByClave(salidaVO.getClaveTipoMovimiento());
			salidaVO.setIdTipoMovimiento(tipoMovInv==null?null:tipoMovInv.getIdTipoMovimientoInv());
		}
		
		for (ProductoVO producto : salidaVO.getProductos()) {
			ParametrosInventarioVO movimientoInventarioVO = new ParametrosInventarioVO();
			movimientoInventarioVO.setCantidad(producto.getCantidad());
			movimientoInventarioVO.setIdProducto(producto.getIdProducto());
			movimientoInventarioVO.setIdProveedor(salidaVO.getIdProveedor());
			movimientoInventarioVO.setIdAutorizacion(salidaVO.getIdAutorizacion());
			movimientoInventarioVO.setIdTipoMovimiento(salidaVO.getIdTipoMovimiento());
			movimientoInventarioVO.setIdAlmacenConsigna(salidaVO.getIdAlmacenConsigna());
			movimientoInventarioVO.setClaveTipoMovimiento(salidaVO.getClaveTipoMovimiento());
			this.createSalida(movimientoInventarioVO, salidaVO.getIdCanal(), salidaVO.getIdAlmacen(), idUsuario);
		}
	}
	
	public synchronized List<MovimientoInventario> createSalida(ParametrosInventarioVO movimientoInventarioVO, Integer idCanal,
			Integer idAlmacen, Integer idUsuario) throws BusinessGlobalException {
		//Nota: Para las salidas se considero el metodo de costo promedio de exitencia actual
		List<MovimientoInventario> movimientosInventario = new ArrayList<MovimientoInventario>();
		MovimientoInventario movInventarioSalida = null;
		List<Inventario> inventarios = null;
		List<Inventario> inventariosParaCalculo = null;
		MovimientoInventario movInventarioEntrada = null;
		TipoMovimientoInv tipoMovimientoInvEntrada = null;
		AutorizacionMovimiento autorizacionMovimientoSalida = null;
		AutorizacionMovimientoId autorizacionMovimientoId = null;
		Inventario inventarioTraspaso = null;		
		BigDecimal costoUnitario = new BigDecimal(0);
		BigDecimal importeTraspaso = new BigDecimal(0);
		BigDecimal importeSalida = new BigDecimal(0);
		long existencia = 0;
		long cantidad = 0;
		long salidaTotal = 0;
		long existenciaActualSalida = 0l;				
			
		//Obtiene el tipo de movimiento solicitado				
		TipoMovimientoInv tipoMovimientoInvSalida = TipoMovimientoInvAssembler.getTipoMovimientoInv(movimientoInventarioVO.getIdTipoMovimiento()); 
		tipoMovimientoInvSalida.setClave(movimientoInventarioVO.getClaveTipoMovimiento());
		Autorizacion autorizacion = AutorizacionAssembler.getAutorizacion(movimientoInventarioVO.getIdAutorizacion());
		
		// Obtiene las existencias del articulo en inventario ordenadas por primeras entradas
		inventarios = inventarioDAO.findByIdArticuloAndFirtsIn(idAlmacen, movimientoInventarioVO.getIdProducto());
		for (Inventario inventario : inventarios) {				
			existencia = existencia + inventario.getExistenciaActual();
		}
		//Esta lista de inventarios es utilizada unicamente para el calculo del costo promedio
		inventariosParaCalculo = new ArrayList<Inventario>();
		inventariosParaCalculo.addAll(inventarios);
					
		if (tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_DEVOLUCION)) {
			//Obtiene las existencias del articulo en inventario por el proveedor
			inventarios = inventarioDAO.findByArticuloByProveedor(idAlmacen, movimientoInventarioVO.getIdProducto(),movimientoInventarioVO.getIdProveedor());
			// Suma las existencias por entrada de inventario para obtener la existencia total y el costo promedio (costo unitario)
			for (Inventario inventario : inventarios){
				existencia = existencia + inventario.getExistenciaActual();
			}
		}		
				
		//Valida si la existencia total cubre la cantidad solicitada
		if(existencia >= movimientoInventarioVO.getCantidad() ){
			
			// Realiza descuento de articulos aplicando PEPS
			for (Inventario inventario : inventarios){
				
				//Valida si ya se cubrio la cantidad solicitada
				if(salidaTotal != movimientoInventarioVO.getCantidad()){
					//Valida la existencia del inventario por cada entrada
					if (inventario.getExistenciaActual() >= (movimientoInventarioVO.getCantidad().intValue() - salidaTotal)) {
						cantidad = movimientoInventarioVO.getCantidad() - salidaTotal;
					} else{
						cantidad = inventario.getExistenciaActual();
					}				
						salidaTotal = salidaTotal + cantidad;					
						existenciaActualSalida = inventario.getExistenciaActual() - cantidad;
			
						//obtiene costo unitario
						costoUnitario = getCostoUnitario(inventariosParaCalculo);
						//Elimina inventario para ya no tomarlo en cuenta para el costo promedio de la existencia actual en la proxima iteracion.
						inventariosParaCalculo.remove(inventario);
						
						importeSalida = new BigDecimal(0);
						importeSalida = importeSalida.add(new BigDecimal(cantidad));
						importeSalida = importeSalida.multiply(costoUnitario);
			
						// Actuliza existencia de inventario
						inventario.setExistenciaActual(existenciaActualSalida);
						inventario.setUltimoMovimiento(new Date());
						inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(idUsuario));
						inventarioDAO.update(inventario);
						
						// Guarda movimiento de salida
						movInventarioSalida = movimientoInventarioDAO.save(MovimientoInventarioAssembler.getMovimientoInventario(
								movimientoInventarioVO.getIdProducto(), inventario.getProveedor(), tipoMovimientoInvSalida,
								idUsuario, Long.valueOf(cantidad), importeSalida,
								existenciaActualSalida, idAlmacen,
								movimientoInventarioVO.getIdAlmacenConsigna() != null
										? movimientoInventarioVO.getIdAlmacenConsigna() : null,
								inventario.getIdInventario()));			
						movimientosInventario.add(movInventarioSalida);
						
						//Para el tipo de movimiento de salida por venta no se requiere autorizacion
						if (!tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_VENTA) && 
								!tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_VENTA_MAN)) {
							// Guarda autorizacion de salida
							if(autorizacion!=null){
								autorizacionMovimientoSalida = new AutorizacionMovimiento();
								autorizacionMovimientoId = new AutorizacionMovimientoId();
								autorizacionMovimientoId.setIdAutorizacion(autorizacion.getIdAutorizacion());
								autorizacionMovimientoId.setIdMovimientoInventario(movInventarioSalida.getIdMovimiento());
								autorizacionMovimientoSalida.setId(autorizacionMovimientoId);
								autorizacionMovimientoSalida.setMovimientoInventario(movInventarioSalida);
								autorizacionMovimientoSalida.setAutorizacion(autorizacion);
								autorizacionMovimientoDAO.save(autorizacionMovimientoSalida);
							}
						}
									
						// Para el tipo de traspaso de almacenes, adicional se guarda
						// entrada en el punto de venta destino
						if (tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_TRASPASO)) {
			
							tipoMovimientoInvEntrada = tipoMovimientoInvDAO
									.findByClaveIsEntrada(Constantes.ENTRADA_X_TRASPASO, true);
							importeTraspaso = importeSalida;
			
							// Guarda entrada por traspaso
						inventarioTraspaso = InventarioAssembler.getInventario(
									movimientoInventarioVO.getIdProducto(), inventario.getProveedor(), inventario.getLote(),
									tipoMovimientoInvEntrada, idUsuario, Long.valueOf(cantidad),
									importeTraspaso, cantidad,
									movimientoInventarioVO.getIdAlmacenConsigna(),null);
							//Al tratarse de un traspaso se asignara la misma fecha de entrada de inventario para respetar el metodo PEPS
							inventarioTraspaso.setFecha(inventario.getFecha());
							inventarioTraspaso = inventarioDAO.save(inventarioTraspaso);
			
							// Guarda movimiento de entrada por traspaso
							movInventarioEntrada = movimientoInventarioDAO
									.save(MovimientoInventarioAssembler.getMovimientoInventario(
											inventarioTraspaso.getProducto().getIdProducto(), inventarioTraspaso.getProveedor(),
											tipoMovimientoInvEntrada, idUsuario, Long.valueOf(inventarioTraspaso.getCantidad()),
											importeTraspaso, inventarioTraspaso.getExistenciaActual(),
											movimientoInventarioVO.getIdAlmacenConsigna(),idAlmacen,
											inventarioTraspaso.getIdInventario()));
							
							movimientosInventario.add(movInventarioEntrada);
						}	
				}else{
					//Termina descuento de inventarios
					break;
				}
					
			}//Termina la iteracion de las existencias del articulo
		}else{
			//La cantidad solicitada es mayor que la existencia total del articulo
			//No realiza niguna accion
			movimientosInventario = new ArrayList<MovimientoInventario>();
		}
		
		return movimientosInventario;

	}
		
	public void createEntradaOrdenCompra(OrdenCompraVO ordenCompraVO, Integer idUsuario) throws BusinessGlobalException {
		Double importe;
		
		String clave = tipoMovimientoInvDAO.getById(TipoMovimientoEnum.COMPRA).getClave();
		
		for (ProductoVO producto : ordenCompraVO.getProductos()) {
			
			if(producto.getCantidadRestante() > 0) {
				importe = producto.getPrecioUnitarioFinal().doubleValue() * producto.getCantidadFinal();
				
				if(ordenCompraVO.getDescuento().doubleValue() > 0) {
					importe = importe * (1 - (ordenCompraVO.getDescuento().doubleValue() / 100));
				}
				
				ParametrosInventarioVO movimientoInventarioVO = new ParametrosInventarioVO();
				movimientoInventarioVO.setCantidad(producto.getCantidadFinal());
				movimientoInventarioVO.setIdProducto(producto.getIdProducto());
				movimientoInventarioVO.setImporte(importe.floatValue());
				movimientoInventarioVO.setIdProveedor(ordenCompraVO.getIdProveedor());
				movimientoInventarioVO.setIdAutorizacion(0);
				movimientoInventarioVO.setIdEmpresa(ordenCompraVO.getIdEmpresa());
				movimientoInventarioVO.setIdTipoMovimiento(TipoMovimientoEnum.COMPRA);
				movimientoInventarioVO.setClaveTipoMovimiento(clave);
				movimientoInventarioVO.setIdOrdenCompra(ordenCompraVO.getIdOrdenCompra());
				this.createEntrada(movimientoInventarioVO,idUsuario);
			}			
		}
	}
	
	public MovimientoInventario createEntrada(ParametrosInventarioVO inventarioVO, Integer idUsuario) throws BusinessGlobalException {
		//Nota: Para las salidas se considero el metodo de costo promedio de exitencia actual
		int idInventarioEntrada = 0;
		
		Integer idAlmacen = almacenDAO.getAlmacenCentral(inventarioVO.getIdEmpresa());
		Proveedor proveedor;
		
		if(inventarioVO.getIdTipoMovimiento() == TipoMovimientoEnum.AJUSTE_MANUAL_CONTEO_ENTRADA) {
			proveedor = null;
			idAlmacen = inventarioVO.getIdAlmacen();
		}else
		{
			proveedor = proveedorDAO.getById(inventarioVO.getIdProveedor());
		}
	
		// Obtiene tipo de movimiento		
		TipoMovimientoInv tipoMovimientoInvEntrada = TipoMovimientoInvAssembler.getTipoMovimientoInv(inventarioVO.getIdTipoMovimiento()); 
		tipoMovimientoInvEntrada.setClave(inventarioVO.getClaveTipoMovimiento());

		// Guarda archivo
		Documento documento = null;
		if (inventarioVO.getArchivo() != null) {
			documento = new Documento(0, inventarioVO.getNombreArchivo(), inventarioVO.getArchivo(),
					inventarioVO.getContentType(), inventarioVO.getSizeArchivo(), tipoMovimientoInvEntrada.getNombre(),
					true);
			documento = documentoDAO.save(documento);
		}

		// Guarda entrada
		Inventario inventarioEntrada = InventarioAssembler.getInventario(inventarioVO.getIdProducto(), proveedor,
				inventarioVO.getLote(), tipoMovimientoInvEntrada, idUsuario, Long.valueOf(inventarioVO.getCantidad()),
				new BigDecimal(inventarioVO.getImporte()), inventarioVO.getCantidad(), idAlmacen, inventarioVO.getIdOrdenCompra());

		if (documento != null) {
			inventarioEntrada.setDocumento(documento);
		}

		inventarioEntrada = inventarioDAO.save(inventarioEntrada);

		// Guarda movimiento de entrada
		MovimientoInventario movInventarioEntrada = movimientoInventarioDAO.save(
				MovimientoInventarioAssembler.getMovimientoInventario(inventarioEntrada.getProducto().getIdProducto(),
						inventarioEntrada.getProveedor(), tipoMovimientoInvEntrada, idUsuario,
						Long.valueOf(inventarioEntrada.getCantidad()), new BigDecimal(inventarioVO.getImporte()),
						inventarioEntrada.getExistenciaActual(), idAlmacen, null,
						inventarioEntrada.getIdInventario()));

		idInventarioEntrada = inventarioEntrada.getIdInventario();

		return movInventarioEntrada;

	}
	/*public List<MovimientoInventario> createEntradaAjuste(ParametrosInventarioVO parametrosVO,Integer idcanal, Integer idAlmacen,
			Integer idUsuario) throws BusinessGlobalException {
		//Nota: Para las salidas se considero el metodo de costo promedio de exitencia actual
		List<MovimientoInventario> movimientosInventario = new ArrayList<MovimientoInventario>();
		List<Inventario> inventarios = null;		
		AutorizacionMovimiento autorizacionMovimiento = null;
		AutorizacionMovimientoId autorizacionMovimientoId = null;
		TipoMovimientoInv tipoMovimientoInv = null;
		MovimientoInventario movimientoInventario = null;		
		BigDecimal importeEntrada = new BigDecimal(0);
		BigDecimal costoUnitario = new BigDecimal(0);
		long existenciaTotal = 0;
		long cantidad = 0;
		long cantidadTotal = 0;
		long existenciaActual = 0;
		long disponibilidad = 0;
				
		Autorizacion autorizacion = AutorizacionAssembler.getAutorizacion(parametrosVO.getIdAutorizacion());
		//Obtiene el tipo de movimiento solicitado				
		tipoMovimientoInv = TipoMovimientoInvAssembler.getTipoMovimientoInv(parametrosVO.getIdTipoMovimiento()); 
		tipoMovimientoInv.setClave(parametrosVO.getClaveTipoMovimiento());
		//Obtiene las existencias del articulo en inventario ordenadas por primeras entradas
		inventarios = inventarioDAO.findByIdArticuloAndLastOut(idAlmacen, parametrosVO.getIdProducto());
			
			// Realiza ajuste de articulos aplicando PEPS
			for (Inventario inventario : inventarios){
				
				disponibilidad = inventario.getCantidad() - inventario.getExistenciaActual();
				
				//Valida si ya se cubrio la cantidad solicitada
				if(cantidadTotal != parametrosVO.getCantidad()){
					//Valida la existencia del inventario por cada entrada					
					if(disponibilidad !=0 ){
						
						if(disponibilidad > parametrosVO.getCantidad() - cantidadTotal){
							cantidad = parametrosVO.getCantidad() - cantidadTotal;
						}else{					
							cantidad  = disponibilidad; 
						}
						
							cantidadTotal = cantidadTotal + cantidad;					
							existenciaActual = inventario.getExistenciaActual() + cantidad;
									
							// Actuliza existencia de inventario
							inventario.setExistenciaActual(existenciaActual);
							inventario.setUltimoMovimiento(new Date());
							inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(idUsuario));
							inventarioDAO.update(inventario);
							
							importeEntrada = new BigDecimal(0);
							importeEntrada = importeEntrada.add(inventario.getImporte());
							importeEntrada = importeEntrada.divide(new BigDecimal(inventario.getCantidad()), 3, BigDecimal.ROUND_HALF_EVEN);
							importeEntrada = importeEntrada.multiply(new BigDecimal(cantidad));
							
							// Guarda movimiento de entrada
							movimientoInventario = movimientoInventarioDAO.save(
									MovimientoInventarioAssembler.getMovimientoInventario(inventario.getProducto().getIdProducto(),
											inventario.getProveedor(), tipoMovimientoInv, idUsuario,
											Long.valueOf(cantidad),importeEntrada,
											inventario.getExistenciaActual(), idAlmacen, 0,
											inventario.getIdInventario()));
							
							// Guarda autorizacion
							autorizacionMovimiento = new AutorizacionMovimiento();
							autorizacionMovimientoId = new AutorizacionMovimientoId();
							autorizacionMovimientoId.setIdAutorizacion(autorizacion.getIdAutorizacion());
							autorizacionMovimientoId.setIdMovimientoInventario(movimientoInventario.getIdMovimiento());
							autorizacionMovimiento.setId(autorizacionMovimientoId);
							autorizacionMovimiento.setMovimientoInventario(movimientoInventario);
							autorizacionMovimiento.setAutorizacion(autorizacion);
							autorizacionMovimientoDAO.save(autorizacionMovimiento);
							
							movimientosInventario.add(movimientoInventario);	
					}//Termina if diponibilidad == 0
				}else{
					break;
				}
				
			}
			
		return movimientosInventario;

	}*/
	
	public List<MovimientoInventario> createEntradaAjuste(ParametrosInventarioVO parametrosVO,Integer idcanal, Integer idAlmacen,
			Integer idUsuario) throws BusinessGlobalException {
		//Nota: Para las salidas se considero el metodo de costo promedio de exitencia actual
		List<MovimientoInventario> movimientosInventario = new ArrayList<MovimientoInventario>();
		List<Inventario> inventarios = null;		
		AutorizacionMovimiento autorizacionMovimiento = null;
		AutorizacionMovimientoId autorizacionMovimientoId = null;
		TipoMovimientoInv tipoMovimientoInv = null;
		MovimientoInventario movimientoInventario = null;		
		BigDecimal importeEntrada = new BigDecimal(0);
		long cantidad = 0;
		long cantidadTotal = 0;
		long existenciaActual = 0;
		long disponibilidad = 0;
				
		Autorizacion autorizacion = AutorizacionAssembler.getAutorizacion(parametrosVO.getIdAutorizacion());
		
		//Obtiene el tipo de movimiento solicitado				
		tipoMovimientoInv = TipoMovimientoInvAssembler.getTipoMovimientoInv(parametrosVO.getIdTipoMovimiento()); 
		tipoMovimientoInv.setClave(parametrosVO.getClaveTipoMovimiento());
		//Obtiene las existencias del articulo en inventario ordenadas por primeras entradas
		inventarios = inventarioDAO.findByIdProductoAndLastOut(idAlmacen, parametrosVO.getIdProducto());
			
			// Realiza ajuste de articulos aplicando PEPS
			for (Inventario inventario : inventarios){
				
				disponibilidad = inventario.getCantidad() - inventario.getExistenciaActual();
				
				//Valida si ya se cubrio la cantidad solicitada
				if(cantidadTotal != parametrosVO.getCantidad()){
					//Valida la existencia del inventario por cada entrada					
					if(disponibilidad !=0 ){
						
						if(disponibilidad > parametrosVO.getCantidad() - cantidadTotal){
							cantidad = parametrosVO.getCantidad() - cantidadTotal;
						}else{					
							cantidad  = disponibilidad; 
						}
						
							cantidadTotal = cantidadTotal + cantidad;					
							existenciaActual = inventario.getExistenciaActual() + cantidad;
									
							// Actuliza existencia de inventario
							inventario.setExistenciaActual(existenciaActual);
							inventario.setUltimoMovimiento(new Date());
							inventario.setUsuarioUltimoMovimiento(UsuarioAssembler.getUsuario(idUsuario));
							inventarioDAO.update(inventario);
							
							importeEntrada = new BigDecimal(0);
							importeEntrada = importeEntrada.add(inventario.getImporte());
							importeEntrada = importeEntrada.divide(new BigDecimal(inventario.getCantidad()), 3, BigDecimal.ROUND_HALF_EVEN);
							importeEntrada = importeEntrada.multiply(new BigDecimal(cantidad));
							
							// Guarda movimiento de entrada
							movimientoInventario = movimientoInventarioDAO.save(
									MovimientoInventarioAssembler.getMovimientoInventario(inventario.getProducto().getIdProducto(),
											inventario.getProveedor(), tipoMovimientoInv, idUsuario,
											Long.valueOf(cantidad),importeEntrada,
											inventario.getExistenciaActual(), idAlmacen, 0,
											inventario.getIdInventario()));
							
							// Guarda autorizacion
							autorizacionMovimiento = new AutorizacionMovimiento();
							autorizacionMovimientoId = new AutorizacionMovimientoId();
							autorizacionMovimientoId.setIdAutorizacion(autorizacion.getIdAutorizacion());
							autorizacionMovimientoId.setIdMovimientoInventario(movimientoInventario.getIdMovimiento());
							autorizacionMovimiento.setId(autorizacionMovimientoId);
							autorizacionMovimiento.setMovimientoInventario(movimientoInventario);
							autorizacionMovimiento.setAutorizacion(autorizacion);
							autorizacionMovimientoDAO.save(autorizacionMovimiento);
							
							movimientosInventario.add(movimientoInventario);	
					}//Termina if diponibilidad == 0
				}else{
					break;
				}
				
			}
			
		return movimientosInventario;

	}

	public List<InventarioVO> getProductosInventarioSinConteo(Integer idAlmacen, String nombreProducto)
			throws BusinessGlobalException {

		List<Inventario> productosInventario = inventarioDAO.findByIdPuntoVentaWithOutCount(idAlmacen, nombreProducto);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (productosInventario != null && !productosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(productosInventario));
		}

		return inventarioVO;

	}

	public ConteoVO obtenerConteo(Integer idEmpresa, Integer folio) throws BusinessGlobalException {
		
		InventarioConteo inventarioConteo= this.inventarioConteoDAO.getByFolio(idEmpresa, folio).get(0);
		
		ConteoVO conteo = InventarioAssembler.getConteoVO(
				inventarioConteo, this.inventarioConteoDetalleDAO.findByIdConteo(inventarioConteo.getIdConteo()));
		
		return conteo;
	}


	public Integer guardarConteo(ConteoVO conteoVO) throws BusinessGlobalException {
		Integer folio = null;
		
		if(conteoVO.getIdConteo() == null) {
			FolioSecuencia folioSecuencia = this.folioSecuenciaDAO.getById(conteoVO.getIdEmpresa());
			
			if(folioSecuencia==null){
				folio = 1;
				this.folioSecuenciaDAO.save(new FolioSecuencia(conteoVO.getIdEmpresa(),1));
			}else{
				folio = folioSecuencia.getUltimoFolioConteo()+1;
				folioSecuencia.setUltimoFolioConteo(folio);
				this.folioSecuenciaDAO.update(folioSecuencia);
			}
			
			InventarioConteo inventarioConteo = InventarioAssembler.getInventarioConteo(conteoVO, folio); 
		
			inventarioConteo = this.inventarioConteoDAO.save(inventarioConteo);
			
			this.guardarConteoDetalle(conteoVO, inventarioConteo.getIdConteo());
			
			return inventarioConteo.getFolio();

		}else {
			InventarioConteo inventarioConteo = inventarioConteoDAO.getById(conteoVO.getIdConteo());
			inventarioConteo.setEstatusConteo(new EstatusConteo(conteoVO.getIdEstatusConteo()));
			inventarioConteoDAO.update(inventarioConteo);
			
			for(ProductoExistenciaVO producto: conteoVO.getProductos()) {
				InventarioConteoDetalle detalle = inventarioConteoDetalleDAO.getById(
						new InventarioConteoDetalleId(conteoVO.getIdConteo(), producto.getIdProducto(), producto.getIdAlmacen()));
				
				detalle.setExistenciaFisica(producto.getExistenciaFisica());
				detalle.setDiferencia(producto.getDiferencia());
				
				inventarioConteoDetalleDAO.update(detalle);
			}
			
			return conteoVO.getFolio();
		}
		
	}
	
	@Transactional(readOnly = false)
	public void guardarConteoDetalle(ConteoVO conteoVO, Integer idConteo) throws BusinessGlobalException  {
		
		List<ProductoExistenciaVO> productos = conteoVO.getProductos();
		
		for(ProductoExistenciaVO productoExistenciaVO : productos) {
			inventarioConteoDetalleDAO.save(InventarioAssembler.getInventarioConteoDetalle(productoExistenciaVO, conteoVO, idConteo));
		}
		
	}
	
	@Transactional(readOnly = false)
	public Integer actualizarConteo(ConteoVO conteoVO) throws BusinessGlobalException  {
		
		InventarioConteo inventarioConteo = inventarioConteoDAO.getById(conteoVO.getIdConteo());
		inventarioConteo.setEstatusConteo(new EstatusConteo(EstatusConteoEnum.AUTORIZADO));
		inventarioConteo.setUsuarioAutorizador(new Usuario(conteoVO.getIdUsuarioAutorizador()));
	
		inventarioConteo = inventarioConteoDAO.update(inventarioConteo);
		
		return inventarioConteo.getFolio();
	}
	
	@Transactional(readOnly = false)
	public Integer autorizarConteo(ConteoVO conteoVO) throws BusinessGlobalException  {
		Integer cantidad = 0;
		String clave;
		List<ProductoExistenciaVO> productos = conteoVO.getProductos();
		
		Autorizacion autorizacion = new Autorizacion();
		autorizacion.setTipoAutorizacion(new TipoAutorizacion(TipoAutorizacionEnum.AJUSTE_CONTEO_INVENTARIO));
		autorizacion.setComentarios("Autorizacion de conteo.");
		autorizacion.setUsuario(new Usuario(conteoVO.getIdUsuarioAutorizador()));
		
		autorizacion.setFecha(new Date());
		
		autorizacion = autorizacionDAO.save(autorizacion);
		
		for(ProductoExistenciaVO productoExistenciaVO : productos) {
			
			if(productoExistenciaVO.getExistencia() != productoExistenciaVO.getExistenciaFisica()) {
				if(productoExistenciaVO.getExistencia() < productoExistenciaVO.getExistenciaFisica()) {
					//ENTRADA
					cantidad = productoExistenciaVO.getExistenciaFisica() - productoExistenciaVO.getExistencia();
					clave = tipoMovimientoInvDAO.getById(TipoMovimientoEnum.AJUSTE_MANUAL_CONTEO_ENTRADA).getClave();
					
					ParametrosInventarioVO movimientoInventarioVO = new ParametrosInventarioVO();
					movimientoInventarioVO.setCantidad(cantidad);
					movimientoInventarioVO.setIdProducto(productoExistenciaVO.getIdProducto());
					movimientoInventarioVO.setImporte(new Float(0));
					movimientoInventarioVO.setIdProveedor(null);
					movimientoInventarioVO.setIdAutorizacion(autorizacion.getIdAutorizacion());
					movimientoInventarioVO.setIdEmpresa(conteoVO.getIdEmpresa());
					movimientoInventarioVO.setIdTipoMovimiento(TipoMovimientoEnum.AJUSTE_MANUAL_CONTEO_ENTRADA);
					movimientoInventarioVO.setClaveTipoMovimiento(clave);
					movimientoInventarioVO.setIdAlmacen(productoExistenciaVO.getIdAlmacen());
					
					 MovimientoInventario movimiento = this.createEntrada(movimientoInventarioVO, conteoVO.getIdUsuarioAutorizador());
					
					InventarioConteoDetalle detalle = inventarioConteoDetalleDAO.findById(
							new InventarioConteoDetalleId(conteoVO.getIdConteo(), 
									productoExistenciaVO.getIdProducto(), 
									productoExistenciaVO.getIdAlmacen()));
					
					detalle.setMovimientoInventario(new MovimientoInventario(movimiento.getIdMovimiento()));
					
					inventarioConteoDetalleDAO.update(detalle);
					
					AutorizacionMovimiento autorizacionMov = new AutorizacionMovimiento();
					autorizacionMov.setAutorizacion(autorizacion);
					autorizacionMov.setId(new AutorizacionMovimientoId(autorizacion.getIdAutorizacion(), movimiento.getIdMovimiento()));
					autorizacionMov.setMovimientoInventario(movimiento);
					autorizacionMovimientoDAO.save(autorizacionMov);
					
				}else {
					//SALIDA
					
					cantidad = productoExistenciaVO.getExistencia() - productoExistenciaVO.getExistenciaFisica();
					
					clave = tipoMovimientoInvDAO.getById(TipoMovimientoEnum.AJUSTE_MANUAL_CONTEO_SALIDA).getClave();
					
					ParametrosInventarioVO movimientoInventarioVO = new ParametrosInventarioVO();
					movimientoInventarioVO.setCantidad(cantidad);
					movimientoInventarioVO.setIdProducto(productoExistenciaVO.getIdProducto());
					movimientoInventarioVO.setImporte(new Float(0));
					movimientoInventarioVO.setIdProveedor(null);
					movimientoInventarioVO.setIdAutorizacion(autorizacion.getIdAutorizacion());
					movimientoInventarioVO.setIdEmpresa(conteoVO.getIdEmpresa());
					movimientoInventarioVO.setIdTipoMovimiento(TipoMovimientoEnum.AJUSTE_MANUAL_CONTEO_SALIDA);
					movimientoInventarioVO.setClaveTipoMovimiento(clave);
					MovimientoInventario movimiento = this.createSalida(movimientoInventarioVO,conteoVO.getIdCanal(), productoExistenciaVO.getIdAlmacen(), conteoVO.getIdUsuarioAutorizador()).get(0);
					
					InventarioConteoDetalle detalle = inventarioConteoDetalleDAO.findById(
							new InventarioConteoDetalleId(conteoVO.getIdConteo(), 
									productoExistenciaVO.getIdProducto(), 
									productoExistenciaVO.getIdAlmacen()));
					
					detalle.setMovimientoInventario(new MovimientoInventario(movimiento.getIdMovimiento()));
					inventarioConteoDetalleDAO.update(detalle);
				}
				
			}
			
		}
		
		this.actualizarConteo(conteoVO);
		return conteoVO.getFolio();
	}
	
	@Transactional(readOnly = true)
	public ArchivoExcelVO crearXlsConteo(Integer idAlmacen) throws BusinessGlobalException  {
		ArchivoExcelVO archivoExcelVO = new ArchivoExcelVO("ConteoInventarioAlmacen");
		
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaJasper = cfg.getString("reporte.inventarioconteo.nueva.jasper");
		//String rutaReporteXls = context.getRealPath(cfg.getString("reporte.conteoinventario.nueva.xls"));
			  	 
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("ID_ALMACEN", idAlmacen);
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaJasper);
		//reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(params);
		 
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (HibernateException | BusinessGlobalException | NotFoundException | IOException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return archivoExcelVO;
	}
	
}
