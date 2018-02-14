package mx.com.aztlan.pos.negocio.reportes.business;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import mx.com.aztlan.pos.servicios.util.Fecha;
import net.sf.jasperreports.engine.JRException;

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

	
		fechaI=FechasUtilsBO.convertStringToData(fechaInicio);
		fechaF=FechasUtilsBO.convertStringToData(fechaFin);
		 
	 	 
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
		 
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (HibernateException | BusinessGlobalException | NotFoundException | IOException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentas(Integer idCine, Integer idUsuario,Integer idPuntoVenta, String fecha) {

		archivoExcelVO = new ArchivoExcelVO("VentaDiario");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaDiarioJasper = cfg.getString("reporte.cines.ventas.diarios.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.diarios.xls"));
		String rutaVentaDiario = context.getRealPath(cfg.getString("reporte.cines.ventas.diarios") + "\\");

		
		 
			HashMap<String, Object> paramKardex = new HashMap<String, Object>();
			paramKardex.put("id_cine", idCine);
			paramKardex.put("periodo", "Del "+fecha +" al "+fecha);
			paramKardex.put("fecha_inicio", FechasUtilsBO.convertStringToData(fecha));
			paramKardex.put("fecha_fin", FechasUtilsBO.convertStringToData(fecha));
			paramKardex.put("id_punto_venta",idPuntoVenta);
			paramKardex.put("tipo_reporte","DIARIO");
			paramKardex.put("datasourceTaquilla",this.reporte.getReporteDiario(idCine, FechasUtilsBO.stringToDate(fecha,"/")));
			paramKardex.put("SUBREPORT_DIR", rutaVentaDiario + "\\");
	 
			ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
			reporteJasperVO.setRutaReporte(rutaVentaDiarioJasper);
			reporteJasperVO.setRutaPdf(rutaReporteXls);
			reporteJasperVO.setParametros(paramKardex);
		
			try {
				archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
			} catch (HibernateException | BusinessGlobalException | NotFoundException | IOException | JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentasSemanal(Integer idCine, Integer idUsuario,Integer idPuntoVenta, String fecha) {

		archivoExcelVO = new ArchivoExcelVO("VentaSemanal");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaDiarioJasper = cfg.getString("reporte.cines.ventas.semanales.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.semanales.xls"));
		String rutaVentaDiario = context.getRealPath(cfg.getString("reporte.cines.ventas.semanales") + "\\");

		String fechaInicio= FechasUtilsBO.convertStringToData(fecha);
		String fechaFin= FechasUtilsBO.dateToString(FechasUtilsBO.addDaysToDate(FechasUtilsBO.stringddMMyyToDate(fecha,"dd/MM/yyyy"),6),"yyyy-MM-dd");
		String fechaFinPeriodo= FechasUtilsBO.dateToString(FechasUtilsBO.addDaysToDate(FechasUtilsBO.stringddMMyyToDate(fecha,"dd/MM/yyyy"),6),"dd/MM/yyyy");

		
		
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", idCine);
		paramKardex.put("periodo", "Del "+fecha +" al "+fechaFinPeriodo);
		paramKardex.put("fecha_inicio", fechaInicio);
		paramKardex.put("fecha_fin", fechaFin);
		paramKardex.put("id_punto_venta",idPuntoVenta);
		paramKardex.put("tipo_reporte","SEMANAL");
		paramKardex.put("datasourceTaquilla",this.reporte.getReporteTaquillaSemanal(idCine,FechasUtilsBO.stringYYYYMMDDToDate(fechaInicio,"-"),FechasUtilsBO.stringYYYYMMDDToDate(fechaFin,"-")));
		paramKardex.put("datasourceDulceria",this.reporte.getReporteDulceriaSemanal(idCine,FechasUtilsBO.stringYYYYMMDDToDate(fechaInicio,"-"),FechasUtilsBO.stringYYYYMMDDToDate(fechaFin,"-")));
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

	public ArchivoExcelVO generarReporteVentasMensual(Integer idCine, Integer idUsuario, Integer idPuntoVenta,String fecha) {

		archivoExcelVO = new ArchivoExcelVO("VentaMensual");
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaVentaMensualJasper = cfg.getString("reporte.cines.ventas.mensuales.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.ventas.mensuales.xls"));
		String rutaVentaMensual = context.getRealPath(cfg.getString("reporte.cines.ventas.mensuales") + "\\");
		
		String fechaInicio= FechasUtilsBO.dateToString(FechasUtilsBO.getFechaInicioMes(FechasUtilsBO.stringddMMyyToDate(FechasUtilsBO.convertMMYYtoddMMYY(fecha,"dd/MM/yyyy"),"dd/MM/yyyy")),"yyyy-MM-dd");
		String fechaFin=FechasUtilsBO.dateToString(FechasUtilsBO.getFechaFinMes(FechasUtilsBO.stringddMMyyToDate(FechasUtilsBO.convertMMYYtoddMMYY(fecha,"dd/MM/yyyy"),"dd/MM/yyyy")),"yyyy-MM-dd");
		String fechaInicioPeriodo= FechasUtilsBO.dateToString(FechasUtilsBO.getFechaInicioMes(FechasUtilsBO.stringddMMyyToDate(FechasUtilsBO.convertMMYYtoddMMYY(fecha,"dd/MM/yyyy"),"dd/MM/yyyy")),"dd/MM/yyyy");
		String fechaFinPeriodo=FechasUtilsBO.dateToString(FechasUtilsBO.getFechaFinMes(FechasUtilsBO.stringddMMyyToDate(FechasUtilsBO.convertMMYYtoddMMYY(fecha,"dd/MM/yyyy"),"dd/MM/yyyy")),"dd/MM/yyyy");

		
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", idCine);
		paramKardex.put("periodo", "Del "+fechaInicioPeriodo +" al "+fechaFinPeriodo);
		paramKardex.put("fecha_inicio", fechaInicio);
		paramKardex.put("fecha_fin", fechaFin);
		paramKardex.put("id_punto_venta",idPuntoVenta);
		paramKardex.put("tipo_reporte","MENSUAL");
		paramKardex.put("datasourceTaquilla",this.reporte.getReporteTaquillaMensual(idCine,FechasUtilsBO.stringYYYYMMDDToDate(fechaInicio,"-"),FechasUtilsBO.stringYYYYMMDDToDate(fechaFin,"-")));
		paramKardex.put("datasourceDulceria",this.reporte.getReporteDulceriaMensual(idCine,FechasUtilsBO.stringYYYYMMDDToDate(fechaInicio,"-"),FechasUtilsBO.stringYYYYMMDDToDate(fechaFin,"-")));
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
