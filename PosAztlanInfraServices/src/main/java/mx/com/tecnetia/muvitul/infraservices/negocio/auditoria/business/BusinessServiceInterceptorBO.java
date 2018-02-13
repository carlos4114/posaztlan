package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.SessionVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;

public class BusinessServiceInterceptorBO extends GlobalService implements MethodInterceptor
{

    private MessageSenderBO messageSenderBO;
    private transient AuditMessageValidationBOI auditMessageValidationBO;
	private SessionVO sessionVO;
  
    public BusinessServiceInterceptorBO(){
    	
    }
	
    public Object invoke(MethodInvocation methodInvocation)
    throws Throwable
	{	
    	try{
	    	if(log.isDebugEnabled())
		    	log.debug("---- Aplicando interceptor para el metodo de negocio: "+methodInvocation.getMethod().getName());
		    
		    String methodName = methodInvocation.getMethod().getName();
		    String className = methodInvocation.getThis().getClass().getName();
		    String screenName = (new StringBuilder(className)).append(".").append(methodName).toString();
		    UsuarioFirmadoVO usuarioVO = (UsuarioFirmadoVO) this.sessionVO.getAttribute(SessionVO.USUARIO_FIRMADO_SESSION);

		    Integer idClase = this.auditMessageValidationBO.hasToRegisterMessage(screenName, methodInvocation.getArguments());
	    	
		    if(!(new Integer(-1)).equals(idClase))
		    {       if(log.isDebugEnabled())    
		    			log.debug("---- Se enviara un mensaje a la cola para auditar el metodo -----");
		        	AuditoriaMetodoMessageVO auditoriaMetodoMessageVO = this.auditMessageValidationBO.buildAuditoriaMetodoMessage(idClase, methodInvocation.getArguments(),usuarioVO);
		        	
		    		this.messageSenderBO.sendMessage((Serializable)auditoriaMetodoMessageVO);		         
		    }
    	

		}catch(Exception e){
    		log.error("SURGIO UN ERROR EN EL INTERCEPTOR DE LOS SERVICIOS DE NEGOCIO: .... "+e);
    	}
        return methodInvocation.proceed();
     }
    
	public void setAuditMessageValidationBO(
			AuditMessageValidationBOI auditMessageValidationBO) {
		this.auditMessageValidationBO = auditMessageValidationBO;
	}

	public void setSessionVO(SessionVO sessionVO) {
		this.sessionVO = sessionVO;
	}

	public void setMessageSenderBO(MessageSenderBO messageSenderBO) {
		this.messageSenderBO = messageSenderBO;
	}	
	
	
}
