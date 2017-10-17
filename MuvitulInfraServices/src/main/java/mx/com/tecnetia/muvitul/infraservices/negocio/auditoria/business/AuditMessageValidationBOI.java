package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;


public interface AuditMessageValidationBOI
{
    
	AuditoriaMetodoMessageVO buildAuditoriaMetodoMessage(Integer idClase, Object atributos[], UsuarioFirmadoVO usuarioVO) throws Exception;
    
	Integer hasToRegisterMessage(String uri, Object parameters[]) throws Exception;
  
}
