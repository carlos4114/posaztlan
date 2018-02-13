package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;


public interface AuditMessageProcessorBOI
{

    public abstract void processMessage(AuditoriaMetodoMessageVO auditmethodinfo);
}
