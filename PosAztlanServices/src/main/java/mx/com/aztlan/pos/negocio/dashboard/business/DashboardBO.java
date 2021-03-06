package mx.com.aztlan.pos.negocio.dashboard.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.MovimientoInventarioDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.ProductoXTicketDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TicketVentaDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.ArticulosXProducto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Producto;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.IngresoVO;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.vo.ProductoCostoVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.AsistenciaGraficaVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.IngresoPeliculaGraficaVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.IngresoPeliculaVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.IngresoSemanalGraficaVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.IngresoSemanalVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.RentabilidadGraficaVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.RentabilidadVO;
import mx.com.aztlan.pos.negocio.dashboard.vo.RentableVO;
import mx.com.aztlan.pos.servicios.util.Fecha;
import mx.com.aztlan.pos.servicios.util.PuntoVentaType;

@Service
@Transactional
public class DashboardBO {

	@Autowired
	private TicketVentaDAOI ticketVentaDAO;

	@Autowired
	private ProductoXTicketDAOI productoXTicketDAO;

	@Autowired
	private MovimientoInventarioDAOI movimientoInventarioDAO;

	@Autowired
	private ProductoDAOI productoDAO;
	
	public IngresoSemanalGraficaVO getIngresoSemanal(Integer idCine, Date fechaActual, int semanas,
			String clavePuntoVenta) {
		List<IngresoVO> ingresosVO = null;
		
		if(PuntoVentaType.DULCERIA.getType().equals(clavePuntoVenta)){
			ingresosVO = ticketVentaDAO.getIngresosDiariosDeDulceria(idCine, fechaActual, semanas * 7);
		}else{
			if(PuntoVentaType.TAQUILLA.getType().equals(clavePuntoVenta)){
				ingresosVO = ticketVentaDAO.getIngresosDiariosDeTaquilla(idCine, fechaActual, semanas * 7);				
			}
		}
		Map<String, BigDecimal> mapIngresos = new HashMap<String, BigDecimal>();
		for (IngresoVO ingresoVO : ingresosVO)
			mapIngresos.put(ingresoVO.getAgrupador(), ingresoVO.getTotal());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, -(semanas * 7));
		Date fechaInicial = calendar.getTime();

		IngresoSemanalGraficaVO ingresoSemanalGraficaVO = new IngresoSemanalGraficaVO();
		List<IngresoSemanalVO> ingresosSemanalVO = new ArrayList<IngresoSemanalVO>();
		List<String> dias = new ArrayList<String>();

