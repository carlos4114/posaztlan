package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;

public interface AuditAssemblerMessageBOI
{

    public abstract AuditoriaObjeto convertMessageVO(AuditoriaMetodoMessageVO auditoriaMetodoMessageVO);
}
