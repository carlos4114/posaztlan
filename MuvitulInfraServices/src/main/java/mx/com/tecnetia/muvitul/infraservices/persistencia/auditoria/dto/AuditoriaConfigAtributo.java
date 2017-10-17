package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="AUDITORIA_CONFIG_ATRIBUTO")
public class AuditoriaConfigAtributo implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer idAtributo;
    private AuditoriaConfigMetodo auditoriaConfigMetodo;
    private Integer indice;
    private String clase;
    private Date fechaModificacion;
    private Set<AuditoriaConfigExpresion> auditoriaConfigExpresions;

    public AuditoriaConfigAtributo()
    {
    	this.auditoriaConfigExpresions = new HashSet<AuditoriaConfigExpresion>(0);
    }

    public AuditoriaConfigAtributo(Integer idAtributo, AuditoriaConfigMetodo auditoriaConfigMetodo)
    {
    	this.auditoriaConfigExpresions = new HashSet<AuditoriaConfigExpresion>(0);
        this.idAtributo = idAtributo;
        this.auditoriaConfigMetodo = auditoriaConfigMetodo;
    }

    @Id
	@Column(name = "ID_ATRIBUTO")	
	public Integer getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
	}

	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="ID_METODO")
	public AuditoriaConfigMetodo getAuditoriaConfigMetodo() {
		return auditoriaConfigMetodo;
	}

	public void setAuditoriaConfigMetodo(AuditoriaConfigMetodo auditoriaConfigMetodo) {
		this.auditoriaConfigMetodo = auditoriaConfigMetodo;
	}

	@Column(name = "INDICE", nullable = false)	
	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	@Column(name = "CLASE", nullable = false, length=200)	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	@Column(name = "FECHA_MODIFICACION", nullable = false)	
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToMany(mappedBy="auditoriaConfigAtributo", fetch=FetchType.EAGER)
	public Set<AuditoriaConfigExpresion> getAuditoriaConfigExpresions() {
		return auditoriaConfigExpresions;
	}

	public void setAuditoriaConfigExpresions(
			Set<AuditoriaConfigExpresion> auditoriaConfigExpresions) {
		this.auditoriaConfigExpresions = auditoriaConfigExpresions;
	}

    
}
