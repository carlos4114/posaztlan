package mx.com.tecnetia.muvitul.negocio.taquilla.business;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.BoletosXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.CineDAO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ExistenciaBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestoBoletoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ImpuestosXTicketTaquillaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PagoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PrecioXFormatoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.ProgramacionDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PromocionesXTicketDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.TicketVentaDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.BoletosXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Cine;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ExistenciaBoletos;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestoBoleto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.ImpuestosXTicketTaquilla;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Pago;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Programacion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PromocionesXTicket;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.TicketVenta;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.BoletoXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ImpuestoXTicketTaquillaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PagoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PeliculaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PrecioXFormatoAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.ProgramacionAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.PromocionXTicketAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.assembler.TicketVentaAssembler;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleImpuestoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetallePagoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.DetalleTicketPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionXTicketVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VersionFormatoVO;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class VentaBoletoBO {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoBO.class);

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private PagoDAOI pagoDAO;

	@Autowired
	private BoletosXTicketDAOI boletoXTicketDAO;

	@Autowired
	private PromocionesXTicketDAOI promocionXTicketDAO;

	@Autowired
	private ExistenciaBoletoDAOI existenciaBoletoDAO;

	@Autowired
	private ImpuestosXTicketTaquillaDAOI impuestosXTicketTaquillaDAO;

	@Autowired
	private ImpuestoBoletoDAOI impuestoBoletoDAO;
	
	@Autowired
	private CineDAO cineDAO; 

	@Autowired
	private ServletContext context;

	@Autowired
	private ProgramacionDAOI programacionDAO;

	@Autowired
	private ExistenciaBoletoBO existenciaBoletoBO;
	
	@Autowired
	private PrecioXFormatoDAOI precioXFormatoDAO;
	
	public List<PeliculaVO> findByCineDiaAndExhibicion(Integer idCine, String diaSemana, Date fechaExhibicion)
			throws BusinessGlobalException {
		Map<Integer, PeliculaVO> mapPeliculas = new HashMap<Integer, PeliculaVO>();

		List<Programacion> programaciones = programacionDAO.findByCineDiaAndExhibicion(idCine, diaSemana,
				fechaExhibicion);

		for (Programacion programacion : programaciones) {
			
			ExistenciaBoletoVO ExistenciaBoletoVO = existenciaBoletoBO.findByProgramacionSalaAndExhibicion(
					programacion.getIdProgramacion(), programacion.getSala().getIdSala(), fechaExhibicion);
			
			Integer peliculaKey=programacion.getPelicula().getIdPelicula();
			
			if (!mapPeliculas.containsKey(peliculaKey)) {
				mapPeliculas.put(peliculaKey,PeliculaAssembler.getPeliculaVO(programacion.getPelicula()));
			}

			PeliculaVO peliculaVO = mapPeliculas.get(peliculaKey);

			String versionFormatoKey=programacion.getVersion().getNombre()+programacion.getFormato().getNombre();
			
			if (!peliculaVO.getVersionFormatoVO().containsKey(versionFormatoKey)) {
				VersionFormatoVO versionFormatoVO= new VersionFormatoVO();
				versionFormatoVO.setNombre(programacion.getVersion().getNombre()+" "+programacion.getFormato().getNombre());
				peliculaVO.getVersionFormatoVO().put(versionFormatoKey, versionFormatoVO);
			}
			
			ProgramacionVO programacionVO = ProgramacionAssembler.getProgramacionVO(programacion);
			programacionVO.setExistenciaBoletoVO(ExistenciaBoletoVO);
			
			VersionFormatoVO versionFormatoVO=peliculaVO.getVersionFormatoVO().get(versionFormatoKey);
			versionFormatoVO.getProgramaciones().add(programacionVO);

		}

		return new ArrayList<PeliculaVO>(mapPeliculas.values());
	}

	
	public TicketVentaVO createVenta(VentaVO ventaVO) throws BusinessGlobalException {

		int cantidadBoletos = 0;
		BigDecimal total = new BigDecimal(0);
		BigDecimal descuento = new BigDecimal(0);
		BigDecimal porcentajes = new BigDecimal(0);
		BigDecimal subtotal = new BigDecimal(0);
		BigDecimal descuentoxBoleto= new BigDecimal(0);

		List<ImpuestoBoleto> impuestosBoletos = impuestoBoletoDAO.findByIdCine(ventaVO.getIdCine());

		for (BoletoXTicketVO boletoXTicketVO : ventaVO.getBoletosXTicketVO()) {
			cantidadBoletos = cantidadBoletos + boletoXTicketVO.getCantidad();
			total = total.add(boletoXTicketVO.getImporte());
		}

		for (PromocionXTicketVO promocionXTicketVO : ventaVO.getPromocionesXTicketVO()) {
			descuento = descuento.add(promocionXTicketVO.getImporte());
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {
			porcentajes = porcentajes.add(impuestoBoleto.getPorcentaje());
		}

		porcentajes = porcentajes.divide(new BigDecimal(100));
		porcentajes = porcentajes.add(new BigDecimal(1));

		subtotal = subtotal.add(total);
		subtotal = subtotal.subtract(descuento);
		subtotal = subtotal.divide(porcentajes, 3, BigDecimal.ROUND_HALF_EVEN);

		logger.info("Total: [{}] Descuento:[{}] Porcentajes:[{}] Subtotal:[{}]", total.toString(), descuento.toString(),
				porcentajes.toString(), subtotal.toString());

		TicketVenta ticketVenta = ticketVentaDAO.save(TicketVentaAssembler.getTicketVenta(ventaVO.getIdUsuario(),
				ventaVO.getIdPuntoVenta(), descuento, subtotal, total));

		descuentoxBoleto= descuentoxBoleto.add(descuento);
		descuentoxBoleto= descuentoxBoleto.divide(new BigDecimal(cantidadBoletos),3, BigDecimal.ROUND_HALF_EVEN);
		
		List<BoletosXTicket> boletosXTicket = BoletoXTicketAssembler.getBoletosXTicket(ventaVO.getBoletosXTicketVO(),
				ticketVenta, descuentoxBoleto);
		
		for (BoletosXTicket boletoXTicket : boletosXTicket) {
			boletoXTicketDAO.save(boletoXTicket);
		}

		List<PromocionesXTicket> promocionesXTicket = PromocionXTicketAssembler.getPromocionesXTicket(
				ventaVO.getPromocionesXTicketVO(), ticketVenta);
		
		for (PromocionesXTicket promocionXTicket : promocionesXTicket) {
			promocionXTicketDAO.save(promocionXTicket);
		}

		List<Pago> pagos = PagoAssembler.getPagos(ventaVO.getPagosVO(), ticketVenta);
		for (Pago pago : pagos) {
			pagoDAO.save(pago);
		}

		for (ImpuestoBoleto impuestoBoleto : impuestosBoletos) {

			BigDecimal porcentaje = new BigDecimal(0);
			porcentaje = porcentaje.add(impuestoBoleto.getPorcentaje());
			porcentaje = porcentaje.divide(new BigDecimal(100));

			BigDecimal impuesto = new BigDecimal(0);
			impuesto = impuesto.add(subtotal);
			impuesto = impuesto.multiply(porcentaje);

			ImpuestosXTicketTaquilla impuestosXTicketTaquilla = ImpuestoXTicketTaquillaAssembler
					.getImpuestosXTicketTaquilla(impuestoBoleto.getIdImpuestoBoleto(), ticketVenta, impuesto);
			impuestosXTicketTaquillaDAO.save(impuestosXTicketTaquilla);
		}

		ExistenciaBoletos existenciaBoletos = existenciaBoletoDAO.findByIdProgramacion(
				ventaVO.getBoletosXTicketVO().get(0).getProgramacionVO().getIdProgramacion(),
				ventaVO.getBoletosXTicketVO().get(0).getFechaExhibicion());
		
		if (existenciaBoletos != null) {
			existenciaBoletos.setBoletosReservados(existenciaBoletos.getBoletosReservados() - cantidadBoletos);
			existenciaBoletoDAO.update(existenciaBoletos);
		}

		return TicketVentaAssembler.getTicketVentaVO(ticketVenta);
	}

	public List<ArchivoPdfVO> generarTicketsPdf(Integer idCine, Integer idTicket, BigDecimal pagoCon, BigDecimal cambio) throws BusinessGlobalException {
		// String rutaImg = cfg.getString("taquilla.ticket.img") ;
		// String rutaJrxml = cfg.getString("taquilla.ticket.jrxml");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaTicketJasper = cfg.getString("taquilla.ticket.jasper");
		String rutaBoletoJasper = cfg.getString("taquilla.ticket.boleto.jasper");
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DDMMYYYYHHMMSSSSS);
		List<ArchivoPdfVO> archivosPdfVO= new ArrayList<ArchivoPdfVO>();
		
		pagoCon = pagoCon.setScale(2, RoundingMode.CEILING);
		cambio = cambio.setScale(2, RoundingMode.CEILING);
		
		Cine cine= cineDAO.findById(idCine);
		TicketVenta ticketVenta =ticketVentaDAO.getById(idTicket);
		List<Pago>  pagos = pagoDAO.findByTicketAndCta(idTicket);
		
		TicketPdfVO ticketPdfVO =TicketVentaAssembler.getTicketPdfVO(cine, ticketVenta, pagoCon, cambio);
		
		//List<BoletosXTicket> boletosXTicket= boletoXTicketDAO.findByTicket(idTicket);
		
		List<DetalleTicketPdfVO> detallesTicketPdfVO = BoletoXTicketAssembler.getDetallesTicketPdfVO(ticketVenta.getBoletosXTickets());

		if (ticketVenta.getPromocionesXTickets()!=null && !ticketVenta.getPromocionesXTickets().isEmpty()){
			detallesTicketPdfVO.addAll(PromocionXTicketAssembler.getDetallesTicketPdfVO(ticketVenta.getPromocionesXTickets()));
		}

		List<DetallePagoPdfVO> detallesPagoPdfVO = PagoAssembler.getDetallesPagoPdfVO(pagos);

		List<DetalleImpuestoPdfVO> detallesImpuestoPdfVO = ImpuestoXTicketTaquillaAssembler.getDetallesImpuestoPdfVO(ticketVenta.getImpuestosXTicketTaquillas());
		
		Map<String, Object> paramTicket = new HashMap<String, Object>();
		paramTicket.put("logo", new ByteArrayInputStream(cine.getEmpresa().getIcono()));
		paramTicket.put("razonSocial", ticketPdfVO.getRazonSocial());
		paramTicket.put("nombreCine", ticketPdfVO.getNombreCine());
		paramTicket.put("direccionCine", ticketPdfVO.getDireccion());
		paramTicket.put("rfc", ticketPdfVO.getRfc());
		paramTicket.put("telefono", ticketPdfVO.getTelefono());
		paramTicket.put("fechaHoraCompra", ticketPdfVO.getFechaHoraCompra());
		paramTicket.put("ordenCompra", ticketPdfVO.getNumeroOrdenTicket().toString());
		paramTicket.put("iva", ticketPdfVO.getIva());
		paramTicket.put("subtotal", ticketPdfVO.getSubtotal());
		paramTicket.put("totalPago", ticketPdfVO.getTotalPago());
		paramTicket.put("recibe", ticketPdfVO.getRecibe());
		paramTicket.put("cambio", ticketPdfVO.getCambio());
		paramTicket.put("leyenda", ticketPdfVO.getLeyenda());
		paramTicket.put("slogan", ticketPdfVO.getSlogan());
		paramTicket.put("sugerencias", ticketPdfVO.getSugerencias());
		
		JRBeanCollectionDataSource venta = new JRBeanCollectionDataSource(detallesTicketPdfVO);
		paramTicket.put("recordDataSource", venta);
		
		JRBeanCollectionDataSource tarjetas = new JRBeanCollectionDataSource(detallesPagoPdfVO);
		paramTicket.put("recordDataSourceTarjeta", tarjetas);

		JRBeanCollectionDataSource impuestos = new JRBeanCollectionDataSource(detallesImpuestoPdfVO);
		paramTicket.put("recordDataSourceImpuestos", impuestos);
		

		try {
			ArchivoPdfVO  archivoPdfVO= new ArchivoPdfVO(Constantes.TICKET);
			String rutaArchivoTicket = context.getRealPath(rutaTicketJasper);
			archivoPdfVO.setArchivo(JasperRunManager.runReportToPdf(rutaArchivoTicket, paramTicket, new JREmptyDataSource()));
			archivosPdfVO.add(archivoPdfVO);
		} catch (JRException e) {
			e.printStackTrace();
			logger.error("Error al generar pdf para el ticket[{}]", idTicket);
		}
		
		for (BoletosXTicket boletosXTicket : ticketVenta.getBoletosXTickets()) {
			
			for (int i = 0; i < boletosXTicket.getCantidad(); i++) {
				
				BoletoPdfVO boletoPdfVO =BoletoXTicketAssembler.getBoletoPdfVO(cine,boletosXTicket);
				
				Map<String, Object> paramBoleto = new HashMap<String, Object>();
				paramBoleto.put("fecha", boletoPdfVO.getFecha());
				paramBoleto.put("cine", boletoPdfVO.getNombreCine());
				paramBoleto.put("tituloPelicula", boletoPdfVO.getTituloPelicula());
				paramBoleto.put("horarioFuncion", boletoPdfVO.getHorarioFuncion());
				paramBoleto.put("numeroSala", boletoPdfVO.getNumSala());
				paramBoleto.put("tipoBoleto",boletoPdfVO.getTipoBoleto() );
				paramBoleto.put("butaca", boletoPdfVO.getButaca());
				paramBoleto.put("clasificacion", boletoPdfVO.getClasificacion());
				
				try {
					ArchivoPdfVO  archivoPdfVO= new ArchivoPdfVO(boletosXTicket.getTipoCliente().getNombre().replace(Constantes.BLANK_SPACE, Constantes.UNDERSCORE));
					String rutaArchivoBoleto = context.getRealPath(rutaBoletoJasper);
					archivoPdfVO.setArchivo(JasperRunManager.runReportToPdf(rutaArchivoBoleto, paramBoleto, new JREmptyDataSource()));
					archivosPdfVO.add(archivoPdfVO);
				} catch (JRException e) {
					e.printStackTrace();
					logger.error("Error al generar pdf para el boleto [{}]", idTicket);
				}
			}
		}
		
		return archivosPdfVO;
	}
	
	public List<PrecioXFormatoVO> findPreciosByFormatoCine(Integer idCine, Integer idFormato)
			throws BusinessGlobalException {

		return PrecioXFormatoAssembler.getPreciosXFormatoVO(precioXFormatoDAO.findPreciosByFormatoCine(idCine, idFormato));

	}
 
}
