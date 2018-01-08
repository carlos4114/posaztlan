package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.configuracion.vo.EmpresaVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ArchivoExcelVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.DetalleInventarioProductoVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ProductoVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ProgramacionVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReportesKardexVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.SalaVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.TaquillaVentaVO;
import mx.com.tecnetia.muvitul.negocio.taquilla.vo.CineVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class ReportesTaquillaBO {

	private static final Logger logger = LoggerFactory.getLogger(ReportesTaquillaBO.class);
	@Autowired
	private ServletContext context;
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	private ArchivoExcelVO archivoExcelVO = null;

	public ArchivoExcelVO generarKardex(Integer idCine, Integer idUsuario, Integer idPuntoVenta, String fechaInicio, String fechaFin,String idArticulo) {

		archivoExcelVO = new ArchivoExcelVO("Kardex" + fechaInicio + fechaFin);
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));
		String rutaKardex = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex") + "\\");
		String fechaI = ""; 
		String fechaF = "";
		try {
			  fechaI=convertStringToData(fechaInicio);
			  fechaF=convertStringToData(fechaFin);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	 	 
		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_articulo", new Integer(idArticulo));
		paramKardex.put("id_punto_venta", new Integer(idPuntoVenta));
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
		} catch ( Exception e) {
 			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentas(Integer idCine, Integer idUsuario, String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("Kardex" + fechaInicio + fechaFin);
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));
		String rutaKardex = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex") + "\\");

		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", idCine);
		paramKardex.put("emision", "" + new Date());
		paramKardex.put("periodo", fechaInicio + fechaFin);
		paramKardex.put("fecha_inicio", fechaInicio);
		paramKardex.put("fecha_fin", fechaFin);
		paramKardex.put("SUBREPORT_DIR", rutaKardex + "\\");
 
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaKardexJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentasSemanal(Integer idCine, Integer idUsuario, String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("Kardex" + fechaInicio + fechaFin);
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));
		String rutaKardex = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex") + "\\");

		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", idCine);
		paramKardex.put("emision", "" + new Date());
		paramKardex.put("periodo", fechaInicio + fechaFin);
		paramKardex.put("fecha_inicio", fechaInicio);
		paramKardex.put("fecha_fin", fechaFin);
		paramKardex.put("SUBREPORT_DIR", rutaKardex + "\\");

		//

		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaKardexJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessGlobalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return archivoExcelVO;

	}

	public ArchivoExcelVO generarReporteVentasMensual(Integer idCine, Integer idUsuario, String fechaInicio, String fechaFin) {

		archivoExcelVO = new ArchivoExcelVO("Kardex" + fechaInicio + fechaFin);
		ResourceBundle cfg = ResourceBundle.getBundle("config");
		String rutaKardexJasper = cfg.getString("reporte.cines.inventario.kardex.jasper");
		String rutaReporteXls = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex.xls"));
		String rutaKardex = context.getRealPath(cfg.getString("reporte.cines.inventario.kardex") + "\\");

		HashMap<String, Object> paramKardex = new HashMap<String, Object>();
		paramKardex.put("id_cine", idCine);
		paramKardex.put("emision", "" + new Date());
		paramKardex.put("periodo", fechaInicio + fechaFin);
		paramKardex.put("fecha_inicio", fechaInicio);
		paramKardex.put("fecha_fin", fechaFin);
		paramKardex.put("SUBREPORT_DIR", rutaKardex + "\\");

		//

		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();
		reporteJasperVO.setRutaReporte(rutaKardexJasper);
		reporteJasperVO.setRutaPdf(rutaReporteXls);
		reporteJasperVO.setParametros(paramKardex);
		try {
			archivoExcelVO.setArchivo(reporteJasperBO.getReporteXls(reporteJasperVO));
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessGlobalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return archivoExcelVO;

	}
	
	public  String convertStringToData(String stringData)
	        throws ParseException {

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//yyyy-MM-dd'T'HH:mm:ss
	    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
	    Date data = sdf.parse(stringData);
	    String formattedTime = output.format(data);
	    return formattedTime;
	}
}
