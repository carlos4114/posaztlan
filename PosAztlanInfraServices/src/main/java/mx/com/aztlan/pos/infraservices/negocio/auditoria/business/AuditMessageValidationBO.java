package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;



import java.io.Serializable;
import java.util.*;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AtributoCacheVO;
import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.MetodoCacheVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.aztlan.pos.infraservices.servicios.GlobalService;

public class AuditMessageValidationBO extends GlobalService implements AuditMessageValidationBOI
{

    private AuditCacheConfigurationBOI auditCacheConfiguration;
    
    public void setAuditCacheConfiguration(
			AuditCacheConfigurationBOI auditCacheConfiguration) {
		this.auditCacheConfiguration = auditCacheConfiguration;
	}

    public Integer hasToRegisterMessage(String uri, Object parameters[]) throws Exception
    {   
    	if(log.isDebugEnabled())
    		log.debug("HasToRegisterMessage? --- "+uri);
    	List<MetodoCacheVO> metodos = (List<MetodoCacheVO>) this.auditCacheConfiguration.getActiveMethodsConfig().get(uri);

        if(metodos != null)
        {
        	for(Iterator<MetodoCacheVO> iterator = metodos.iterator(); iterator.hasNext();)
            {
        		MetodoCacheVO metodoCacheVO = iterator.next();
            	
                int parametersSize = parameters != null ? parameters.length != 1 ? parameters.length : parameters[0] != null ? parameters[0].equals("{}") ? 0 : parameters.length : 0 : 0;
                if(metodoCacheVO.getAtributos().size() == parametersSize)
                {        		
                    boolean isMethod = true;
                    for(Iterator<AtributoCacheVO> iterator1 = metodoCacheVO.getAtributos().iterator(); iterator1.hasNext();)
                    {    		
                        AtributoCacheVO argumento = iterator1.next();

                        if(!argumento.getClase().equals(parameters[argumento.getIndice()].getClass().getName()))
                        {       		
                            isMethod = false;
                            break;
                        }
                    }
	
                    if(isMethod)
                        return metodoCacheVO.getIdMetodo();
                }
            }

        }

        return new Integer("-1");
    }

    public AuditoriaMetodoMessageVO buildAuditoriaMetodoMessage(Integer idClase, Object atributos[], UsuarioFirmadoVO usuarioVO) throws Exception
    {
        AuditoriaMetodoMessageVO auditoriaMetodoMessageVO = new AuditoriaMetodoMessageVO();
        auditoriaMetodoMessageVO.setIdClase(idClase);
        int atributosSize = atributos != null ? atributos.length != 1 ? atributos.length : atributos[0] != null ? atributos[0].equals("{}") ? 0 : atributos.length : 0 : 0;
        Serializable args[] = new Serializable[atributos.length + 1];
        args[0] = null;
        int i = 1;
        if(atributosSize > 0)
        {
            Object aobj[];
            int k = (aobj = atributos).length;
            for(int j = 0; j < k; j++)
            {
                Object atributo = aobj[j];
                args[i++] = (Serializable)atributo;
            }

        }
        auditoriaMetodoMessageVO.setAtributos(args);
        auditoriaMetodoMessageVO.setIdUsuario(usuarioVO.getId());
        
        return auditoriaMetodoMessageVO;
    }

}
