package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;

@Service
@Transactional
public class ReportesTaquillaBO {

	private static final Logger logger = LoggerFactory.getLogger(ReportesTaquillaBO.class);
	@Autowired
	private ServletContext context;
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	@Autowired
	private Reporte reporte;
	private ArchivoExcelVO archivoExcelVO = null;

	public ArchivoExcelVO generarKardex(Integer idCine, Integer idUsuario, Integer idPuntoVenta, String fechaInicio, String fechaFin,String idArticulo) {

		archivoExcelVO = new ArchivoExcelVO("Kardex");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));
		String rutaKardex = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex") + "\\");
		String fechaI = ""; 
		String fechaF = "";
		try {
			  fechaI=Fecha.convertStringToData(fechaInicio);
			  fechaF=Fecha.convertStringToData(fechaFin);
		 
	 	 
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_articulo", idArticulo);
		paramKardex.put("id_punto_venta", idPuntoVenta);
		paramKardex.put("id_cine", idCine);
		paramKardex.put("emision", "" + new Date());
		paramKardex.put("periodo", "Del "+fechaInicio +" al "+fechaFin);
		paramKardex.put("fecha_inicio", fechaI);
		paramKardex.put("fecha_fin", fechaF);
		paramKardex.put("SUBREPORT_DIR", rutaKardex + "\\");
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaKardexJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		 
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch ( Exception e) {
 			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentas(Integer idCine, Integer idUsuario,Integer idPuntoVenta, String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("VentaDiario");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaDiarioJasper = cfg.getString("reporte.cines.ventas.diarios.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.diarios.xls"));
		String rutaVentaDiario = context.getRealPath(cfg.getString("reporte.cines.ventas.diarios") + "\\");

		try {
			HashMap<String, Object> paramKardex = new HashMap<String, Object>();
			paramKardex.put("id_cine", idCine);
			paramKardex.put("fecha_inicio", Fecha.convertStringToData(fechaFin));
			paramKardex.put("fecha_fin", Fecha.convertStringToData(fechaFin));
			paramKardex.put("id_punto_venta",idPuntoVenta);
			paramKardex.put("tipo_reporte","DIARIO");
			paramKardex.put("datasourceTaquilla",this.reporte.getReporteDiario(idCine, FechasUtilsBO.stringToDate(fechaInicio,"/")));
			paramKardex.put("SUBREPORT_DIR", rutaVentaDiario + "\\");
	 
			ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
			reporteJasperVO.setRutaReporte(rutaVentaDiarioJasper);
			reporteJasperVO.setRutaPdf(rutaReporteXls);
			reporteJasperVO.setParametros(paramKardex);
		
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentasSemanal(Integer idCine, Integer idUsuario,Integer idPuntoVenta, String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("VentaSemanal");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaDiarioJasper = cfg.getString("reporte.cines.ventas.semanales.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.semanales.xls"));
		String rutaVentaDiario = context.getRealPath(cfg.getString("reporte.cines.ventas.semanales") + "\\");

		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", new Integer("1"));
		paramKardex.put("fecha_inicio", "2017-01-01");
		paramKardex.put("fecha_fin", "2018-02-01");
		paramKardex.put("id_punto_venta",idPuntoVenta);
		paramKardex.put("tipo_reporte","SEMANAL");
		paramKardex.put("datasourceTaquilla",this.reporte.getReporteTaquillaSemanal(idCine,FechasUtilsBO.stringToDate(fechaInicio,"/"),FechasUtilsBO.stringToDate(fechaFin,"/")));
		paramKardex.put("datasourceDulceria",this.reporte.getReporteDulceriaSemanal(idCine,FechasUtilsBO.stringToDate(fechaInicio,"/"),FechasUtilsBO.stringToDate(fechaFin,"/")));
		paramKardex.put("SUBREPORT_DIR", rutaVentaDiario + "\\");
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaVentaDiarioJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentasMensual(Integer idCine, Integer idUsuario, Integer idPuntoVenta,String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("VentaMensual");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaMensualJasper = cfg.getString("reporte.cines.ventas.mensuales.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.mensuales.xls"));
		String rutaVentaMensual = context.getRealPath(cfg.getString("reporte.cines.ventas.mensuales") + "\\");
		
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", new Integer("1"));
		paramKardex.put("fecha_inicio", "2017-01-01");
		paramKardex.put("fecha_fin", "2018-02-01");
		paramKardex.put("id_punto_venta",idPuntoVenta);
		paramKardex.put("tipo_reporte","MENSUAL");
		paramKardex.put("datasourceTaquilla",this.reporte.getReporteTaquillaMensual(idCine,FechasUtilsBO.stringToDate(fechaInicio,"/"),FechasUtilsBO.stringToDate(fechaFin,"/")));
		paramKardex.put("datasourceDulceria",this.reporte.getReporteDulceriaMensual(idCine,FechasUtilsBO.stringToDate(fechaInicio,"/"),FechasUtilsBO.stringToDate(fechaFin,"/")));
		paramKardex.put("SUBREPORT_DIR", rutaVentaMensual + "\\");
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaVentaMensualJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return archivoExcelVO;
	}
	
	 
}
