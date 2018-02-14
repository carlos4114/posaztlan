package mx.com.aztlan.pos.infraservices.negocio.auditoria.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AtributoCacheVO
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer idAtributo;
    private String clase;
    private Integer indice;

    public AtributoCacheVO()
    {
    }

    public AtributoCacheVO(Integer idAtributo, String clase, Integer indice)
    {
        this.idAtributo = idAtributo;
        this.clase = clase;
        this.indice = indice;
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

    
}
