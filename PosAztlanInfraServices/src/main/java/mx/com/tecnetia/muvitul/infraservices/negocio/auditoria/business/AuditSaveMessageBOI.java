package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;


public interface AuditSaveMessageBOI
{

    public abstract void guardarAuditoria(AuditoriaObjeto auditoriaObjeto);
}
