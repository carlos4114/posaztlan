package mx.com.tecnetia.muvitul.negocio.reportes.business;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@Service
@Transactional
public class ReporteJasperBO {
 
	final static Log log = LogFactory.getLog(ReporteJasperBO.class);
	
	@Autowired
    protected SessionFactory sessionFactory;

	@Autowired
	private ServletContext context;
	
	@Transactional(readOnly=true)
	public JasperPrint getReporte(ReporteJasperVO reporteVO) throws BusinessGlobalException, NotFoundException, IOException, HibernateException, JRException{
//			ResourceBundle cfg = ResourceBundle.getBundle("config");
//			String rutaDisneyJasper = cfg.getString("reporte.distribuidora.disney.jasper");
		   // Se corre el reporte y se obtiene		
//		   ClassPathResource cpr = new ClassPathResource(reporteVO.getRutaReporte());
//		   InputStream is = cpr.getInputStream();			
		String rutaArchivo = context.getRealPath(reporteVO.getRutaReporte());

		   return (JasperPrint) JasperFillManager.fillReport(rutaArchivo, reporteVO.getParametros(), 
				   ((SessionImpl)this.sessionFactory.getCurrentSession()).connection());		
	}
		
	@Transactional(readOnly=true)
	public byte[] getReportePdf(ReporteJasperVO reporteVO) throws BusinessGlobalException, NotFoundException, JRException, HibernateException, IOException{
		
		   // Se corre el reporte y se obtiene
		   JasperPrint jprint = this.getReporte(reporteVO);
		
		   // Se regresa el reporte en PDF
		   return JasperExportManager.exportReportToPdf(jprint);
		   		 
	}
	
	@Transactional(readOnly=true)
	public void crearReportePdf(ReporteJasperVO reporteVO) throws BusinessGlobalException, NotFoundException, JRException, HibernateException, IOException{
				
		   // Se corre el reporte y se obtiene
		   JasperPrint jprint = this.getReporte(reporteVO);
		
		   // Se regresa el reporte en PDF
		   JasperExportManager.exportReportToPdfFile(jprint, reporteVO.getRutaPdf());		   		 
	}
	
	@Transactional(readOnly=true)
	public void crearReporteXls(ReporteJasperVO reporteVO) throws BusinessGlobalException, NotFoundException, HibernateException, IOException, JRException{
				
		   // Se corre el reporte y se obtiene
		   JasperPrint jprint = this.getReporte(reporteVO);
		
		   JRXlsExporter exporter = new JRXlsExporter(); 
		   
		   exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
		   exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		   exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		   exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		   exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		   exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reporteVO.getRutaPdf()); 
		   exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE); 
		   exporter.exportReport(); 
	}		

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}