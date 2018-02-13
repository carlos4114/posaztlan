package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class AuditoriaAtributoObjetoId implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private AuditoriaObjeto auditoriaObjeto;
    private Integer idExpresion;

	public AuditoriaObjeto getAuditoriaObjeto() {
		return auditoriaObjeto;
	}

	public void setAuditoriaObjeto(AuditoriaObjeto auditoriaObjeto) {
		this.auditoriaObjeto = auditoriaObjeto;
	}

	public Integer getIdExpresion() {
		return idExpresion;
	}

	public void setIdExpresion(Integer idExpresion) {
		this.idExpresion = idExpresion;
	}
        
}
