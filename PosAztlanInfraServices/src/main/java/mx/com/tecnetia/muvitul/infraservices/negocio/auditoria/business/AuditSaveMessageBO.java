package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao.AuditoriaAtributoObjetoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao.AuditoriaObjetoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaAtributoObjeto;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaObjeto;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;

public class AuditSaveMessageBO extends GlobalService implements AuditSaveMessageBOI
{
   	private static final Integer ID_EVENTO_METODO = Integer.valueOf(1);

	private AuditoriaObjetoDAOI auditoriaObjetoDAO;
    private AuditoriaAtributoObjetoDAOI auditoriaAtributoObjetoDAO;
    

    @Transactional
    public void guardarAuditoria(AuditoriaObjeto auditoriaObjeto)
    {
        if(auditoriaObjeto != null && (auditoriaObjeto.getAuditoriaAtributoObjeto().size() > 0 || auditoriaObjeto.getIdEvento() == ID_EVENTO_METODO)){
        	 Set<AuditoriaAtributoObjeto> attributes = auditoriaObjeto.getAuditoriaAtributoObjeto();
        	 auditoriaObjeto.setAuditoriaAtributoObjeto(new HashSet<AuditoriaAtributoObjeto>(0));
             
             this.auditoriaObjetoDAO.save(auditoriaObjeto);
             
             AuditoriaAtributoObjeto auditoriaAtributoObjeto;
             for(Iterator<AuditoriaAtributoObjeto> iter = attributes.iterator(); iter.hasNext();)
             {
            	 auditoriaAtributoObjeto = iter.next();
            	 auditoriaAtributoObjeto.getAuditoriaObjeto().setIdBitacora(auditoriaObjeto.getIdBitacora());
                 this.auditoriaAtributoObjetoDAO.save(auditoriaAtributoObjeto);
             }
        	
        }
    }


	public void setAuditoriaObjetoDAO(AuditoriaObjetoDAOI auditoriaObjetoDAO) {
		this.auditoriaObjetoDAO = auditoriaObjetoDAO;
	}


	public void setAuditoriaAtributoObjetoDAO(
			AuditoriaAtributoObjetoDAOI auditoriaAtributoObjetoDAO) {
		this.auditoriaAtributoObjetoDAO = auditoriaAtributoObjetoDAO;
	}

    
}
