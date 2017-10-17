package mx.com.tecnetia.muvitul.infraservices.presentacion.auditoria.delegate;

import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.ListaMetodosConfigVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.MetodoCacheVO;

public class AuditoriaDelegate {
	
	RestTemplate restTemplate;
	String urlServicesAuditoria;
	
	public Map<String,List<MetodoCacheVO>> getMetodosConfig(){
		
		ListaMetodosConfigVO listaMetodosConfig = this.restTemplate.getForObject(this.urlServicesAuditoria+"/rest/auditoria/getMetodosConfig/",ListaMetodosConfigVO.class);

		return listaMetodosConfig.getMetodosConfig();
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setUrlServicesAuditoria(String urlServicesAuditoria) {
		this.urlServicesAuditoria = urlServicesAuditoria;
	}
	
	
}
