package mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUDITORIA_CONFIG_EXPRESION")
public class AuditoriaConfigExpresion implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer idExpresion;
    private AuditoriaConfigAtributo auditoriaConfigAtributo;
    private String expresion;
    private String descripcion;
    private Boolean activo;
    private Date fechaModificacion;

    public AuditoriaConfigExpresion()
    {
    }

    public AuditoriaConfigExpresion(Integer idExpresion, String expresion)
    {
        this.idExpresion = idExpresion;
        this.expresion = expresion;
    }

    public AuditoriaConfigExpresion(Integer idExpresion, AuditoriaConfigAtributo auditoriaConfigAtributo)
    {
        this.idExpresion = idExpresion;
        this.auditoriaConfigAtributo = auditoriaConfigAtributo;
    }

    public AuditoriaConfigExpresion(Integer idExpresion, AuditoriaConfigAtributo auditoriaConfigAtributo, String expresion)
    {
        this.idExpresion = idExpresion;
        this.auditoriaConfigAtributo = auditoriaConfigAtributo;
        this.expresion = expresion;
    }

    @Id
  	@Column(name = "ID_EXPRESION")	
  	public Integer getIdExpresion()
    {
        return idExpresion;
    }

    public void setIdExpresion(Integer idExpresion)
    {
        this.idExpresion = idExpresion;
    }

    @ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="ID_ATRIBUTO")
	public AuditoriaConfigAtributo getAuditoriaConfigAtributo() {
		return auditoriaConfigAtributo;
	}

	public void setAuditoriaConfigAtributo(
			AuditoriaConfigAtributo auditoriaConfigAtributo) {
		this.auditoriaConfigAtributo = auditoriaConfigAtributo;
	}

	@Column(name = "EXPRESION", nullable = false, length=200)	
	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	@Column(name = "DESCRIPCION", nullable = false, length=100)	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ACTIVO", nullable = false)	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Column(name = "FECHA_MODIFICACION", nullable = false)	
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
    
}
