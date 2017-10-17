package mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="AUDITORIA_OBJETO")
public class AuditoriaObjeto implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer idBitacora;
    private Integer idMetodo;
	private Date fecha;
    private Integer idUsuario;
    private Integer idEvento;
    private Set<AuditoriaAtributoObjeto> auditoriaAtributoObjeto;
	
    public AuditoriaObjeto()
    {
    	auditoriaAtributoObjeto = new HashSet<AuditoriaAtributoObjeto>(0);
    }

    public AuditoriaObjeto(Date fecha, Integer  idUsuario, Integer  idEvento)
    {
    	auditoriaAtributoObjeto = new HashSet<AuditoriaAtributoObjeto>(0);
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
    }

    public AuditoriaObjeto(Date fecha, Integer  idUsuario, Integer idEvento, Set<AuditoriaAtributoObjeto> auditoriaAtributoObjeto)
    {
        this.auditoriaAtributoObjeto = new HashSet<AuditoriaAtributoObjeto>(0);
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.auditoriaAtributoObjeto = auditoriaAtributoObjeto;
    }

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_BITACORA")	
	public Integer getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	@Column(name = "ID_METODO")	
	public Integer getIdMetodo() {
		return idMetodo;
	}

	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	@Column(name = "FECHA")	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "ID_USUARIO")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "ID_EVENTO")
	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	@OneToMany(mappedBy="auditoriaObjeto", fetch=FetchType.EAGER)
	public Set<AuditoriaAtributoObjeto> getAuditoriaAtributoObjeto() {
		return auditoriaAtributoObjeto;
	}

	public void setAuditoriaAtributoObjeto(
			Set<AuditoriaAtributoObjeto> auditoriaAtributoObjeto) {
		this.auditoriaAtributoObjeto = auditoriaAtributoObjeto;
	}

	public void associateMulAuditoriaObjetoAtributos(Set<AuditoriaAtributoObjeto> auditObjetoAtributos)
    {
        for(Iterator<AuditoriaAtributoObjeto> iter = auditObjetoAtributos.iterator(); iter.hasNext(); ((AuditoriaAtributoObjeto)iter.next()).setAuditoriaObjeto(this));
    }

}
