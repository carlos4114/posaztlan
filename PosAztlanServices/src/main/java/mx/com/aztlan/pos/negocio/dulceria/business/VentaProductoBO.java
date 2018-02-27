package mx.com.aztlan.pos.negocio.dulceria.business;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ArticuloDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.CineDAO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestoXProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestosXTicketPaqueteDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ImpuestosXTicketProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MovimientoInventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PagoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.PaqueteXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoXPuntoVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TicketVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoMovimientoInvDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Articulo;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Cine;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestoXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestosXTicketPaquete;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ImpuestosXTicketProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.MovimientoInventario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Pago;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PaquetesXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXPuntoVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ProductosXTicket;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TicketVenta;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoMovimientoInv;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ArticuloExistenciaVO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.dulceria.assembler.ImpuestoXTicketPaqueteAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.ImpuestosXTicketProductoAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.PagoAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.PaqueteAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.PaqueteXTicketAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.ProductoXTicketAssembler;
import mx.com.aztlan.pos.negocio.dulceria.assembler.TicketVentaAssembler;
import mx.com.aztlan.pos.negocio.dulceria.vo.ArchivoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ArticuloXProductoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetalleImpuestoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetallePagoPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.DetalleTicketPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteAgotadoVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.PaqueteVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ProductoExistenciaVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.ProductoXPaqueteVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TicketPdfVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.TicketVentaVO;
import mx.com.aztlan.pos.negocio.dulceria.vo.VentaVO;
import mx.com.aztlan.pos.negocio.inventarios.business.InventarioBO;
import mx.com.aztlan.pos.negocio.inventarios.vo.ParametrosInventarioVO;
import mx.com.aztlan.pos.servicios.util.Constantes;
import mx.com.aztlan.pos.servicios.util.MovimientoInvType;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class VentaProductoBO {
	private static final Logger logger = LoggerFactory.getLogger(VentaProductoBO.class);

	@Autowired
	private PaqueteXPuntoVentaDAOI paqueteXPuntoVentaDAO;

	@Autowired
	private ProductoXPuntoVentaDAOI productoXPuntoVentaDAO;

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PaqueteXTicketDAOI paqueteXTicketDAO;

	@Autowired
	private ProductoXTicketDAOI productoXTicketDAO;

	@Autowired
	private ImpuestoXProductoDAOI impuestoXProductoDAO;

	@Autowired
	private ImpuestosXTicketProductoDAOI impuestosXTicketProductoDAO;

	@Autowired
	private ImpuestosXTicketPaqueteDAOI impuestosXTicketPaqueteDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private TipoMovimientoInvDAOI tipoMovimientoInvDAO;

	@Autowired
	private CineDAO cineDAO;

	@Autowired
	private ArticuloDAO articuloDAO;

	@Autowired
	private InventarioBO inventarioBO;

	@Autowired
	private ServletContext context;

	public List<PaqueteVO> getPaquetes(Integer idPuntoVenta) throws BusinessGlobalException {

		List<PaqueteVO> paquetesVO = new ArrayList<PaqueteVO>();
		List<PaquetesXPuntoVenta> paquetesXPuntoVenta = paqueteXPuntoVentaDAO.findByPuntoVenta(idPuntoVenta);
		List<ProductosXPuntoVenta> productosXPuntoVenta = productoXPuntoVentaDAO.findByPuntoVenta(idPuntoVenta);

		if (paquetesXPuntoVenta != null && !paquetesXPuntoVenta.isEmpty()) {
			paquetesVO.addAll(PaqueteAssembler.getPaquetesVO(paquetesXPuntoVenta));
		}

		if (productosXPuntoVenta != null && !productosXPuntoVenta.isEmpty()) {
			paquetesVO.addAll(PaqueteAssembler.getPaquetesVOXProducto(productosXPuntoVenta));
		}

		Map<Integer, Articulo> mapArticulosDisp = new HashMap<Integer, Articulo>();
		List<ArticuloExistenciaVO> articulosExistenciaVO = articuloDAO.getDisponible(idPuntoVenta);
		
		for (ArticuloExistenciaVO articuloExistenciaVO : articulosExistenciaVO){
			mapArticulosDisp.put(articuloExistenciaVO.getArticulo().getIdArticulo(), articuloExistenciaVO.getArticulo());
		}

		
		Map<Integer, Producto> mapProductosAgotados = new HashMap<Integer, Producto>();

		for (ProductosXPuntoVenta productoXPuntoVenta : productosXPuntoVenta) {
			for (ArticulosXProducto articuloXProducto : productoXPuntoVenta.getProducto().getArticulosXProductos()) {
				if (!mapArticulosDisp.containsKey(articuloXProducto.getArticulo().getIdArticulo())) {
					mapProductosAgotados.put(productoXPuntoVenta.getProducto().getIdProducto(),
							productoXPuntoVenta.getProducto());
				}
			}
		}

		for (PaqueteVO paqueteVO : paquetesVO) {
			for (ProductoXPaqueteVO productoXPaqueteVO : paqueteVO.getProductosXPaqueteVO()) {
				if (mapProductosAgotados.containsKey(productoXPaqueteVO.getProductoVO().getIdProducto())) {
					paqueteVO.setDeshabilitado(true);
				}
			}
		}

		return paquetesVO;

	}

	public PaqueteAgotadoVO validarPaquete(List<PaqueteVO> paquetesVO, Integer idPuntoVenta) {
		Map<Integer, ArticuloExistenciaVO> mapArticulosDisponibles = new HashMap<Integer, ArticuloExistenciaVO>();
		Map<Integer, ProductoExistenciaVO> mapProductosXVender = new HashMap<Integer, ProductoExistenciaVO>();
		List<ProductoExistenciaVO> productosExistenciaVO= new  ArrayList<ProductoExistenciaVO>();
		PaqueteAgotadoVO paqueteAgotadoVO = new PaqueteAgotadoVO();
		paqueteAgotadoVO.setProductosExistenciaVO(productosExistenciaVO);
		
		
		List<ArticuloExistenciaVO> articulosExistenciaVO = articuloDAO.getDisponible(idPuntoVenta);
		
		for (ArticuloExistenciaVO articuloExistenciaVO : articulosExistenciaVO){
			mapArticulosDisponibles.put(articuloExistenciaVO.getArticulo().getIdArticulo(), articuloExistenciaVO);
		}
		
		for (PaqueteVO paqueteVO : paquetesVO) {
			for (ProductoXPaqueteVO productosXPaqueteVO : paqueteVO.getProductosXPaqueteVO()) {
				
				if (!mapProductosXVender.containsKey(productosXPaqueteVO.getProductoVO().getIdProducto())) {
					ProductoExistenciaVO  productoExistenciaVO = new ProductoExistenciaVO();
					productoExistenciaVO.setProductoVO(productosXPaqueteVO.getProductoVO());
					productoExistenciaVO.setSeleccionado(0);
					mapProductosXVender.put(productosXPaqueteVO.getProductoVO().getIdProducto(), productoExistenciaVO );
				}
				
				ProductoExistenciaVO productoExistenciaVO = mapProductosXVender.get(productosXPaqueteVO.getProductoVO().getIdProducto());
				productoExistenciaVO.setSeleccionado(productoExistenciaVO.getSeleccionado() + (paqueteVO.getCantidad()* productosXPaqueteVO.getCantidad() ));
				mapProductosXVender.put(productosXPaqueteVO.getProductoVO().getIdProducto(), productoExistenciaVO);

			}
			
		}
		
		for(Map.Entry<Integer, ProductoExistenciaVO> entry : mapProductosXVender.entrySet()) {
			ProductoExistenciaVO productoExistenciaVO =entry.getValue();
			for (ArticuloXProductoVO articuloXProductoVO : productoExistenciaVO.getProductoVO().getArticulosXProductosVO()) {
				
				ArticuloExistenciaVO articuloExistenciaVO =mapArticulosDisponibles.get(articuloXProductoVO.getArticuloVO().getIdArticulo());
				
				long existencia= articuloExistenciaVO !=null ? articuloExistenciaVO.getExistencia(): 0  / articuloXProductoVO.getCantidad();
				
				if ((productoExistenciaVO.getExistencia() == 0 && existencia > 0) || productoExistenciaVO.getExistencia() > existencia ){
					productoExistenciaVO.setExistencia(existencia);
				}

			}
			
			if (productoExistenciaVO.getSeleccionado() > productoExistenciaVO.getExistencia()){
				paqueteAgotadoVO.setAgotado(true);
				productosExistenciaVO.add(productoExistenciaVO);
			}
			logger.info("<<<<<< {} {}", productoExistenciaVO.getProductoVO().getNombre(), productoExistenciaVO.getExistencia());
			
		}
		
		
		
		return  paqueteAgotadoVO;
	}

	
	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {
		BigDecimal total = new BigDecimal(0);
		BigDecimal subtotal = new BigDecimal(0);
		BigDecimal descuento = new BigDecimal(0);
		BigDecimal importeImpuestos = new BigDecimal(0);
		Map<Integer, MovimientoInventario> mapMovimientoInventario = new HashMap<Integer, MovimientoInventario>();

		for (PaqueteVO paqueteVO : ventaVO.getPaquetesVO()) {
			total = total.add(paqueteVO.getImporte());
			for (ProductoXPaqueteVO productoXPaqueteVO : paqueteVO.getProductosXPaqueteVO()) {

				for (ArticuloXProductoVO articuloXProductoVO : productoXPaqueteVO.getProductoVO()
						.getArticulosXProductosVO()) {

					Integer articuloKey = articuloXProductoVO.getArticuloVO().getIdArticulo();

					if (!mapMovimientoInventario.containsKey(articuloKey)) {

						MovimientoInventario movimientoInventario = new MovimientoInventario();
						mapMovimientoInventario.put(articuloKey, movimientoInventario);

					}

					MovimientoInventario movimientoInventario = mapMovimientoInventario.get(articuloKey);
					movimientoInventario.setCantidad(movimientoInventario.getCantidad() + (articuloXProductoVO.getCantidad()
									* productoXPaqueteVO.getCantidad() * paqueteVO.getCantidad()));

				}
			}
		}

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getIdUsuario(),
				ventaVO.getIdPuntoVenta(), ventaVO.getIdCaja(), descuento, subtotal, total));

		List<PaquetesXTicket> paquetesXTicket = PaqueteXTicketAssembler.getPaquetesXTicket(ventaVO.getPaquetesVO(),
				ticketVenta);

		List<ProductosXTicket> productosXTicket = ProductoXTicketAssembler.getProductosXTicket(ventaVO.getPaquetesVO(),
				ticketVenta);

		for (ProductosXTicket productoXTicket : productosXTicket) {

			List<ImpuestoXProducto> impuestosXProducto = impuestoXProductoDAO
					.findByIdCineAndIdProducto(ventaVO.getIdCine(), productoXTicket.getProducto().getIdProducto());

			for (ImpuestoXProducto impuestoXProducto : impuestosXProducto) {

				BigDecimal xcientoImpProducto = new BigDecimal(0);
				xcientoImpProducto = xcientoImpProducto.add(impuestoXProducto.getPorcentaje());
				xcientoImpProducto = xcientoImpProducto.divide(new BigDecimal(Constantes.CIEN));
				xcientoImpProducto = xcientoImpProducto.add(new BigDecimal(Constantes.UNO));

				BigDecimal subtotalProducto = new BigDecimal(0);
				subtotalProducto = subtotalProducto.add(productoXTicket.getImporte());
				subtotalProducto = subtotalProducto.divide(xcientoImpProducto, 3, BigDecimal.ROUND_HALF_EVEN);

				BigDecimal importeImpProducto = new BigDecimal(0);
				importeImpProducto = importeImpProducto.add(productoXTicket.getImporte());
				importeImpProducto = importeImpProducto.subtract(subtotalProducto);

				importeImpuestos = importeImpuestos.add(importeImpProducto);

				ImpuestosXTicketProducto impuestoXTicketProducto = ImpuestosXTicketProductoAssembler
						.getImpuestosXTicketProducto(ticketVenta, impuestoXProducto, importeImpProducto);

				impuestosXTicketProductoDAO.save(impuestoXTicketProducto);
			}

			productoXTicketDAO.save(productoXTicket);
		}

		for (PaquetesXTicket paqueteXTicket : paquetesXTicket) {
			BigDecimal xcientoImpPaquete = new BigDecimal(Constantes.IMPUESTO_PAQUETE);
			xcientoImpPaquete = xcientoImpPaquete.divide(new BigDecimal(Constantes.CIEN));
			xcientoImpPaquete = xcientoImpPaquete.add(new BigDecimal(Constantes.UNO));

			BigDecimal subtotalPaquete = new BigDecimal(0);
			subtotalPaquete = subtotalPaquete.add(paqueteXTicket.getImporte());
			subtotalPaquete = subtotalPaquete.divide(xcientoImpPaquete, 3, BigDecimal.ROUND_HALF_EVEN);

			BigDecimal importeImpPaquete = new BigDecimal(0);
			importeImpPaquete = importeImpPaquete.add(paqueteXTicket.getImporte());
			importeImpPaquete = importeImpPaquete.subtract(subtotalPaquete);

			importeImpuestos = importeImpuestos.add(importeImpPaquete);

			ImpuestosXTicketPaquete impuestosXTicketPaquete = ImpuestoXTicketPaqueteAssembler.getImpuestoXTicketPaquete(
					ticketVenta, importeImpPaquete, new BigDecimal(Constantes.IMPUESTO_PAQUETE));
			impuestosXTicketPaqueteDAO.save(impuestosXTicketPaquete);

			paqueteXTicketDAO.save(paqueteXTicket);
		}

		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO(), ticketVenta);
		for (Pago pago : pagos) {
			pagoDAO.save(pago);
		}

		TipoMovimientoInv tipoMovimientoInvOut = tipoMovimientoInvDAO
				.findByClave(MovimientoInvType.VENTA_OUT.getType());

		for (Entry<Integer, MovimientoInventario> entryMovInventario : mapMovimientoInventario.entrySet()) {

			// MovimientoInventario movInventarioActual =
			// movimientoInventarioDAO.getLastMovement(
			// ventaVO.getIdCine(), entryMovInventario.getKey());
			//
			// BigDecimal importe = new BigDecimal(0);
			// importe = importe.add(movInventarioActual.getImporte());
			// importe = importe.divide(new
			// BigDecimal(movInventarioActual.getCantidad()), 3,
			// BigDecimal.ROUND_HALF_EVEN);
			// importe = importe.multiply(new
			// BigDecimal(entryMovInventario.getValue().getCantidad()));
			//
			// long existenciaActual = movInventarioActual.getExistenciaActual()
			// - entryMovInventario.getValue().getCantidad();

			// movimientoInventarioDAO.save(MovimientoInventarioAssembler.getMovimientoInventario(
			// entryMovInventario.getKey(), movInventarioActual.getProveedor(),
			// tipoMovimientoInvOut,
			// ventaVO.getIdUsuario(),
			// entryMovInventario.getValue().getCantidad(), importe,
			// existenciaActual,ventaVO.getIdPuntoVenta(),
			// ventaVO.getIdPuntoVenta(),null));

			ParametrosInventarioVO inventarioVO = new ParametrosInventarioVO();
			inventarioVO.setIdArticulo(entryMovInventario.getKey());
			inventarioVO.setCantidad((int) entryMovInventario.getValue().getCantidad());
			inventarioVO.setIdTipoMovimiento(tipoMovimientoInvOut.getIdTipoMovimientoInv());
			inventarioVO.setClaveTipoMovimiento(tipoMovimientoInvOut.getClave());

			inventarioBO.createSalida(inventarioVO, ventaVO.getIdCine(), ventaVO.getIdPuntoVenta(),
					ventaVO.getIdUsuario());
		}

		subtotal = subtotal.add(total);
		subtotal = subtotal.subtract(importeImpuestos);
		ticketVenta.setImporte(subtotal);
		ticketVentaDAO.update(ticketVenta);

		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

	public List<ArchivoPdfVO> generarTicketPdf(Integer idTicket, BigDecimal pagoCon,
			BigDecimal cambio, Integer idCine) throws BusinessGlobalException {
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaJasper = cfg.getString("dulceria.ticket.jasper");
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DDMMYYYYHHMMSSSSS);
		String fecha = sdf.format(new Date());
		List<ArchivoPdfVO> archivosPdfVO = new ArrayList<ArchivoPdfVO>();

		pagoCon = pagoCon.setScale(2, RoundingMode.CEILING);
		cambio = cambio.setScale(2, RoundingMode.CEILING);

		Cine cine = cineDAO.findById(idCine);
		TicketVenta ticketVenta = ticketVentaDAO.findById(idTicket);
		List<Pago> pagos = pagoDAO.findByTicketAndCta(idTicket);

		TicketPdfVO ticketPdfVO = TicketVentaAssembler.getTicketPdfVO(cine, ticketVenta, pagoCon, cambio);

		List<DetalleTicketPdfVO> detallesTicketPdfVO = new ArrayList<DetalleTicketPdfVO>();

		if (ticketVenta.getPaquetesXTickets() != null && !ticketVenta.getPaquetesXTickets().isEmpty()) {
			detallesTicketPdfVO.addAll(PaqueteXTicketAssembler.getDetallesTicketVO(ticketVenta.getPaquetesXTickets()));
		}

		if (ticketVenta.getProductosXTickets() != null && !ticketVenta.getProductosXTickets().isEmpty()) {
			detallesTicketPdfVO
					.addAll(ProductoXTicketAssembler.getDetallesTicketPdfVO(ticketVenta.getProductosXTickets()));
		}

		List<DetallePagoPdfVO> detallesPagoPdfVO = PagoAssembler.getDetallesPagoPdfVO(pagos);

		List<DetalleImpuestoPdfVO> detallesImpPdfVO = new ArrayList<DetalleImpuestoPdfVO>();

		List<DetalleImpuestoPdfVO> detallesImpProductoPdfVO = ImpuestosXTicketProductoAssembler
				.getDetallesImpuestoPdfVO(ticketVenta.getImpuestosXTicketProductos());

		if (detallesImpProductoPdfVO != null) {
			detallesImpPdfVO.addAll(detallesImpProductoPdfVO);
		}

		List<DetalleImpuestoPdfVO> detallesImpPaquetePdfVO = ImpuestoXTicketPaqueteAssembler
				.getDetallesImpuestoPdfVO(ticketVenta.getImpuestosXTicketPaquetes());

		if (detallesImpPaquetePdfVO != null) {
			detallesImpPdfVO.addAll(detallesImpPaquetePdfVO);
		}

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("logo", new ByteArrayInputStream(cine.getEmpresa().getIcono()));
		parametros.put("razonSocial", ticketPdfVO.getRazonSocial());
		parametros.put("nombreCine", ticketPdfVO.getNombreCine());
		parametros.put("direccionCine", ticketPdfVO.getDireccion());
		parametros.put("rfc", ticketPdfVO.getRfc());
		parametros.put("telefono", ticketPdfVO.getTelefono());
		parametros.put("fechaHoraCompra", ticketPdfVO.getFechaHoraCompra());
		parametros.put("ordenCompra", ticketPdfVO.getNumeroOrdenTicket().toString());
		parametros.put("iva", ticketPdfVO.getIva());
		parametros.put("subtotal", ticketPdfVO.getSubtotal());
		parametros.put("totalPago", ticketPdfVO.getTotalPago());
		parametros.put("recibe", ticketPdfVO.getRecibe());
		parametros.put("cambio", ticketPdfVO.getCambio());
		parametros.put("leyenda", ticketPdfVO.getLeyenda());
		parametros.put("slogan", ticketPdfVO.getSlogan());
		parametros.put("sugerencias", ticketPdfVO.getSugerencias());

		JRBeanCollectionDataSource DS = new JRBeanCollectionDataSource(detallesTicketPdfVO);
		parametros.put("recordDataSource", DS);

		JRBeanCollectionDataSource tarjetas = new JRBeanCollectionDataSource(detallesPagoPdfVO);
		parametros.put("recordDataSourceTarjeta", tarjetas);

		JRBeanCollectionDataSource impuestos = new JRBeanCollectionDataSource(detallesImpPdfVO);
		parametros.put("recordDataSourceImpuestos", impuestos);

		try {
			ArchivoPdfVO archivoPdfVO = new ArchivoPdfVO(Constantes.TICKET);
			String rutaArchivo = context.getRealPath(rutaJasper);
			archivoPdfVO.setArchivo(JasperRunManager.runReportToPdf(rutaArchivo, parametros, new JREmptyDataSource()));
			archivosPdfVO.add(archivoPdfVO);

		} catch (JRException e) {
			e.printStackTrace();
			logger.error("Error al generar pdf para el ticket[{}]", idTicket);
		}

		return archivosPdfVO;
	}


}
