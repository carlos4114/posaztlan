package mx.com.aztlan.pos.servicios.reportes.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.infraservices.servicios.CorreoElectronicoBO;
import mx.com.aztlan.pos.infraservices.servicios.NotFoundException;
import mx.com.aztlan.pos.negocio.reportes.business.ReporteDistribuidoraBO;
import mx.com.aztlan.pos.negocio.reportes.business.ReporteJasperBO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReporteJasperVO;
import mx.com.aztlan.pos.negocio.reportes.vo.ReportesCineXDistribuidoraVO;
import mx.com.aztlan.pos.servicios.util.Fecha;
import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteDistribuidoraController {

	@Autowired
	private ReporteDistribuidoraBO reporteDistribuidoraBO;
	@Autowired
	private CorreoElectronicoBO correroElectronicoBO;
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
	
	public void enviarErrorEmail(ReportesCineXDistribuidoraVO reporte,Map<String, String> model) throws BusinessGlobalException, NotFoundException, HibernateException,IOException, JRException{ 
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
		correroElectronicoBO.setVelAttributes(model);
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
					
					Map<String, String> model = new HashMap<String, String>();            
					
					StringBuilder error = new StringBuilder();
						error.append(e.getClass()).append(" ").
							  append(e.getMessage()).append("<br> Cause: ").
							  append(e.getCause()).append("<br>");
					
						for(StackTraceElement stack: e.getStackTrace()){
							error = error.append(stack.toString().replace(" ","<br>")).append("<br>");
						}
					
					model.put("error",error.toString());
					
					enviarErrorEmail(reporte,model);
					
				}catch (Exception ei) {
					ei.printStackTrace();
				}	
				
				e.printStackTrace();
			} 
			
		}
	}
	
}