package mx.com.tecnetia.muvitul.servicios.facade;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ArchivoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.BoletoPdfVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.Boletos;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.ExistenciaBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PeliculaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PrecioXFormatoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionBoletoVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.PromocionVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.TicketVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.VentaVO;
import mx.com.tecnetia.muvitul.servicios.taquilla.controller.VentaBoletoController;
import mx.com.tecnetia.muvitul.servicios.util.Constantes;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class VentaBoletoFacade implements VentaBoletoFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(VentaBoletoFacade.class);
	@Autowired
	private VentaBoletoController ventaBoletoController;
    @Autowired
    private ServletContext servletContext;
    
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PeliculaVO>> getPeliculasByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPeliculasByCine:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaExhibicion);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		
		Calendar horario = Calendar.getInstance();
		Date hoy = formatter.parse(formatter.format(new Date()));
		
		if (!fecha.equals(hoy)){
			horario.set(Calendar.HOUR_OF_DAY, 0);
			horario.set(Calendar.MINUTE, 0);
			horario.set(Calendar.SECOND, 0);
		}
		
		List<PeliculaVO> peliculas = ventaBoletoController.getPeliculasByCine(idCine, Fecha.getDayOfWeekShort(fecha), fecha, horario.getTime());

		if (peliculas == null || peliculas.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PeliculaVO>>(peliculas, HttpStatus.OK);

	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<PromocionVO>> getPromocionesByCine(HttpServletRequest request, String fechaExhibicion)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPromocionesByCine:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaExhibicion);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		List<PromocionVO> promociones = ventaBoletoController.getPromocionesByCine(idCine,
				Constantes.ID_PROMOCION_PARA_BOLETOS, fecha);

		if (promociones == null || promociones.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PromocionVO>>(promociones, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<BigDecimal> getDescuentoByPromocion(HttpServletRequest request,
			@RequestBody PromocionBoletoVO promocionBoletoVO) throws BusinessGlobalException, NotFoundException {

		if (promocionBoletoVO == null || promocionBoletoVO.getBoletosXTicketVO() == null
				|| promocionBoletoVO.getPromocionVO() == null)
			throw new NotFoundException("Parametros invalidos");

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetDescuentoByPromocion:::IdCine[{}]:::Promocion[{}]", idCine,
				promocionBoletoVO.getPromocionVO().getDescripcion());

		return new ResponseEntity<BigDecimal>(ventaBoletoController.getDescuentoByPromocion(promocionBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PrecioXFormatoVO>> getPreciosByFormato(HttpServletRequest request, Integer idFormato)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetPreciosByFormato:::IdCine[{}]:::IdFormato[{}]", idCine, idFormato);

		List<PrecioXFormatoVO> precios = ventaBoletoController.getPreciosByFormato(idCine, idFormato);

		if (precios == null || precios.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<PrecioXFormatoVO>>(precios, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> getExistenciaBoleto(HttpServletRequest request, Integer idProgramacion,
			Integer idSala, String fechaExhibicion) throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetExistenciaBoleto:::IdCine[{}]:::IdProgramacion[{}]:::Idsala[{}]:::FechaExhibicion[{}]", idCine,
				idProgramacion, idSala, fechaExhibicion);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaExhibicion);
		ExistenciaBoletoVO existenciaBoletoVO = ventaBoletoController.getExistenciaBoleto(idProgramacion, idSala,fecha);

		if (existenciaBoletoVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<ExistenciaBoletoVO>(existenciaBoletoVO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ExistenciaBoletoVO> updateExistenciaBoleto(HttpServletRequest request,
			@RequestBody ExistenciaBoletoVO existenciaBoletoVO) throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("UpdateExistenciaBoleto:::IdCine[{}]:::IdProgramacion[{}]:::FechaExhibicion[{}]", idCine,
				existenciaBoletoVO.getProgramacionVO().getIdProgramacion(), existenciaBoletoVO.getFechaExhibicion());

		return new ResponseEntity<ExistenciaBoletoVO>(ventaBoletoController.updateExistenciaBoleto(existenciaBoletoVO),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<TicketVentaVO> createVenta(HttpServletRequest request, @RequestBody VentaVO ventaVO)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idPuntoVenta = (Integer) claims.get(ClaimsEnum.PUNTO_VENTA);
		Integer idCaja = (Integer) claims.get(ClaimsEnum.CAJA);
		
		ventaVO.setIdUsuario(idUsuario);
		ventaVO.setIdCine(idCine);
		ventaVO.setIdPuntoVenta(idPuntoVenta);
		ventaVO.setIdCaja(idCaja);

		logger.info("CreateVenta:::IdUsuario[{}]:::IdCine[{}]:::IdPuntoVenta[{}]", idUsuario, idCine, idPuntoVenta);

		TicketVentaVO ticketVentaVO = ventaBoletoController.createVenta(ventaVO);
		return new ResponseEntity<TicketVentaVO>(ticketVentaVO, HttpStatus.CREATED);

	}

	@Override
	public  ResponseEntity<List<ArchivoPdfVO>>  getTicketsPdf(HttpServletRequest request, Integer idTicket, BigDecimal pagoCon, BigDecimal cambio)
			throws BusinessGlobalException, NotFoundException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		
		logger.info("GetTicketsPdf:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);

		List<ArchivoPdfVO> archivosPdfVO = ventaBoletoController.getTicketsPdf(idCine,idTicket,pagoCon, cambio);
		
		if (archivosPdfVO == null || archivosPdfVO.isEmpty()) {
			throw new NotFoundException("No encontrado");
		}

//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.parseMediaType("application/pdf"));
//		headers.add("Content-Disposition", "attachmnt; filename ='test'");
//		headers.add("filename", "s");
//		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//		headers.setContentLength(ticketPdf.length);
		
		return new ResponseEntity<List<ArchivoPdfVO>>(archivosPdfVO, HttpStatus.OK);
	}

	
	@Override
	public @ResponseBody List<Boletos> getBoletosPdf(HttpServletRequest request, Integer idTicket)
			throws BusinessGlobalException, NotFoundException {
		
 
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		// String rutaImg = cfg.getString("taquilla.ticket.img") ;
		// String rutaJrxml = cfg.getString("taquilla.ticket.jrxml");
		String rutaJasper = cfg.getString("taquilla.ticket.boleto.jasper");
		
		BoletoPdfVO datosBoleto=new BoletoPdfVO();
		Boletos boleto = new Boletos();
		List<Boletos> listaBoletos =new ArrayList<Boletos>();

		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);
		Integer idUsuario = (Integer) claims.get(ClaimsEnum.USUARIO);
		logger.info("GetTicketsPdf:::IdUsuario[{}]:::IdCine[{}]", idUsuario, idCine);
		
		Date fecha=new Date();
		datosBoleto.setFecha(fecha.toString());
		datosBoleto.setNombreCine("TECNETIA");
		datosBoleto.setTituloPelicula("La Era del Hielo");
		datosBoleto.setHorarioFuncion(fecha.toString());
		datosBoleto.setNumSala("5");
		datosBoleto.setTipoBoleto("NIÑO");
		datosBoleto.setButaca("--");
		datosBoleto.setClasificacion("AA");
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("fecha", datosBoleto.getFecha());
		parametros.put("cine", datosBoleto.getNombreCine());
		parametros.put("tituloPelicula", datosBoleto.getTituloPelicula());
		parametros.put("horarioFuncion", datosBoleto.getHorarioFuncion());
		parametros.put("numeroSala", datosBoleto.getNumSala());
		parametros.put("tipoBoleto",datosBoleto.getTipoBoleto() );
		parametros.put("butaca", datosBoleto.getButaca());
		parametros.put("clasificacion", datosBoleto.getClasificacion());
		

//		JRBeanCollectionDataSource DS = new JRBeanCollectionDataSource(datosBoleto);
//		parametros.put("recordDataSource", DS);

		try {
			JasperReport jasperReport;
	        JasperPrint jasperPrint;  
			String rutaArchivo = servletContext.getRealPath(rutaJasper);
			for (int i = 0; i < 5; i++) {
				boleto= new Boletos();
				boleto.setNombre("Boleto"+i);
				boleto.setBoleto(JasperRunManager.runReportToPdf(rutaArchivo, parametros, new JREmptyDataSource()));
				listaBoletos.add(boleto);
			}
			 
		} catch (JRException e) {
			e.printStackTrace();
			logger.error("Error al generar pdf para el ticket[{}]", idTicket);
		}
			
		return listaBoletos;
	}
	

}
