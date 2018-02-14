package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;


public interface AuditMessageProcessorBOI
{

    public abstract void processMessage(AuditoriaMetodoMessageVO auditmethodinfo);
}
