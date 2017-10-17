package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaMetodosConfigVO
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Map<String,List<MetodoCacheVO>> metodosConfig;
	public Map<String, List<MetodoCacheVO>> getMetodosConfig() {
		return metodosConfig;
	}
	public void setMetodosConfig(Map<String, List<MetodoCacheVO>> metodosConfig) {
		this.metodosConfig = metodosConfig;
	}
    
   

}
