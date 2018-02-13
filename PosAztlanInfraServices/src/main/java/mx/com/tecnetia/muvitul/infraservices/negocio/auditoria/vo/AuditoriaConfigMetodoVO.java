package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AuditoriaConfigMetodoVO
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer idMetodo;
    private String nombre;
    private Set<AuditoriaConfigAtributoVO> atributos;
    
    public AuditoriaConfigMetodoVO()
    {
        this.atributos = new HashSet<AuditoriaConfigAtributoVO>(0);
    }

    public AuditoriaConfigMetodoVO(Integer idMetodo, String nombre, Set<AuditoriaConfigAtributoVO> atributos)
    {
    	this.idMetodo = idMetodo;
        this.nombre = nombre;
        this.atributos = atributos;
    }

	public Integer getIdMetodo() {
		return idMetodo;
	}

	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<AuditoriaConfigAtributoVO> getAtributos() {
		return atributos;
	}

	public void setAtributos(Set<AuditoriaConfigAtributoVO> atributos) {
		this.atributos = atributos;
	}

    
 }
