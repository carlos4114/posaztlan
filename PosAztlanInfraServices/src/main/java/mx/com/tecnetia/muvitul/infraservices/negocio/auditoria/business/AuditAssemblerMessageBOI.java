package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;

public interface AuditAssemblerMessageBOI
{

    public abstract AuditoriaObjeto convertMessageVO(AuditoriaMetodoMessageVO auditoriaMetodoMessageVO);
}