		for (int i = 1; i <= 7; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaInicial);
			cal.add(Calendar.DAY_OF_YEAR, +i);
			dias.add(Fecha.getDayOfWeek(cal.getTime()));

		}

		int count = 0;
		for (int j = 1; j <= semanas; j++) {
			IngresoSemanalVO ingresoSemanalVO = new IngresoSemanalVO();
			
			SimpleDateFormat formatt = new SimpleDateFormat("MMM/dd");
			
			Calendar cali = Calendar.getInstance();
			cali.setTime(fechaInicial);
			cali.add(Calendar.DAY_OF_YEAR, count+1);

			Calendar calf = Calendar.getInstance();
			calf.setTime(fechaInicial);
			calf.add(Calendar.DAY_OF_YEAR, count+7);
			
			ingresoSemanalVO.setDescripcion(formatt.format(cali.getTime()).toUpperCase()+ " - "+formatt.format(calf.getTime()).toUpperCase());
			List<BigDecimal> totales = new ArrayList<BigDecimal>();
			
			
			for (int k = 1; k <= 7; k++) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaInicial);
				cal.add(Calendar.DAY_OF_YEAR, ++count);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				String key = formatter.format(cal.getTime());
				totales.add(mapIngresos.containsKey(key) ? mapIngresos.get(key) : new BigDecimal(0));
			}

			ingresoSemanalVO.setTotales(totales);
			ingresosSemanalVO.add(ingresoSemanalVO);
		}

		ingresoSemanalGraficaVO.setDias(dias);
		ingresoSemanalGraficaVO.setIngresoSemanalVO(ingresosSemanalVO);

		return ingresoSemanalGraficaVO;
	}

	public IngresoPeliculaGraficaVO getIngresoPelicula(Integer idCine, int noSemanaActual) {
		List<String> peliculas = new ArrayList<>();
		List<IngresoVO> ingresoPelicula = ticketVentaDAO.getIngresosPeliculas(idCine);
		for (IngresoVO ingresoVO : ingresoPelicula) {
			peliculas.add(ingresoVO.getAgrupador());
		}

		List<IngresoVO> ingresoPeliculaActual = ticketVentaDAO.getIngresosPeliculas(idCine, noSemanaActual - 1);
		Map<String, BigDecimal> mapIngresosActual = new HashMap<String, BigDecimal>();
		for (IngresoVO ingresoVO : ingresoPeliculaActual)
			mapIngresosActual.put(ingresoVO.getAgrupador(), ingresoVO.getTotal());

		List<IngresoVO> ingresoPeliculaAnterior = ticketVentaDAO.getIngresosPeliculas(idCine, noSemanaActual - 2);
		Map<String, BigDecimal> mapIngresosAnteriores = new HashMap<String, BigDecimal>();
		for (IngresoVO ingresoVO : ingresoPeliculaAnterior)
			mapIngresosAnteriores.put(ingresoVO.getAgrupador(), ingresoVO.getTotal());

		IngresoPeliculaGraficaVO ingresoPeliculaGraficaVO = new IngresoPeliculaGraficaVO();
		List<IngresoPeliculaVO> ingresosPeliculaVO = new ArrayList<IngresoPeliculaVO>();

		
		
		SimpleDateFormat formatt = new SimpleDateFormat("MMM/dd");
		Calendar calfsc = Calendar.getInstance();
		calfsc.setTime(new Date());
		
		Calendar calisc = Calendar.getInstance();
		calisc.setTime(new Date());
		calisc.add(Calendar.DAY_OF_YEAR, -7);
		
		IngresoPeliculaVO ingresoActual = new IngresoPeliculaVO();
		ingresoActual.setDescripcion("ACTUAL::"+ formatt.format(calisc.getTime()).toUpperCase()+ " - "+formatt.format(calfsc.getTime()).toUpperCase());
		List<BigDecimal> totalesActuales = new ArrayList<BigDecimal>();

		Calendar calfsa = Calendar.getInstance();
		calfsa.setTime(new Date());
		calfsa.add(Calendar.DAY_OF_YEAR, -8);
		
		Calendar calisa = Calendar.getInstance();
		calisa.setTime(new Date());
		calisa.add(Calendar.DAY_OF_YEAR, -14);
		
		IngresoPeliculaVO ingresoAnterior = new IngresoPeliculaVO();
		ingresoAnterior.setDescripcion("ANTERIOR::"+ formatt.format(calisa.getTime()).toUpperCase()+ " - "+formatt.format(calfsa.getTime()).toUpperCase());
		List<BigDecimal> totalesAnterior = new ArrayList<BigDecimal>();

		for (String pelicula : peliculas) {
			totalesActuales.add(mapIngresosActual.containsKey(pelicula) ? mapIngresosActual.get(pelicula) : new BigDecimal(0));
			totalesAnterior.add(mapIngresosAnteriores.containsKey(pelicula) ? mapIngresosAnteriores.get(pelicula): new BigDecimal(0));
		}

		ingresoActual.setTotales(totalesActuales);
		ingresoAnterior.setTotales(totalesAnterior);

		ingresosPeliculaVO.add(ingresoActual);
		ingresosPeliculaVO.add(ingresoAnterior);

		ingresoPeliculaGraficaVO.setPeliculas(peliculas);
		ingresoPeliculaGraficaVO.setIngresosPeliculaVO(ingresosPeliculaVO);

		return ingresoPeliculaGraficaVO;
	}

	public AsistenciaGraficaVO getAsistencia(Integer idCine, Date fechaActual, int semanas) {
		List<IngresoVO> asistenciasVO = ticketVentaDAO.getAsistencia(idCine, fechaActual, semanas);
		Map<String, BigDecimal> mapAsistencia = new HashMap<String, BigDecimal>();
		for (IngresoVO asistenciaVO : asistenciasVO)
			mapAsistencia.put(asistenciaVO.getAgrupador(), asistenciaVO.getTotal());

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, -(semanas * 7));
		Date fechaInicial = calendar.getTime();

		List<String> dias = new ArrayList<String>();

		for (int i = 1; i <= 7; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaInicial);
			cal.add(Calendar.DAY_OF_YEAR, +i);
			dias.add(Fecha.getDayOfWeekShort(cal.getTime()));
		}

		List<BigDecimal> totales = new ArrayList<BigDecimal>();

		for (String dia : dias) {
			totales.add(mapAsistencia.containsKey(dia) ? mapAsistencia.get(dia) : new BigDecimal(0));
		}

		List<String> diasSemana = new ArrayList<String>();

		for (int i = 1; i <= 7; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaInicial);
			cal.add(Calendar.DAY_OF_YEAR, +i);
			diasSemana.add(Fecha.getDayOfWeek(cal.getTime()));
		}
		
		AsistenciaGraficaVO asistenciaGraficaVO = new AsistenciaGraficaVO();
		asistenciaGraficaVO.setDias(diasSemana);
		asistenciaGraficaVO.setTotales(totales);

		return asistenciaGraficaVO;
	}

	public RentabilidadGraficaVO getRentabilidad(Integer idCine, Date fechaActual, int dias) {
		List<String> fechas = new ArrayList<String>();
		List<RentabilidadVO> totales = new ArrayList<RentabilidadVO>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, -dias);
		Date fechaInicial = calendar.getTime();

		List<IngresoVO> ingresosDiarios = ticketVentaDAO.getIngresosDiariosDeDulceria(idCine, fechaActual, dias);
		Map<String, BigDecimal> mapIngresosDiarios = new HashMap<String, BigDecimal>();
		for (IngresoVO ingresoVO : ingresosDiarios)
			mapIngresosDiarios.put(ingresoVO.getAgrupador(), ingresoVO.getTotal());

		List<IngresoVO> precioAvgDiario = movimientoInventarioDAO.findAvgPrecioDiario(idCine, fechaActual, dias);
		Map<String, BigDecimal> mapPrecioAvgDiario = new HashMap<String, BigDecimal>();
		for (IngresoVO ingresoVO : precioAvgDiario)
			mapPrecioAvgDiario.put(ingresoVO.getAgrupador(), ingresoVO.getTotal());

		for (int i = 1; i <= dias; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaInicial);
			cal.add(Calendar.DAY_OF_YEAR, +i);
			String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
			fechas.add(formattedDate);
			
			RentabilidadVO rentabilidadVO = new RentabilidadVO();
			rentabilidadVO.setX(formattedDate);
			rentabilidadVO.setY(new BigDecimal(0));
			
			String key = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());

			if (mapIngresosDiarios.containsKey(key) && mapPrecioAvgDiario.containsKey(key)) {
				BigDecimal rentabilidad = new BigDecimal(0);
				rentabilidad = rentabilidad.add(mapIngresosDiarios.get(key));
				rentabilidad = rentabilidad.subtract(mapPrecioAvgDiario.get(key));
				rentabilidad = rentabilidad.multiply(new BigDecimal(100));
				rentabilidad = rentabilidad.divide(mapIngresosDiarios.get(key), 3, BigDecimal.ROUND_HALF_EVEN );
				rentabilidadVO.setY(rentabilidad);
			}

			totales.add(rentabilidadVO);

		}

		RentabilidadGraficaVO rentabilidadGraficaVO = new RentabilidadGraficaVO();
		rentabilidadGraficaVO.setFechas(fechas);
		rentabilidadGraficaVO.setTotales(totales);

		return rentabilidadGraficaVO;
	}

	public List<RentableVO> getRentables(Integer idCine, Date fechaActual, int dias, boolean desc, int limit) {

		List<RentableVO> rentablesVO = getRentablesXDias(idCine, fechaActual, dias);

		if (desc) {

			Collections.sort(rentablesVO, new Comparator<RentableVO>() {

				public int compare(RentableVO rvo1, RentableVO rvo2) {
					return rvo2.getRentabilidad().compareTo(rvo1.getRentabilidad());
				}

			});

		} else {

			Collections.sort(rentablesVO, new Comparator<RentableVO>() {

				public int compare(RentableVO rvo1, RentableVO rvo2) {
					return rvo1.getRentabilidad().compareTo(rvo2.getRentabilidad());
				}

			});

		}

		
		for (int i = 0; i < rentablesVO.size(); i++) {
			RentableVO rentableVO= rentablesVO.get(i);
			rentableVO.setConsecutivo(i+1);
		}
		
		if (rentablesVO.size() > limit) {
			return rentablesVO.subList(0, limit);
		}

		return rentablesVO;
	}

	public List<RentableVO> getVendidos(Integer idCine, Date fechaActual, int dias, boolean desc, int limit) {

		List<RentableVO> rentablesVO = getRentablesXDias(idCine, fechaActual, dias);

		if (desc) {
			Collections.sort(rentablesVO, new Comparator<RentableVO>() {

				public int compare(RentableVO rvo1, RentableVO rvo2) {
					//return new Integer(rvo2.getVendidos()).compareTo(new Integer(rvo1.getVendidos()));
					return rvo2.getUnidadXTicket().compareTo(rvo1.getUnidadXTicket());
				}

			});

		} else {

			Collections.sort(rentablesVO, new Comparator<RentableVO>() {

				public int compare(RentableVO rvo1, RentableVO rvo2) {
					//return new Integer(rvo1.getVendidos()).compareTo(new Integer(rvo2.getVendidos()));
					return rvo1.getUnidadXTicket().compareTo(rvo2.getUnidadXTicket());
				}

			});

		}
		
		
		for (int i = 0; i < rentablesVO.size(); i++) {
			RentableVO rentableVO= rentablesVO.get(i);
			rentableVO.setConsecutivo(i+1);
		}

		if (rentablesVO.size() > limit) {
			return rentablesVO.subList(0, limit);
		}

		return rentablesVO;
	}

	public List<RentableVO> getRentablesXDias(Integer idCine, Date fechaActual, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, -dias);
		Date startDate = calendar.getTime();

		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.add(Calendar.DAY_OF_YEAR, +1);
		Date  endDate = calendar2.getTime();
		
		List<RentableVO> rentablesVO = new ArrayList<RentableVO>();
		List<IngresoVO> precioAvgArticulos = movimientoInventarioDAO.findAvgPrecioArticulo(idCine, fechaActual, dias);
		Map<String, BigDecimal> mapPrecioAvgArticulos = new HashMap<String, BigDecimal>();
		
		for (IngresoVO precioAvgArticulo : precioAvgArticulos)
			mapPrecioAvgArticulos.put(precioAvgArticulo.getAgrupador(), precioAvgArticulo.getTotal());

		List<ProductoCostoVO> productosXTicket = productoXTicketDAO.getPrecioPromedio(idCine, startDate, endDate,dias);

		Map<Integer, Producto> mapProductoXTicket = new HashMap<Integer, Producto>();
		
		for (ProductoCostoVO productoXTicket : productosXTicket) {
			mapProductoXTicket.put(productoXTicket.getProducto().getIdProducto(), productoXTicket.getProducto());
			BigDecimal precioAvgProducto = new BigDecimal(productoXTicket.getImporte().doubleValue());

			BigDecimal unitarioAvgProducto = new BigDecimal(0);
			for (ArticulosXProducto articulosXProducto : productoXTicket.getProducto().getArticulosXProductos()) {
				unitarioAvgProducto = unitarioAvgProducto
						.add(mapPrecioAvgArticulos.get(articulosXProducto.getArticulo().getNombre()));
			}

			precioAvgProducto = precioAvgProducto.subtract(unitarioAvgProducto);
			precioAvgProducto = precioAvgProducto.multiply(new BigDecimal(100));
			precioAvgProducto = precioAvgProducto.divide(productoXTicket.getImporte(), 3, BigDecimal.ROUND_HALF_EVEN);

			RentableVO rentableVO = new RentableVO();
			rentableVO.setNombre(productoXTicket.getProducto().getNombre());
			rentableVO.setVendidos(productoXTicket.getCantidad());
			rentableVO.setRentabilidad(precioAvgProducto.doubleValue());
			rentableVO.setUnidadXTicket(productoXTicket.getUnidadXTicket().doubleValue());
			rentablesVO.add(rentableVO);
		}

		List<Producto> productos=  productoDAO.findByCine(idCine);
		
		for (Producto producto : productos) {
			
			if (!mapProductoXTicket.containsKey(producto.getIdProducto())){
				RentableVO rentableVO = new RentableVO();
				rentableVO.setNombre(producto.getNombre());
				rentableVO.setVendidos(0);
				rentableVO.setRentabilidad((double) 0);
				rentableVO.setUnidadXTicket((double) 0);
				rentablesVO.add(rentableVO);
			}

		}
		
		return rentablesVO;
	}

}
