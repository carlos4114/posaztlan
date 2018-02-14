package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;


public interface AuditMessageValidationBOI
{
    
	AuditoriaMetodoMessageVO buildAuditoriaMetodoMessage(Integer idClase, Object atributos[], UsuarioFirmadoVO usuarioVO) throws Exception;
    
	Integer hasToRegisterMessage(String uri, Object parameters[]) throws Exception;
  
}
