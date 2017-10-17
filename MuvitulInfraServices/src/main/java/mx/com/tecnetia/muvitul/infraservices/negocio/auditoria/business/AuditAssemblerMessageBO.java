package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;


import java.util.*;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigAtributoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigExpresionVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigMetodoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaAtributoObjeto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import ognl.Ognl;
import ognl.OgnlException;

public class AuditAssemblerMessageBO extends GlobalService implements AuditAssemblerMessageBOI 
{
    private AuditoriaConfigBOI methodConfiguration;
    private static final Integer ID_EVENTO_METODO = Integer.valueOf(1);

    public AuditoriaObjeto convertMessageVO(AuditoriaMetodoMessageVO auditoriaMetodoMessageVO)
    {
        AuditoriaObjeto auditoriaObjeto = new AuditoriaObjeto();
        Integer idMetodo = auditoriaMetodoMessageVO.getIdClase();
        AuditoriaConfigMetodoVO metodoVO = (AuditoriaConfigMetodoVO)this.methodConfiguration.obtenerMetodosAuditables().get(idMetodo);
        if(metodoVO != null)
        {
            if(log.isDebugEnabled())
            	log.debug((new StringBuilder()).append("Processing message for method [").append(idMetodo).append("]").toString());
            Set<AuditoriaAtributoObjeto> auditoriaAtributos = this.processArguments(auditoriaMetodoMessageVO.getAtributos(), metodoVO.getAtributos(),FechasUtilsBO.getCurrentDate());
            auditoriaObjeto.setIdUsuario(auditoriaMetodoMessageVO.getIdUsuario());
            auditoriaObjeto.setIdEvento(ID_EVENTO_METODO);
            auditoriaObjeto.setIdMetodo(auditoriaMetodoMessageVO.getIdClase());
            auditoriaObjeto.setFecha(FechasUtilsBO.getCurrentDate());
            auditoriaObjeto.setAuditoriaAtributoObjeto(auditoriaAtributos);
            auditoriaObjeto.associateMulAuditoriaObjetoAtributos(auditoriaAtributos);
            
            return auditoriaObjeto;
        } else
        {
            return null;
        }
    }

    private Set<AuditoriaAtributoObjeto> processArguments(Object args[], Set<AuditoriaConfigAtributoVO> configArguments, Date fechaObjeto)
    {
        Set<AuditoriaAtributoObjeto> auditAtributos;

        auditAtributos = new HashSet<AuditoriaAtributoObjeto>();
            if(configArguments == null)
            	 return auditAtributos;
            Iterator<AuditoriaConfigAtributoVO> iter = configArguments.iterator();
            do
            {
                AuditoriaConfigAtributoVO configArg;
                do
                {
                    if(!iter.hasNext())
                    	return auditAtributos;
                    configArg = iter.next();
                } while(configArg.getExpresiones() == null);
                Iterator<AuditoriaConfigExpresionVO> iter2 = configArg.getExpresiones().iterator();
                do
                {
                    if(!iter2.hasNext())
                    	return auditAtributos;
                    AuditoriaConfigExpresionVO configExpr = (AuditoriaConfigExpresionVO)iter2.next();
                    Object arg = args[configArg.getIndice().byteValue() + 1];
                    Object exprValue;
                    try
                    {
                        Object expression = Ognl.parseExpression(configExpr.getExpresion());
                        exprValue = Ognl.getValue(expression, arg);
                        
                        //logger.debug("EXPRESION.......: "+arg);
                    }
                    catch(OgnlException e)
                    {
                        log.error((new StringBuilder()).append("Error al evaluar la expresion ").append(configExpr.getExpresion()).append(" con el atributo ").append(arg).toString(), e);
                        continue;
                    }
                    AuditoriaAtributoObjeto auditoriaAtributo = new AuditoriaAtributoObjeto();
                    auditoriaAtributo.setIdExpresion(configExpr.getIdExpresion());
                    auditoriaAtributo.setAuditoriaObjeto(null);
                    auditoriaAtributo.setFecha(fechaObjeto);
                    auditoriaAtributo.setValorNuevo(String.valueOf(exprValue));
                    auditAtributos.add(auditoriaAtributo);
                } while(true);
            } while(true);
       
    }

	public void setMethodConfiguration(AuditoriaConfigBOI methodConfiguration) {
		this.methodConfiguration = methodConfiguration;
	}

    
}
