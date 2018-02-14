package mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(AuditoriaAtributoObjetoId.class)
@Table (name="AUDITORIA_ATRIBUTO_OBJETO")
public class AuditoriaAtributoObjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    private AuditoriaObjeto auditoriaObjeto;
    private Integer idExpresion;
    private String valorNuevo;
    private Date fecha;

    public AuditoriaAtributoObjeto()
    {
    }

    public AuditoriaAtributoObjeto(AuditoriaObjeto auditoriaObjeto,Integer idExpresion, String valorNuevo)
    {
        this.auditoriaObjeto = auditoriaObjeto;
    	this.idExpresion = idExpresion;
        this.valorNuevo = valorNuevo;
    }

    public AuditoriaAtributoObjeto(AuditoriaObjeto auditoriaObjeto,Integer idExpresion, String valorNuevo, Date fecha)
    {
    	this.auditoriaObjeto = auditoriaObjeto;
    	this.idExpresion = idExpresion;
        this.valorNuevo = valorNuevo;
        this.fecha = fecha;
    }

    @Column(name = "VALOR_NUEVO", nullable = false, length=100)	
	public String getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
	}

	@Column(name = "FECHA", nullable = false)	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Id
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="ID_BITACORA")
	public AuditoriaObjeto getAuditoriaObjeto() {
		return auditoriaObjeto;
	}

	public void setAuditoriaObjeto(AuditoriaObjeto auditoriaObjeto) {
		this.auditoriaObjeto = auditoriaObjeto;
	}

	@Id
	@Column(name = "ID_EXPRESION")	
	public Integer getIdExpresion() {
		return idExpresion;
	}

	public void setIdExpresion(Integer idExpresion) {
		this.idExpresion = idExpresion;
	}
    
    
}
