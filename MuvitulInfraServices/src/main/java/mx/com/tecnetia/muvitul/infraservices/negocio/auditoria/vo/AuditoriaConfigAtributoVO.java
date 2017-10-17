package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AuditoriaConfigAtributoVO
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private Integer idAtributo;
    private String clase;
    private Integer indice;
    private Set<AuditoriaConfigExpresionVO> expresiones;

	
    public AuditoriaConfigAtributoVO()
    {
        this.expresiones = new HashSet<AuditoriaConfigExpresionVO>(0);
    }

    public AuditoriaConfigAtributoVO(Integer idAtributo, String clase, Integer indice, Set<AuditoriaConfigExpresionVO> expresiones)
    {
        this.idAtributo = idAtributo;
        this.clase = clase;
        this.indice = indice;
        this.expresiones = expresiones;
    }

	public Integer getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Set<AuditoriaConfigExpresionVO> getExpresiones() {
		return expresiones;
	}

	public void setExpresiones(Set<AuditoriaConfigExpresionVO> expresiones) {
		this.expresiones = expresiones;
	}

	    
}
