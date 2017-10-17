package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;

public class AuditMessageListenerBO
{

	private static Log logger = LogFactory.getLog(AuditMessageListenerBO.class);

	private AuditMessageProcessorBOI auditMessageProcessorBO;
		
	public void procesarMensajeAuditoria(AuditoriaMetodoMessageVO auditoriaMetodoMessageVO)
    {	if(logger.isDebugEnabled())
			logger.debug("-----  Consumiendo un mensaje para la auditoría ------------ ");
        
        try
        {
        	   
               if(logger.isDebugEnabled())
                  logger.debug((new StringBuilder()).append("Message received:").append(auditoriaMetodoMessageVO).toString());
               this.auditMessageProcessorBO.processMessage(auditoriaMetodoMessageVO);
        }
        catch(Exception e)
        {
            logger.error(e, e);
            logger.debug(e.getMessage());
        }
    }

	public void setAuditMessageProcessorBO(
			AuditMessageProcessorBOI auditMessageProcessorBO) {
		this.auditMessageProcessorBO = auditMessageProcessorBO;
	}

  
}
