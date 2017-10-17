package mx.com.tecnetia.muvitul.infraservices.servicios;

import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business.AuditMessageListenerBO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;

public class MessageListenerController {
   
	private static Log logger = LogFactory.getLog(MessageListenerController.class);

	private AuditMessageListenerBO auditMessageListenerBO;
	
	 @JmsListener(destination = "innovaSportRemoteTopic", containerFactory = "jmsContainerFactory")
	 public void receiveMessage(Message message) {
		 try{
			 	ObjectMessage objMsg = (ObjectMessage)message;
		    	if(objMsg.getObject() instanceof  AuditoriaMetodoMessageVO){		    				    	
		    		this.auditMessageListenerBO.procesarMensajeAuditoria((AuditoriaMetodoMessageVO)objMsg.getObject());
		    	}else{
		    		
		    	}
		 }catch(Exception e){
			 	logger.error(e, e);
	            logger.debug(e.getMessage());
		 }
	 }

	public void setAuditMessageListenerBO(AuditMessageListenerBO auditMessageListenerBO) {
		this.auditMessageListenerBO = auditMessageListenerBO;
	}
	 
	 
}
