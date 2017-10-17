package mx.com.tecnetia.muvitul.negocio.inventarios.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ArticulosXPuntoVentaDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.AutorizacionMovimientoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.DocumentoDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.InventarioDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.MovimientoInventarioDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProveedorDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TipoMovimientoInvDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ArticulosXPuntoVenta;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Autorizacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AutorizacionMovimiento;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.AutorizacionMovimientoId;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Documento;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Inventario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.MovimientoInventario;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Proveedor;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TipoMovimientoInv;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.MovimientoInventarioAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.TipoMovimientoInvAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.assembler.UsuarioAssembler;
import mx.com.tecnetia.muvitul.negocio.dulceria.vo.TipoMovimientoInvVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.assembler.ArticulosXPuntoVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.assembler.AutorizacionAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.assembler.InventarioAssembler;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ArticulosXPuntoVentaVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.InventarioVO;
import mx.com.tecnetia.muvitul.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;

@Service
@Transactional
public class InventarioBO {
	final static Log log = LogFactory.getLog(InventarioBO.class);

	@Autowired
	private InventarioDAOI inventarioDAO;

	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;

	@Autowired
	private TipoMovimientoInvDAOI tipoMovimientoInvDAO;

	@Autowired
	private AutorizacionMovimientoDAOI autorizacionMovimientoDAO;
	
	@Autowired
	private ProveedorDAOI proveedorDAO;

	@Autowired
	private DocumentoDAO documentoDAO;

	@Autowired
	private ArticulosXPuntoVentaDAO articulosXPuntoVentaDAO;

	public List<ArticulosXPuntoVentaVO> getArticulosPuntoVenta(Integer idPuntoVenta, String nombreArticulo)
			throws BusinessGlobalException {

		List<ArticulosXPuntoVenta> articulosInventario = articulosXPuntoVentaDAO
				.findByIdPuntoVentaAndNameArticulo(idPuntoVenta, nombreArticulo);
		List<ArticulosXPuntoVentaVO> articulosVO = new ArrayList<ArticulosXPuntoVentaVO>();
		if (articulosInventario != null && !articulosInventario.isEmpty()) {
			articulosVO.addAll(ArticulosXPuntoVentaAssembler.getArticulosXPuntoVentaVO(articulosInventario));
		}

		return articulosVO;

	}

	public List<InventarioVO> getArticulosInventario(Integer idPuntoVenta, String nombreArticulo)
			throws BusinessGlobalException {

		List<Inventario> articulosInventario = inventarioDAO.findByIdPuntoVentaAndNameArticulo(idPuntoVenta,
				nombreArticulo);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (articulosInventario != null && !articulosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(articulosInventario));
		}

