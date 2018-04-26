package mx.com.aztlan.pos.negocio.devolucion.business;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AsistenciaXSalaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.BoletosXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CineDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.DevolucionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.DevolucionXProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstadoProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.EstatusPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.FormaPagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MovimientoInventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TicketVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoMovimientoInvDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.BoletosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Devolucion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.DevolucionXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstadoProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.EstatusPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.FormaPago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.devolucion.assembler.AutorizacionAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.BoletoXTicketAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.CortesiaAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.DevolucionAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.DevolucionXProductoAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.PagoAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.PromocionXTicketAssembler;
import mx.com.aztlan.pos.negocio.devolucion.assembler.TicketVentaAssembler;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.ArticuloXProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.CortesiaPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DetalleTicketPdfVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.DevolucionResponseVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.PaqueteXTicketVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.ProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.ProductoXPaqueteVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaBoletoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaProductoVO;
import mx.com.aztlan.pos.negocio.devolucion.vo.TicketVentaVO;
import mx.com.aztlan.pos.negocio.inventarios.business.InventarioBO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.servicios.util.Constantes;
import mx.com.aztlan.pos.servicios.util.DevolucionType;
import mx.com.aztlan.pos.servicios.util.EstadoProductoType;
import mx.com.aztlan.pos.servicios.util.EstatusPagoType;
import mx.com.aztlan.pos.servicios.util.FormaPagoType;
import mx.com.aztlan.pos.servicios.util.MovimientoInvType;
import mx.com.aztlan.pos.servicios.util.PuntoVentaType;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class DevolucionBO {
	private static final Logger logger = LoggerFactory.getLogger(DevolucionBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private DevolucionDAOI devolucionDAO;

	@Autowired
	private EstatusPagoDAOI estatusPagoDAO;

	@Autowired
	private FormaPagoDAOI formaPagoDAO;

	@Autowired
	private BoletosXTicketDAOI boletoXTicketDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private TipoMovimientoInvDAOI tipoMovimientoInvDAO;

	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;

	@Autowired
	private CineDAOI cineDAO;

	@Autowired
	private PaqueteXTicketDAOI paqueteXTicketDAO;
	
	@Autowired
	private ProductoXTicketDAOI productoXTicketDAO;
	
	@Autowired
	private DevolucionXProductoDAOI devolucionXProductoDAO;
	
	@Autowired
	private EstadoProductoDAOI estadoProductoDAO;
	
	@Autowired
	private InventarioBO inventarioBO;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private AsistenciaXSalaDAOI asistenciaXSalaDAO;

	
	public TicketVentaVO getTicketVenta(Integer idTicket) {

		return TicketVentaAssembler.getTicketVentaVO(ticketVentaDAO.getById(idTicket));
	}
	
	public TicketVentaVO getTicketVenta(Integer idCine, Integer idTicket, String clavePuntoVenta) {
		
		clavePuntoVenta = clavePuntoVenta == null ? "":clavePuntoVenta;
		if(clavePuntoVenta.equals("")){
			return null;
		}
		
		TicketVenta ticketVenta =null;
		
		if(clavePuntoVenta.equals(PuntoVentaType.TAQUILLA.getType())){
			ticketVenta = ticketVentaDAO.findByCineOfTaquilla(idCine, idTicket);
		}
		
		if(clavePuntoVenta.equals(PuntoVentaType.DULCERIA.getType())){
			ticketVenta = ticketVentaDAO.findByCineOfDulceria(idCine, idTicket);			
		}
				
		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

	public TicketVentaBoletoVO getTicketVentaBoletos(Integer idCine, Integer idTicket) {
		//TipoPuntoVenta tipoPuntoVenta = TipoPuntoVentaDAO.findByClave(PuntoVentaType.TAQUILLA.getType());
		//if (tipoPuntoVenta == null) {
			//return null;
		//}
		return TicketVentaAssembler.getTicketVentaBoletoVO(
				ticketVentaDAO.findByCineOfTaquilla(idCine, idTicket));
	}

	public TicketVentaProductoVO getTicketVentaProductos(Integer idCine, Integer idTicket) {
		
		//TipoPuntoVenta tipoPuntoVenta = TipoPuntoVentaDAO.findByClave(PuntoVentaType.DULCERIA.getType());

		//if (tipoPuntoVenta == null) {
			//return null;
		//}

		TicketVenta ticketVenta= ticketVentaDAO.findByCineOfDulceria(idCine, idTicket);
		
		if (ticketVenta==null){
			return null;	
		}
		
		List<PaquetesXTicket> paquetesXTicket= paqueteXTicketDAO.findByTicket(idTicket, null);
				
		List<ProductosXTicket> productosXTicket= productoXTicketDAO.findByTicket(idTicket, null);
		
		TicketVentaProductoVO ticketVentaProductoVO =TicketVentaAssembler.getTicketVentaProductoVO(ticketVenta, paquetesXTicket, productosXTicket);
		
		List<DevolucionXProducto> devolucionesXProducto = devolucionXProductoDAO.findByTicket(idTicket);
		Map<String, EstadoProducto> mapDevolucionXProducto = new HashMap<String, EstadoProducto>();
		
		for (DevolucionXProducto devolucionXProducto : devolucionesXProducto) {
			mapDevolucionXProducto.put(devolucionXProducto.getClave(), devolucionXProducto.getEstadoProducto());
		}
		
		int i=0;
		for (PaqueteXTicketVO paqueteXTicketVO : ticketVentaProductoVO.getPaquetesXTicketVO()) {
			paqueteXTicketVO.setId(++i);
			
			for (ProductoXPaqueteVO productoXPaqueteVO : paqueteXTicketVO.getPaqueteVO().getProductosXPaqueteVO()) {
				String key=String.valueOf(idTicket)+String.valueOf(paqueteXTicketVO.getId())+String.valueOf(productoXPaqueteVO.getProductoVO().getIdProducto());
				EstadoProducto estadoProducto= mapDevolucionXProducto.get(key);
				if (estadoProducto!=null){
					boolean estado=estadoProducto.getClave().equals(EstadoProductoType.BUENO.getType())?true:false;
					productoXPaqueteVO.getProductoVO().setEstado(estado);
					productoXPaqueteVO.getProductoVO().setSelected(true);
				}
			}
			
		}
		
		
		return ticketVentaProductoVO;
	}

	@Transactional(readOnly=false)
	public DevolucionResponseVO createDevolucionBoleto(Integer idUsuario, DevolucionBoletoVO devolucionBoletoVO) {

		boolean cortesia = DevolucionType.CORTESIA_BOL.getType().equals(devolucionBoletoVO.getTipoDevolucionVO().getClave()) ? true : false;
		EstatusPago estatusPago = estatusPagoDAO.findByClave(EstatusPagoType.DEVUELTO.getType());
		FormaPago formaPago = formaPagoDAO.findByClave(FormaPagoType.EFECTIVO.getType());

		if (estatusPago == null || formaPago == null) {
			return null;
		}

		TicketVenta ticketVenta = ticketVentaDAO.getById(devolucionBoletoVO.getIdTicketVenta());

		for (BoletosXTicket boletosXTicket : ticketVenta.getBoletosXTickets()) {
			boletosXTicket.setActivo(false);
			boletoXTicketDAO.update(boletosXTicket);
		}

		if (DevolucionType.EFECTIVO_BOL.getType().equals(devolucionBoletoVO.getTipoDevolucionVO().getClave())) {
			pagoDAO.save(PagoAssembler.getPago(ticketVenta, estatusPago, formaPago, null));
		}

		Devolucion devolucion = DevolucionAssembler.getDevolucion(devolucionBoletoVO, idUsuario);
		devolucionDAO.save(devolucion);
		
		//liberamos los asientos
		this.asistenciaXSalaDAO.borrarPorTicket(devolucionBoletoVO.getIdTicketVenta());

		return DevolucionAssembler.getDevolucionResponseVO(devolucion, cortesia);

	}

	public List<ArchivoPdfVO> generarCortesiaPdf(Integer idUsuario, Integer idTicket, Integer idDevolucion)
			throws BusinessGlobalException {
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaCortesiaJasper = cfg.getString("devolucion.ticket.cortesia.jasper");
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DDMMYYYYHHMMSSSSS);
		List<ArchivoPdfVO> archivosPdfVO = new ArrayList<ArchivoPdfVO>();

		Cine cine = cineDAO.getById(idUsuario);
		TicketVenta ticketVenta = ticketVentaDAO.getById(idTicket);

		List<DetalleTicketPdfVO> detallesTicketPdfVO = BoletoXTicketAssembler.getDetallesTicketPdfVO(ticketVenta.getBoletosXTickets());

		if (ticketVenta.getPromocionesXTickets() != null && !ticketVenta.getPromocionesXTickets().isEmpty()) {
			detallesTicketPdfVO.addAll(PromocionXTicketAssembler.getDetallesTicketPdfVO(ticketVenta.getPromocionesXTickets()));
		}

		CortesiaPdfVO cortesiaPdfVO = CortesiaAssembler.getCortesiaPdfVO(cine, ticketVenta, idDevolucion);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("logo", new ByteArrayInputStream(cine.getEmpresa().getIcono()));
		parameters.put("razonSocial", cortesiaPdfVO.getRazonSocial());
		parameters.put("nombreCine", cortesiaPdfVO.getNombreCine());
		parameters.put("direccionCine", cortesiaPdfVO.getDireccion());
		parameters.put("rfc", cortesiaPdfVO.getRfc());
		parameters.put("telefono", cortesiaPdfVO.getTelefono());
		parameters.put("fechaHoraCompra", cortesiaPdfVO.getFechaHoraCompra());
		parameters.put("ordenCompra", cortesiaPdfVO.getNumeroOrdenTicket().toString());
		parameters.put("totalPago", cortesiaPdfVO.getTotalPago());
		parameters.put("leyenda", cortesiaPdfVO.getLeyenda());
		parameters.put("slogan", cortesiaPdfVO.getSlogan());
		parameters.put("sugerencias", cortesiaPdfVO.getSugerencias());
		parameters.put("agradeciemiento", cortesiaPdfVO.getAgradeciemiento());
		parameters.put("folioDevolucion", cortesiaPdfVO.getFolioDevolucion());

		JRBeanCollectionDataSource venta = new JRBeanCollectionDataSource(detallesTicketPdfVO);
		parameters.put("recordDataSource", venta);

		try {
			ArchivoPdfVO archivoPdfVO = new ArchivoPdfVO(Constantes.CORTESIA);
			String rutaArchivoBoleto = context.getRealPath(rutaCortesiaJasper);
			archivoPdfVO.setArchivo(
					JasperRunManager.runReportToPdf(rutaArchivoBoleto, parameters, new JREmptyDataSource()));
			archivosPdfVO.add(archivoPdfVO);
		} catch (JRException e) {
			e.printStackTrace();
			logger.error("Error al generar pdf para la cortesia [{}]", idDevolucion);
		}

		return archivosPdfVO;
	}

	public DevolucionResponseVO createDevolucionProducto(Integer idUsuario, Integer idCine, DevolucionProductoVO devolucionProductoVO) throws BusinessGlobalException {
		Cine cine = cineDAO.findById(idCine);
		TipoMovimientoInv devolucionClienteIn = tipoMovimientoInvDAO.findByClave(MovimientoInvType.DEVOLUCION_CLIENTE_IN.getType());
		TipoMovimientoInv cortesiaOut = tipoMovimientoInvDAO.findByClave(MovimientoInvType.CORTESIA_OUT.getType());
		TipoMovimientoInv mermaOut = tipoMovimientoInvDAO.findByClave(MovimientoInvType.MERMA_OUT.getType());
		String tipoDevClave=devolucionProductoVO.getTipoDevolucionVO().getClave();
		Autorizacion autorizacion = AutorizacionAssembler.getAutorizacion(devolucionProductoVO.getIdAutorizacion());
		EstadoProducto estadoProductoBueno=estadoProductoDAO.findByClave(EstadoProductoType.BUENO.getType());
		EstadoProducto estadoProductoDaniado=estadoProductoDAO.findByClave(EstadoProductoType.DANIADO.getType());
				
		Map<Integer, ProductoVO> mapProductoBueno = new HashMap<Integer, ProductoVO>();
		Map<Integer, ProductoVO> mapProductoDanado = new HashMap<Integer, ProductoVO>();

		for (PaqueteXTicketVO paqueteXTicketVO : devolucionProductoVO.getPaquetesXTicketVO()) {

			for (ProductoXPaqueteVO productoXPaqueteVO : paqueteXTicketVO.getPaqueteVO().getProductosXPaqueteVO()) {
				Integer pruductoKey = productoXPaqueteVO.getProductoVO().getIdProducto();

				if (productoXPaqueteVO.getProductoVO().isSelected() && productoXPaqueteVO.getProductoVO().isEstado()==true) {

					if (!mapProductoBueno.containsKey(pruductoKey)) {
						productoXPaqueteVO.getProductoVO().setCantidad(0);
						mapProductoBueno.put(pruductoKey, productoXPaqueteVO.getProductoVO());
					}

					ProductoVO productoBuenoVO = mapProductoBueno.get(pruductoKey);
					productoBuenoVO.setCantidad(productoBuenoVO.getCantidad() + (int)productoXPaqueteVO.getCantidad());
				}

				if (productoXPaqueteVO.getProductoVO().isSelected() && productoXPaqueteVO.getProductoVO().isEstado()==false) {

					if (!mapProductoDanado.containsKey(pruductoKey)) {
						productoXPaqueteVO.getProductoVO().setCantidad(0);
						mapProductoDanado.put(pruductoKey, productoXPaqueteVO.getProductoVO());
					}

					ProductoVO productoDaniadoVO = mapProductoDanado.get(pruductoKey);
					productoDaniadoVO.setCantidad(productoDaniadoVO.getCantidad() + (int)productoXPaqueteVO.getCantidad());

				}
				
			}
		}

		for (Map.Entry<Integer, ProductoVO> entry : mapProductoBueno.entrySet()) {

			ProductoVO productoVO = entry.getValue();

			for (ArticuloXProductoVO articuloXProductoVO : productoVO.getArticulosXProductosVO()) {

				MovimientoInventario movInventarioActual = movimientoInventarioDAO.getLastMovement(cine.getIdCine(),
						articuloXProductoVO.getArticuloVO().getIdArticulo());

				long cantidad = articuloXProductoVO.getCantidad() * productoVO.getCantidad();
//				long existenciaActual = movInventarioActual.getExistenciaActual() + cantidad;
//				BigDecimal importe = new BigDecimal(0);
//				importe = importe.add(movInventarioActual.getImporte());
//				importe = importe.divide(new BigDecimal(movInventarioActual.getCantidad()), 3,
//						BigDecimal.ROUND_HALF_EVEN);
//				importe = importe.multiply(new BigDecimal(cantidad));

				// Moviminento entrada
				ParametrosInventarioVO inventarioInVO= new ParametrosInventarioVO();
				// AGUAS CON ESTE inventarioInVO.setIdProducto(articuloXProductoVO.getArticuloVO().getIdArticulo());
				inventarioInVO.setCantidad((int) cantidad);
				inventarioInVO.setIdTipoMovimiento(devolucionClienteIn.getIdTipoMovimientoInv());
				inventarioInVO.setClaveTipoMovimiento(devolucionClienteIn.getClave());
				inventarioInVO.setIdAutorizacion(devolucionProductoVO.getIdAutorizacion());
				
				inventarioBO.createEntradaAjuste(inventarioInVO, cine.getIdCine(), devolucionProductoVO.getIdPuntoVenta(), idUsuario);
				
//				MovimientoInventario movimientoDevClienteIn = MovimientoInventarioAssembler.getMovimientoInventario(
//						articuloXProductoVO.getArticuloVO().getIdArticulo(), movInventarioActual.getProveedor(),
//						devolucionClienteIn, idUsuario, cantidad, importe, existenciaActual, null, null);
//				movimientoInventarioDAO.save(movimientoDevClienteIn);
//
//				AutorizacionMovimiento autorizacionDevClienteIn = AutorizacionMovimientoAssembler
//						.getAutorizacionMovimiento(movimientoDevClienteIn, autorizacion);
//				autorizacionMovimientoDAO.save(autorizacionDevClienteIn);

				// Moviminento Salida
				if (DevolucionType.PRODUCTO_PRO.getType().equals(tipoDevClave)) {
					//existenciaActual = movInventarioActual.getExistenciaActual() - cantidad;
					
					ParametrosInventarioVO inventarioCortesiaOutVO= new ParametrosInventarioVO();
					// AGUAS CON ESTE inventarioCortesiaOutVO.setIdArticulo(articuloXProductoVO.getArticuloVO().getIdArticulo());
					inventarioCortesiaOutVO.setCantidad((int) cantidad);
					inventarioCortesiaOutVO.setIdTipoMovimiento(cortesiaOut.getIdTipoMovimientoInv());
					inventarioCortesiaOutVO.setClaveTipoMovimiento(cortesiaOut.getClave());
					inventarioCortesiaOutVO.setIdAutorizacion(devolucionProductoVO.getIdAutorizacion());
					
				//-	inventarioBO.createSalida(inventarioCortesiaOutVO, cine.getIdCine(), devolucionProductoVO.getIdPuntoVenta(), idUsuario);
					
//					MovimientoInventario movimientoCortesiaOut = MovimientoInventarioAssembler.getMovimientoInventario(
//							articuloXProductoVO.getArticuloVO().getIdArticulo(), movInventarioActual.getProveedor(),
//							cortesiaOut, idUsuario, cantidad, importe, existenciaActual, null, null);
//					movimientoInventarioDAO.save(movimientoCortesiaOut);
//					AutorizacionMovimiento autorizacionCortesiaOut = AutorizacionMovimientoAssembler
//							.getAutorizacionMovimiento(movimientoCortesiaOut, autorizacion);
//					autorizacionMovimientoDAO.save(autorizacionCortesiaOut);
				}
			}

		}

		for (Map.Entry<Integer, ProductoVO> entry : mapProductoDanado.entrySet()) {

			ProductoVO productoVO = entry.getValue();

			for (ArticuloXProductoVO articuloXProductoVO : productoVO.getArticulosXProductosVO()) {

				MovimientoInventario movInventarioActual = movimientoInventarioDAO.getLastMovement(cine.getIdCine(),
						articuloXProductoVO.getArticuloVO().getIdArticulo());

				long cantidad = articuloXProductoVO.getCantidad() * productoVO.getCantidad();
				long existenciaActual = movInventarioActual.getExistenciaActual() + cantidad;
//				BigDecimal importe = new BigDecimal(0);
//				importe = importe.add(movInventarioActual.getImporte());
//				importe = importe.divide(new BigDecimal(movInventarioActual.getCantidad()), 3,
//						BigDecimal.ROUND_HALF_EVEN);
//				importe = importe.multiply(new BigDecimal(cantidad));

				// Moviminento entrada
//				MovimientoInventario movimientoDevClienteIn = MovimientoInventarioAssembler.getMovimientoInventario(
//						articuloXProductoVO.getArticuloVO().getIdArticulo(), movInventarioActual.getProveedor(),
//						devolucionClienteIn, idUsuario, cantidad, importe, existenciaActual, null, null);
//				movimientoInventarioDAO.save(movimientoDevClienteIn);
//
//				AutorizacionMovimiento autorizacionDevClienteIn = AutorizacionMovimientoAssembler
//						.getAutorizacionMovimiento(movimientoDevClienteIn, autorizacion);
//				autorizacionMovimientoDAO.save(autorizacionDevClienteIn);
				
				ParametrosInventarioVO inventarioInVO= new ParametrosInventarioVO();
				// AGUAS CON ESTE inventarioInVO.setIdArticulo(articuloXProductoVO.getArticuloVO().getIdArticulo());
				inventarioInVO.setCantidad((int) cantidad);
				inventarioInVO.setIdTipoMovimiento(devolucionClienteIn.getIdTipoMovimientoInv());
				inventarioInVO.setClaveTipoMovimiento(devolucionClienteIn.getClave());
				inventarioInVO.setIdAutorizacion(devolucionProductoVO.getIdAutorizacion());
				
				inventarioBO.createEntradaAjuste(inventarioInVO, cine.getIdCine(), devolucionProductoVO.getIdPuntoVenta(), idUsuario);
				
				// Moviminento merma
				existenciaActual = movInventarioActual.getExistenciaActual()-cantidad;
//				MovimientoInventario movimientoMermaOut = MovimientoInventarioAssembler.getMovimientoInventario(
//						articuloXProductoVO.getArticuloVO().getIdArticulo(), movInventarioActual.getProveedor(), mermaOut, 
//						idUsuario, cantidad, importe, existenciaActual , null, null);
//				movimientoInventarioDAO.save(movimientoMermaOut);
//				AutorizacionMovimiento autorizacionMermaOut= AutorizacionMovimientoAssembler.getAutorizacionMovimiento(
//						movimientoMermaOut, autorizacion);
//				autorizacionMovimientoDAO.save(autorizacionMermaOut);
				
				ParametrosInventarioVO inventarioMermaOutVO= new ParametrosInventarioVO();
				// AGUAS CON ESTE inventarioMermaOutVO.setIdArticulo(articuloXProductoVO.getArticuloVO().getIdArticulo());
				inventarioMermaOutVO.setCantidad((int) cantidad);
				inventarioMermaOutVO.setIdTipoMovimiento(mermaOut.getIdTipoMovimientoInv());
				inventarioMermaOutVO.setClaveTipoMovimiento(mermaOut.getClave());
				inventarioMermaOutVO.setIdAutorizacion(devolucionProductoVO.getIdAutorizacion());
				
				//-inventarioBO.createSalida(inventarioMermaOutVO, cine.getIdCine(), devolucionProductoVO.getIdPuntoVenta(), idUsuario);
				
				
				// Moviminento Salida
				if (DevolucionType.PRODUCTO_PRO.getType().equals(tipoDevClave)) {
					existenciaActual = movInventarioActual.getExistenciaActual() - cantidad;
//					MovimientoInventario movimientoCortesiaOut = MovimientoInventarioAssembler.getMovimientoInventario(
//							articuloXProductoVO.getArticuloVO().getIdArticulo(), movInventarioActual.getProveedor(),
//							cortesiaOut, idUsuario, cantidad, importe, existenciaActual, null, null);
//					movimientoInventarioDAO.save(movimientoCortesiaOut);
//					AutorizacionMovimiento autorizacionCortesiaOut = AutorizacionMovimientoAssembler
//							.getAutorizacionMovimiento(movimientoCortesiaOut, autorizacion);
//					autorizacionMovimientoDAO.save(autorizacionCortesiaOut);
					
					ParametrosInventarioVO inventarioCortesiaOutVO= new ParametrosInventarioVO();
					// AGUAS CON ESTE inventarioCortesiaOutVO.setIdArticulo(articuloXProductoVO.getArticuloVO().getIdArticulo());
					inventarioCortesiaOutVO.setCantidad((int) cantidad);
					inventarioCortesiaOutVO.setIdTipoMovimiento(cortesiaOut.getIdTipoMovimientoInv());
					inventarioCortesiaOutVO.setClaveTipoMovimiento(cortesiaOut.getClave());
					inventarioCortesiaOutVO.setIdAutorizacion(devolucionProductoVO.getIdAutorizacion());
					
					//-inventarioBO.createSalida(inventarioCortesiaOutVO, cine.getIdCine(), devolucionProductoVO.getIdPuntoVenta(), idUsuario);
				}
			}

		}
		
		if (DevolucionType.EFECTIVO_PRO.getType().equals(tipoDevClave)){
			TicketVenta ticketVenta = ticketVentaDAO.getById(devolucionProductoVO.getIdTicketVenta());
			FormaPago formaPago = formaPagoDAO.findByClave(FormaPagoType.EFECTIVO.getType());
			EstatusPago estatusPago = estatusPagoDAO.findByClave(EstatusPagoType.DEVUELTO.getType());
			pagoDAO.save(PagoAssembler.getPago(ticketVenta, estatusPago, formaPago, devolucionProductoVO.getImporte()));
		}
		
		Devolucion devolucion = DevolucionAssembler.getDevolucion(devolucionProductoVO, idUsuario);
		devolucionDAO.save(devolucion);
		
		
		for (PaqueteXTicketVO paqueteXTicketVO : devolucionProductoVO.getPaquetesXTicketVO()) {
			
			for (ProductoXPaqueteVO  productoXPaqueteVO : paqueteXTicketVO.getPaqueteVO().getProductosXPaqueteVO()) {
				
				if (productoXPaqueteVO.getProductoVO().isSelected()){
					EstadoProducto estadoProducto = (productoXPaqueteVO.getProductoVO().isEstado()?estadoProductoBueno:estadoProductoDaniado);
					devolucionXProductoDAO.save(DevolucionXProductoAssembler.getDevolucionXProducto(devolucion,estadoProducto,
							devolucionProductoVO.getIdTicketVenta(), paqueteXTicketVO.getId(),productoXPaqueteVO.getProductoVO().getIdProducto()));
				}

			} 

		}
		
		return DevolucionAssembler.getDevolucionResponseVO(devolucion, false);

	}

}
