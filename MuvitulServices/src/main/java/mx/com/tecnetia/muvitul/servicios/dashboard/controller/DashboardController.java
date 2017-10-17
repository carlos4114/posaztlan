package mx.com.tecnetia.muvitul.servicios.dashboard.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.negocio.dashboard.business.DashboardBO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.AsistenciaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoPeliculaGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.IngresoSemanalGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentabilidadGraficaVO;
import mx.com.tecnetia.muvitul.negocio.dashboard.vo.RentableVO;

@Service
public class DashboardController {

	@Autowired
	private DashboardBO dashboardBoletoBO;

	public IngresoSemanalGraficaVO getIngresoSemanalTaquilla(Integer idCine, Date fechaActual, int semanas,
			String clavePuntoVenta) throws BusinessGlobalException {
		return dashboardBoletoBO.getIngresoSemanal(idCine, fechaActual, semanas, clavePuntoVenta);
	}

	public IngresoPeliculaGraficaVO getIngresoPelicula(Integer idCine, int numberWeekOfYear) {
		return dashboardBoletoBO.getIngresoPelicula(idCine, numberWeekOfYear);
	}

	public AsistenciaGraficaVO getAsistencia(Integer idCine, Date fechaActual, int semanas) {
		return dashboardBoletoBO.getAsistencia(idCine, fechaActual, semanas);
	}

	public RentabilidadGraficaVO getRentabilidad(Integer idCine, Date fechaActual, int dias) {
		return dashboardBoletoBO.getRentabilidad(idCine, fechaActual, dias);
	}

	
	public List<RentableVO> getRentables(Integer idCine, Date fechaActual, int dias, boolean desc, int limit) {
		return dashboardBoletoBO.getRentables(idCine, fechaActual, dias, desc, limit);
	}

	public List<RentableVO> getVendidos(Integer idCine, Date fechaActual, int dias, boolean desc, int limit) {
		return dashboardBoletoBO.getVendidos(idCine,fechaActual, dias, desc, limit);
	}

}
