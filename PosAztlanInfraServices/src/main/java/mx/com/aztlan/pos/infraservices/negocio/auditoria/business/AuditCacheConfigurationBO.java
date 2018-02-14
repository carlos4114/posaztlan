package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import java.io.Serializable;

import java.util.*;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.AtributoCacheVO;
import mx.com.aztlan.pos.infraservices.negocio.auditoria.vo.MetodoCacheVO;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dao.AuditoriaConfigMetodoDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaConfigAtributo;
import mx.com.aztlan.pos.infraservices.persistencia.auditoria.dto.AuditoriaConfigMetodo;
import mx.com.aztlan.pos.infraservices.presentacion.auditoria.delegate.AuditoriaDelegate;
import mx.com.aztlan.pos.infraservices.servicios.GlobalService;


public class AuditCacheConfigurationBO extends GlobalService implements AuditCacheConfigurationBOI{

	 private String METODO_MAP_KEY;
	 private String AUDITORIA_METODOS_MAPS;
	 private AuditoriaConfigMetodoDAOI auditoriaConfigMetodoDAO;
	 private CacheManager cacheManager;
	 private AuditoriaDelegate auditoriaClientController;

	public AuditCacheConfigurationBO()
    {
        AUDITORIA_METODOS_MAPS = "auditoriaMetodosMap";
        METODO_MAP_KEY = "metodoKey";
    }

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Map<String,List<MetodoCacheVO>> getActiveMethodsConfig() throws Exception
    {   Map<String,List<MetodoCacheVO>> methodsMap = null;
        if(cacheManager != null)
        {
            Cache cache = cacheManager.getCache(AUDITORIA_METODOS_MAPS);
            
            boolean cached = false;
            if(cache == null)
            	log.error("Ha ocurrido un error al obtener el cache manager de la configuracion de auditoria para los metodos.");
            else
                try
                {
                    
                    Element element = cache.get(METODO_MAP_KEY);
                    if(element != null)
                    {
                    	methodsMap = (Map<String,List<MetodoCacheVO>>)element.getValue();
                        cached = true;
                    } else
                    {
                        methodsMap = null;
                    }

                }
                catch(Exception e)
                {
                    log.error("Ha ocurrido un error al obtener la configuracion desde el cache para la auditoria de los metodos.", e);
                }
            if(methodsMap == null){
                //methodsMap = this.loadActiveMethodsConfigFromDB();
            	methodsMap = this.auditoriaClientController.getMetodosConfig();
            }
            if(!cached && cache != null && methodsMap.size() > 0)
                cache.put(new Element(METODO_MAP_KEY, (Serializable)methodsMap));
        }
        
        return methodsMap;
    }

	@Transactional(readOnly=true)
    public Map<String,List<MetodoCacheVO>> loadActiveMethodsConfigFromDB() throws Exception
    {   if(log.isDebugEnabled())
    		log.debug("Load Active Methods from DB");

        Map<String,List<MetodoCacheVO>> methodsConfig = new HashMap<String,List<MetodoCacheVO>>();
        List<MetodoCacheVO> sameMethods = new ArrayList<MetodoCacheVO>();

        List<AuditoriaConfigMetodo> metodos = this.auditoriaConfigMetodoDAO.obtenerMetodosActivos();
        String nombreMetodoTmp = (metodos == null || metodos.size() <= 0 ? "" : ((AuditoriaConfigMetodo)metodos.get(0)).getNombre());
        int metodoNo = 0;

        for(Iterator<AuditoriaConfigMetodo> i = metodos.iterator(); i.hasNext();)
        {
            AuditoriaConfigMetodo configMetodo = i.next();
            MetodoCacheVO metodoCacheVO = new MetodoCacheVO();
            metodoCacheVO.setIdMetodo(configMetodo.getIdMetodo());
            metodoCacheVO.setNombre(configMetodo.getNombre());
            AtributoCacheVO atributoCacheVO;

            for(Iterator<AuditoriaConfigAtributo> i2 = configMetodo.getAuditoriaConfigAtributos().iterator(); i2.hasNext(); metodoCacheVO.addArgumento(atributoCacheVO))
            {

                AuditoriaConfigAtributo configAtributo = i2.next();
                atributoCacheVO = new AtributoCacheVO();
                atributoCacheVO.setIdAtributo(configAtributo.getIdAtributo());
                atributoCacheVO.setClase(configAtributo.getClase());
                atributoCacheVO.setIndice(configAtributo.getIndice());
            }

            if(!nombreMetodoTmp.equals(configMetodo.getNombre()) || metodoNo + 1 == metodos.size())
            {
                methodsConfig.put(nombreMetodoTmp, sameMethods);
                sameMethods = new ArrayList<MetodoCacheVO>();
                nombreMetodoTmp = configMetodo.getNombre();
                if(metodoNo + 1 == metodos.size())
                {
                    sameMethods.add(metodoCacheVO);
                    methodsConfig.put(nombreMetodoTmp, sameMethods);
                }
            }

            sameMethods.add(metodoCacheVO);
            metodoNo++;
        }

        return methodsConfig;
    }

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void setAuditoriaConfigMetodoDAO(
			AuditoriaConfigMetodoDAOI auditoriaConfigMetodoDAO) {
		this.auditoriaConfigMetodoDAO = auditoriaConfigMetodoDAO;
	}

	public void setAuditoriaClientController(AuditoriaDelegate auditoriaClientController) {
		this.auditoriaClientController = auditoriaClientController;
	}
    
    
}
