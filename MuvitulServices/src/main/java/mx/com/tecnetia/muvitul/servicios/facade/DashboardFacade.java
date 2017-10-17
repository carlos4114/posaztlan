package mx.com.tecnetia.muvitul.servicios.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.AsistenciaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoPeliculaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoSemanalGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentabilidadGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentableVO;
import mx.com.tecnetia.muvitul.servicios.dashboard.controller.DashboardController;

@Service
public class DashboardFacade implements DashboardFacadeI {
	private static final Logger logger = LoggerFactory.getLogger(DashboardFacade.class);

	@Autowired
	private DashboardController dashboardController;

	@Override
	public ResponseEntity<IngresoSemanalGraficaVO> getIngresoSemanalTaquilla(HttpServletRequest request, Integer idCine,
			String fechaActual, int semanas, String clavePuntoVenta)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetIngresosSemanalesTaquilla:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaActual);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaActual);

		IngresoSemanalGraficaVO ingresoSemanalGraficaVO = dashboardController.getIngresoSemanalTaquilla(idCine, fecha,
				semanas, clavePuntoVenta);

		if (ingresoSemanalGraficaVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<IngresoSemanalGraficaVO>(ingresoSemanalGraficaVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IngresoPeliculaGraficaVO> getIngresoPelicula(HttpServletRequest request, Integer idCine)
			throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetIngresoPelicula:::IdCine[{}]:::FechaExhibicion[{}]", idCine);
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(4);
		calendar.setTime(new Date());
		int numberWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

		IngresoPeliculaGraficaVO ingresoPeliculaGraficaVO = dashboardController.getIngresoPelicula(idCine,
				numberWeekOfYear);

		if (ingresoPeliculaGraficaVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<IngresoPeliculaGraficaVO>(ingresoPeliculaGraficaVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AsistenciaGraficaVO> getAsistencia(HttpServletRequest request, Integer idCine,
			String fechaActual, int semanas) throws BusinessGlobalException, NotFoundException, ParseException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetAsistencia:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaActual);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaActual);

		AsistenciaGraficaVO asistenciaGraficaVO = dashboardController.getAsistencia(idCine, fecha, semanas);

		if (asistenciaGraficaVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<AsistenciaGraficaVO>(asistenciaGraficaVO, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<RentabilidadGraficaVO> getRentabilidad(HttpServletRequest request, Integer idCine,
			String fechaActual, int dias) throws BusinessGlobalException, NotFoundException, ParseException {
		
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetRentabilidad:::IdCine[{}]:::FechaExhibicion[{}]", idCine, fechaActual);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaActual);

		RentabilidadGraficaVO rentabilidadGraficaVO = dashboardController.getRentabilidad(idCine, fecha, dias);

		if (rentabilidadGraficaVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<RentabilidadGraficaVO>(rentabilidadGraficaVO, HttpStatus.OK);

	}


	@Override
	public ResponseEntity<List<RentableVO>> getRentables(HttpServletRequest request, Integer idCine, String fechaActual,
			int dias, boolean isDesc, int limit) throws BusinessGlobalException, NotFoundException, ParseException {

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetRentables:::IdCine[{}]:::Dias[{}]", idCine, dias);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaActual);

		List<RentableVO> rentablesVO = dashboardController.getRentables(idCine, fecha, dias, isDesc, limit);

		if (rentablesVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<RentableVO>>(rentablesVO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<RentableVO>> getVendidos(HttpServletRequest request, Integer idCine, String fechaActual,
			int dias, boolean isDesc, int limit) throws BusinessGlobalException, NotFoundException, ParseException {
		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		// Integer idCine = (Integer) claims.get(ClaimsEnum.CINE);

		logger.info("GetVendidos:::IdCine[{}]:::Dias[{}]", idCine, dias);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(fechaActual);

		List<RentableVO> rentablesVO = dashboardController.getVendidos(idCine, fecha, dias, isDesc, limit);

		if (rentablesVO == null) {
			throw new NotFoundException("No encontrado");
		}

		return new ResponseEntity<List<RentableVO>>(rentablesVO, HttpStatus.OK);
	}


}
