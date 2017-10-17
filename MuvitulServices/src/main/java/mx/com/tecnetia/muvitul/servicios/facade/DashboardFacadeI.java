package mx.com.tecnetia.muvitul.servicios.facade;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.AsistenciaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoPeliculaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoSemanalGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentabilidadGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentableVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dashboard")
public interface DashboardFacadeI {

	@RequestMapping(value = "/ingresos/semanales", method = RequestMethod.GET)
	public ResponseEntity<IngresoSemanalGraficaVO> getIngresoSemanalTaquilla(HttpServletRequest request, Integer idCine,
			String fechaActual, int semanas, String clavePuntoVenta)
			throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/ingresos/peliculas", method = RequestMethod.GET)
	public ResponseEntity<IngresoPeliculaGraficaVO> getIngresoPelicula(HttpServletRequest request, Integer idCine)
			throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/asistencias", method = RequestMethod.GET)
	public ResponseEntity<AsistenciaGraficaVO> getAsistencia(HttpServletRequest request, Integer idCine,
			String fechaActual, int semanas) throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/rentabilidades", method = RequestMethod.GET)
	public ResponseEntity<RentabilidadGraficaVO> getRentabilidad(HttpServletRequest request, Integer idCine,
			String fechaActual, int dias) throws BusinessGlobalException, NotFoundException, ParseException;

	
	@RequestMapping(value = "/productos/rentables", method = RequestMethod.GET)
	public ResponseEntity<List<RentableVO>> getRentables(HttpServletRequest request, Integer idCine, String fechaActual,
			int dias, boolean isDesc, int limit) throws BusinessGlobalException, NotFoundException, ParseException;

	@RequestMapping(value = "/productos/vendidos", method = RequestMethod.GET)
	public ResponseEntity<List<RentableVO>> getVendidos(HttpServletRequest request, Integer idCine, String fechaActual,
			int dias, boolean isDesc, int limit) throws BusinessGlobalException, NotFoundException, ParseException;

}
