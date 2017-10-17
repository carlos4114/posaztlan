package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import java.util.*;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.MetodoCacheVO;
import net.sf.ehcache.*;

public interface AuditCacheConfigurationBOI{

	Map<String,List<MetodoCacheVO>> getActiveMethodsConfig() throws Exception;
	Map<String,List<MetodoCacheVO>> loadActiveMethodsConfigFromDB() throws Exception;
	
    CacheManager getCacheManager();
    void setCacheManager(CacheManager cacheManager);       
}
