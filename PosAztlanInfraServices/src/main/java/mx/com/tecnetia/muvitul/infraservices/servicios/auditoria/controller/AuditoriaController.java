package mx.com.tecnetia.muvitul.infraservices.servicios.auditoria.controller;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business.AuditCacheConfigurationBOI;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.MetodoCacheVO;

public class AuditoriaController {
  
	private AuditCacheConfigurationBOI auditCacheConfigurationBO;
		
	@Transactional(readOnly=true)
    public Map<String,List<MetodoCacheVO>> getMetodosConfig() throws Exception{
		
		return this.auditCacheConfigurationBO.loadActiveMethodsConfigFromDB();
		
	}

}
