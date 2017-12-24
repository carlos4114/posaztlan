package mx.com.tecnetia.muvitul.servicios.reportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tecnetia.muvitul.negocio.reportes.business.ReportesTaquillaBO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;

@Service
public class ReporteVentasTaquillaController {
	@Autowired
	private ReportesTaquillaBO reportesTaquillaBO;

	public ArchivoExcelVO crearReporteXls(Integer idCine,Integer idUsuario,String fechaInicio,String fechaFin,String idArticulo) throws Exception {
		return reportesTaquillaBO.generarKardex(  idCine,  idUsuario,   fechaInicio,  fechaFin,  idArticulo);
	}
	public ArchivoExcelVO generarReporteVentas(Integer idCine, Integer idUsuario,String fechaInicio,String fechaFin) throws Exception {
		return reportesTaquillaBO.generarReporteVentas(   idCine,   idUsuario,  fechaInicio,  fechaFin);
	}

}
