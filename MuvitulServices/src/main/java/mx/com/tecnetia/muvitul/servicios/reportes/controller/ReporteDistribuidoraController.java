package mx.com.tecnetia.muvitul.servicios.reportes.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.velocity.app.VelocityEngine;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.CorreroElectronicoBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.NotFoundException;
import mx.com.tecnetia.muvitul.negocio.reportes.business.ReporteDistribuidoraBO;
import mx.com.tecnetia.muvitul.negocio.reportes.business.ReporteJasperBO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReporteJasperVO;
import mx.com.tecnetia.muvitul.negocio.reportes.vo.ReportesCineXDistribuidoraVO;
import mx.com.tecnetia.muvitul.servicios.util.Fecha;
import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteDistribuidoraController {

	@Autowired
	private ReporteDistribuidoraBO reporteDistribuidoraBO;
	@Autowired
	private CorreroElectronicoBO correroElectronicoBO;
	@Autowired
	private ReporteJasperBO reporteJasperBO;
	@Autowired
	@Qualifier("appMailSender")
    private JavaMailSenderImpl mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
	
	public void enviarReporteEmail(ReportesCineXDistribuidoraVO reporte) throws BusinessGlobalException, NotFoundException, HibernateException,IOException, JRException{ 
		//GENERA REPORTE
		reporteDistribuidoraBO.generarParametros(reporte);
		ReporteJasperVO reporteJasperVO = new ReporteJasperVO();    
		reporteJasperVO.setRutaReporte(reporteDistribuidoraBO.getRutaReporteJasper());
		reporteJasperVO.setRutaPdf(reporteDistribuidoraBO.getRutaReporteXls());
		reporteJasperVO.setParametros(reporteDistribuidoraBO.getParametros());
		reporteJasperBO.crearReporteXls(reporteJasperVO);
		
		//ENVIAR EL REPORTE POR EMAIL		
		correroElectronicoBO.setMailSender(mailSender);
		correroElectronicoBO.setVelocityEngine(velocityEngine);
		correroElectronicoBO.setTemplate(reporteDistribuidoraBO.getRutaPlantillaVm());
		correroElectronicoBO.setTo(reporteDistribuidoraBO.getDestinatarios());
		correroElectronicoBO.setSubject(reporteDistribuidoraBO.getAsunto());
		correroElectronicoBO.setBody(reporteDistribuidoraBO.getCuerpo());
		correroElectronicoBO.setAttachments(reporteDistribuidoraBO.getRutasArchivoAjuntos());
		
		try {
			correroElectronicoBO.sendVelocityMail();			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < reporteDistribuidoraBO.getRutasArchivoAjuntos().length; i++) {                    
            File f = new File(reporteDistribuidoraBO.getRutasArchivoAjuntos()[i]);
            f.delete();
        }
		
	}
	
	public void enviarErrorEmail(ReportesCineXDistribuidoraVO reporte) throws BusinessGlobalException, NotFoundException, HibernateException,IOException, JRException{ 
		//GENERA REPORTE
		reporteDistribuidoraBO.generarParametrosError(reporte);
		
		//ENVIAR EL REPORTE POR EMAIL		
		correroElectronicoBO.setMailSender(mailSender);
		correroElectronicoBO.setVelocityEngine(velocityEngine);
		correroElectronicoBO.setTemplate(reporteDistribuidoraBO.getRutaPlantillaVm());
		correroElectronicoBO.setTo(reporteDistribuidoraBO.getDestinatarios());
		correroElectronicoBO.setSubject(reporteDistribuidoraBO.getAsunto());
		correroElectronicoBO.setBody(reporteDistribuidoraBO.getCuerpo());
		correroElectronicoBO.setAttachments(reporteDistribuidoraBO.getRutasArchivoAjuntos());
		
		try {
			correroElectronicoBO.sendVelocityMail();			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	
	@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
	public void enviarReportes(){
		//System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
		List<ReportesCineXDistribuidoraVO> reportes = reporteDistribuidoraBO.obtenerReportesActivos();
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
		
		for(ReportesCineXDistribuidoraVO reporte : reportes ){
			
			try {
			
				if(fecha.format(reporte.getFechaEnvio()).equals(fecha.format(new Date()))){
					//Envia el reporte
					enviarReporteEmail(reporte);
					//Actualiza las fechas de reporte para el proximo envio
					reporteDistribuidoraBO.actulizarFechas(reporte);					
				}
				
			} catch (Exception e) {
				try {
					enviarErrorEmail(reporte);
				}catch (Exception ei) {
					ei.printStackTrace();
				}
				e.printStackTrace();
			} 
			
		}
	}
	
}