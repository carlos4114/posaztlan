package mx.com.aztlan.pos.infraservices.negocio.auditoria.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetodoCacheVO
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer idMetodo;
    private String nombre;
    private Set<AtributoCacheVO> atributos;

    public MetodoCacheVO()
    {
        atributos = new HashSet<AtributoCacheVO>(0);
    }

    public MetodoCacheVO(Integer idMetodo, String nombre, Set<AtributoCacheVO> atributos)
    {
        this.idMetodo = idMetodo;
        this.nombre = nombre;
        this.atributos = atributos;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Set<AtributoCacheVO> getAtributos()
    {
        return atributos;
    }

    public void setAtributos(Set<AtributoCacheVO> atributos)
    {
        this.atributos = atributos;
    }

    public Integer getIdMetodo()
    {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo)
    {
        this.idMetodo = idMetodo;
    }

    public void addArgumento(AtributoCacheVO argumento)
    {
        atributos.add(argumento);
    }

}
