package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;


public interface AuditSaveMessageBOI
{

    public abstract void guardarAuditoria(AuditoriaObjeto auditoriaObjeto);
}