		return inventarioVO;

	}

	public List<InventarioVO> getExistenciaArticuloPorProveedores(Integer idPuntoVenta, Integer idArticulo)
			throws BusinessGlobalException {

		List<Inventario> articulosInventario = inventarioDAO.findByArticuloByProveedores(idPuntoVenta, idArticulo);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (articulosInventario != null && !articulosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(articulosInventario));
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
		
		costoUltimasSalidas = inventarioDAO.getCostoUltimasSalidasByArticulo(inventarios.get(0).getPuntoVenta().getIdPuntoVenta(), inventarios.get(0).getArticulo().getIdArticulo());		
		costoActualTotal = costoActualTotal.subtract(costoUltimasSalidas);
		costoUnitario = costoUnitario.add(costoActualTotal);
		costoUnitario = costoUnitario.divide(new BigDecimal(existencia), 3, BigDecimal.ROUND_HALF_EVEN);
		
		return costoUnitario;
	}
	
	public synchronized List<MovimientoInventario> createSalida(ParametrosInventarioVO movimientoInventarioVO, Integer idCine,
			Integer idPuntoVenta, Integer idUsuario) throws BusinessGlobalException {
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
		inventarios = inventarioDAO.findByIdArticuloAndFirtsIn(idPuntoVenta, movimientoInventarioVO.getIdArticulo());
		for (Inventario inventario : inventarios) {				
			existencia = existencia + inventario.getExistenciaActual();
		}
		//Esta lista de inventarios es utilizada unicamente para el calculo del costo promedio
		inventariosParaCalculo = new ArrayList<Inventario>();
		inventariosParaCalculo.addAll(inventarios);
					
		if (tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_DEVOLUCION)) {
			//Obtiene las existencias del articulo en inventario por el proveedor
			inventarios = inventarioDAO.findByArticuloByProveedor(idPuntoVenta, movimientoInventarioVO.getIdArticulo(),movimientoInventarioVO.getIdProveedor());
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
								movimientoInventarioVO.getIdArticulo(), inventario.getProveedor(), tipoMovimientoInvSalida,
								idUsuario, Long.valueOf(cantidad), importeSalida,
								existenciaActualSalida, idPuntoVenta,
								movimientoInventarioVO.getIdPuntoVentaConsigna() != null
										? movimientoInventarioVO.getIdPuntoVentaConsigna() : 0,
								inventario.getIdInventario()));			
						movimientosInventario.add(movInventarioSalida);
						
						//Para el tipo de movimiento de salida por venta no se requiere autorizacion
						if (!tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_VENTA)) {
							// Guarda autorizacion de salida
							autorizacionMovimientoSalida = new AutorizacionMovimiento();
							autorizacionMovimientoId = new AutorizacionMovimientoId();
							autorizacionMovimientoId.setIdAutorizacion(autorizacion.getIdAutorizacion());
							autorizacionMovimientoId.setIdMovimientoInventario(movInventarioSalida.getIdMovimiento());
							autorizacionMovimientoSalida.setId(autorizacionMovimientoId);
							autorizacionMovimientoSalida.setMovimientoInventario(movInventarioSalida);
							autorizacionMovimientoSalida.setAutorizacion(autorizacion);
							autorizacionMovimientoDAO.save(autorizacionMovimientoSalida);
						}
									
						// Para el tipo de traspaso de almacenes, adicional se guarda
						// entrada en el punto de venta destino
						if (tipoMovimientoInvSalida.getClave().equalsIgnoreCase(Constantes.SALIDA_X_TRASPASO)) {
			
							tipoMovimientoInvEntrada = tipoMovimientoInvDAO
									.findByClaveIsEntrada(Constantes.ENTRADA_X_TRASPASO, true);
							importeTraspaso = importeSalida;
			
							// Guarda entrada por traspaso
							inventarioTraspaso = InventarioAssembler.getInventario(
									movimientoInventarioVO.getIdArticulo(), inventario.getProveedor(), inventario.getLote(),
									tipoMovimientoInvEntrada, idUsuario, Long.valueOf(cantidad),
									importeTraspaso, cantidad,
									movimientoInventarioVO.getIdPuntoVentaConsigna());							
							//Al tratarse de un traspaso se asignara la misma fecha de entrada de inventario para respetar el metodo PEPS
							inventarioTraspaso.setFecha(inventario.getFecha());
							inventarioTraspaso = inventarioDAO.save(inventarioTraspaso);
			
							// Guarda movimiento de entrada por traspaso
							movInventarioEntrada = movimientoInventarioDAO
									.save(MovimientoInventarioAssembler.getMovimientoInventario(
											inventarioTraspaso.getArticulo().getIdArticulo(), inventarioTraspaso.getProveedor(),
											tipoMovimientoInvEntrada, idUsuario, Long.valueOf(inventarioTraspaso.getCantidad()),
											importeTraspaso, inventarioTraspaso.getExistenciaActual(),
											movimientoInventarioVO.getIdPuntoVentaConsigna(), idPuntoVenta,
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
	
	public Inventario createEntrada(ParametrosInventarioVO inventarioVO, Integer idCine, Integer idPuntoVenta,
			Integer idUsuario) throws BusinessGlobalException {
		//Nota: Para las salidas se considero el metodo de costo promedio de exitencia actual
		int idInventarioEntrada = 0;

		Proveedor proveedor = proveedorDAO.getById(inventarioVO.getIdProveedor());

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
		Inventario inventarioEntrada = InventarioAssembler.getInventario(inventarioVO.getIdArticulo(), proveedor,
				inventarioVO.getLote(), tipoMovimientoInvEntrada, idUsuario, Long.valueOf(inventarioVO.getCantidad()),
				new BigDecimal(inventarioVO.getImporte()), inventarioVO.getCantidad(), idPuntoVenta);

		if (documento != null) {
			inventarioEntrada.setDocumento(documento);
		}

		inventarioEntrada = inventarioDAO.save(inventarioEntrada);

		// Guarda movimiento de entrada
		MovimientoInventario movInventarioEntrada = movimientoInventarioDAO.save(
				MovimientoInventarioAssembler.getMovimientoInventario(inventarioEntrada.getArticulo().getIdArticulo(),
						inventarioEntrada.getProveedor(), tipoMovimientoInvEntrada, idUsuario,
						Long.valueOf(inventarioEntrada.getCantidad()), new BigDecimal(inventarioVO.getImporte()),
						inventarioEntrada.getExistenciaActual(), idPuntoVenta, 0,
						inventarioEntrada.getIdInventario()));

		idInventarioEntrada = inventarioEntrada.getIdInventario();

		return inventarioEntrada;

	}
	
	public List<MovimientoInventario> createEntradaAjuste(ParametrosInventarioVO parametrosVO,Integer idCine, Integer idPuntoVenta,
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
		inventarios = inventarioDAO.findByIdArticuloAndLastOut(idPuntoVenta, parametrosVO.getIdArticulo());
			
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
									MovimientoInventarioAssembler.getMovimientoInventario(inventario.getArticulo().getIdArticulo(),
											inventario.getProveedor(), tipoMovimientoInv, idUsuario,
											Long.valueOf(cantidad),importeEntrada,
											inventario.getExistenciaActual(), idPuntoVenta, 0,
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

	public List<InventarioVO> getArticulosInventarioSinConteo(Integer idPuntoVenta, String nombreArticulo)
			throws BusinessGlobalException {

		List<Inventario> articulosInventario = inventarioDAO.findByIdPuntoVentaWithOutCount(idPuntoVenta, nombreArticulo);
		List<InventarioVO> inventarioVO = new ArrayList<InventarioVO>();
		if (articulosInventario != null && !articulosInventario.isEmpty()) {
			inventarioVO.addAll(InventarioAssembler.getInventariosVO(articulosInventario));
		}

		return inventarioVO;

	}

}
