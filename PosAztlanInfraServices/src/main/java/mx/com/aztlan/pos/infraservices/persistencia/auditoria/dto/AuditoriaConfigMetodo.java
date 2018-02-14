package mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUDITORIA_CONFIG_METODO")
public class AuditoriaConfigMetodo implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer idMetodo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private Date fechaModificacion;
    private Set<AuditoriaConfigAtributo> auditoriaConfigAtributos;

    public AuditoriaConfigMetodo()
    {
    	auditoriaConfigAtributos = new HashSet<AuditoriaConfigAtributo>(0);
    }

    public AuditoriaConfigMetodo(Integer idMetodo)
    {
    	auditoriaConfigAtributos = new HashSet<AuditoriaConfigAtributo>(0);
        this.idMetodo = idMetodo;
    }

    @Id
	@Column(name = "ID_METODO")	
	public Integer getIdMetodo() {
		return idMetodo;
	}

	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	@Column(name = "NOMBRE", nullable = false, length=200)	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@OneToMany(mappedBy="auditoriaConfigMetodo", fetch=FetchType.EAGER)
	public Set<AuditoriaConfigAtributo> getAuditoriaConfigAtributos() {
		return auditoriaConfigAtributos;
	}

	public void setAuditoriaConfigAtributos(
			Set<AuditoriaConfigAtributo> auditoriaConfigAtributos) {
		this.auditoriaConfigAtributos = auditoriaConfigAtributos;
	}
    
}
