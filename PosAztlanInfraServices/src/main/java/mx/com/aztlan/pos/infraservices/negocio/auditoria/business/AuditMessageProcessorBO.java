package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AuditoriaMetodoMessageVO;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;



public class AuditMessageProcessorBO implements AuditMessageProcessorBOI
{

    private AuditAssemblerMessageBOI auditAssemblerMessageBO;
	private AuditSaveMessageBOI auditSaveMessageBO;
	
    public void processMessage(AuditoriaMetodoMessageVO metodoMessageVO)
    {	AuditoriaObjeto auditoriaObjecto = this.auditAssemblerMessageBO.convertMessageVO(metodoMessageVO);
        
        this.auditSaveMessageBO.guardarAuditoria(auditoriaObjecto);
    }

	public void setAuditAssemblerMessageBO(
			AuditAssemblerMessageBOI auditAssemblerMessageBO) {
		this.auditAssemblerMessageBO = auditAssemblerMessageBO;
	}

	public void setAuditSaveMessageBO(AuditSaveMessageBOI auditSaveMessageBO) {
		this.auditSaveMessageBO = auditSaveMessageBO;
	}

    
}
