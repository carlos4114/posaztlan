package mx.com.aztlan.pos.negocio.reportes.business;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@Service
@Transactional
public class ReporteJasperBO {

	final static Log log = LogFactory.getLog(ReporteJasperBO.class);

	@Autowired
	@Qualifier("hibernateSessionFactory")
	protected SessionFactory sessionFactory;

	@Autowired
	private ServletContext context;

	@Transactional(readOnly = true)
	public JasperPrint getReporte(ReporteJasperVO reporteVO)
			throws BusinessGlobalException, NotFoundException, IOException, HibernateException, JRException {

		String rutaArchivo = context.getRealPath(reporteVO.getRutaReporte());

		return (JasperPrint) JasperFillManager.fillReport(rutaArchivo, reporteVO.getParametros(),((SessionImpl)this.sessionFactory.getCurrentSession()).connection());
 
	}

 	public JasperPrint getReporteEmptyDataSource(ReporteJasperVO reporteVO, JRBeanCollectionDataSource jRBeanCollectionDataSource) throws JRException  {
		String rutaArchivo = context.getRealPath(reporteVO.getRutaReporte());
		return (JasperPrint) JasperFillManager.fillReport(rutaArchivo, reporteVO.getParametros(), jRBeanCollectionDataSource);
 
	}

	
	@Transactional(readOnly = true)
	public byte[] getReportePdf(ReporteJasperVO reporteVO)
			throws BusinessGlobalException, NotFoundException, JRException, HibernateException, IOException {

		// Se corre el reporte y se obtiene
		JasperPrint jprint = this.getReporte(reporteVO);

		// Se regresa el reporte en PDF
		return JasperExportManager.exportReportToPdf(jprint);

	}

	@Transactional(readOnly = true)
	public void crearReportePdf(ReporteJasperVO reporteVO)
			throws BusinessGlobalException, NotFoundException, JRException, HibernateException, IOException {

		// Se corre el reporte y se obtiene
		JasperPrint jprint = this.getReporte(reporteVO);

		// Se regresa el reporte en PDF
		JasperExportManager.exportReportToPdfFile(jprint, reporteVO.getRutaPdf());
	}

	@Transactional(readOnly = true)
	public void crearReporteXls(ReporteJasperVO reporteVO)
			throws BusinessGlobalException, NotFoundException, HibernateException, IOException, JRException {

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
	
	@Transactional(readOnly = true)
	public byte[] getReporteXls(ReporteJasperVO reporteVO)
			throws BusinessGlobalException, NotFoundException, HibernateException, IOException, JRException {
		byte[] excel = null;
		// Se corre el reporte y se obtiene
		JasperPrint jprint = this.getReporte(reporteVO);

		JRXlsExporter exporter = new JRXlsExporter();
		ByteArrayOutputStream  xlsReport = new ByteArrayOutputStream();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reporteVO.getRutaPdf());
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);            

		exporter.exportReport();
		
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
//		exporter.exportReport();
//
		excel = xlsReport.toByteArray();
		xlsReport.close();
		
		return excel;
	}
	
	
	@SuppressWarnings("deprecation")
	public byte[] getReporteXls(ReporteJasperVO reporteVO,JRBeanCollectionDataSource jRBeanCollectionDataSource) throws JRException, IOException   {
		byte[] excel = null;
		// Se corre el reporte y se obtiene
		JasperPrint jprint = this.getReporteEmptyDataSource(reporteVO, jRBeanCollectionDataSource);

		JRXlsExporter exporter = new JRXlsExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reporteVO.getRutaPdf());
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);

	    exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, false);
 
//		ByteArrayOutputStream  xlsReport = new ByteArrayOutputStream();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);            
		exporter.exportReport();

//        excel = xlsReport.toByteArray();
//        xlsReport.close();

		return excel;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}