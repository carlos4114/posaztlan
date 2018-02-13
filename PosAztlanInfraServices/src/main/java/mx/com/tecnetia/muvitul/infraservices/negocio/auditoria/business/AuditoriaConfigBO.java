package mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.business;

import java.io.Serializable;
import java.util.*;

import net.sf.ehcache.*;

import org.springframework.transaction.annotation.Transactional;

import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigAtributoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigExpresionVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.auditoria.vo.AuditoriaConfigMetodoVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dao.AuditoriaConfigMetodoDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaConfigAtributo;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaConfigExpresion;
import mx.com.tecnetia.muvitul.infraservices.persistencia.auditoria.dto.AuditoriaConfigMetodo;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;


public class AuditoriaConfigBO extends GlobalService implements AuditoriaConfigBOI
{
	    private static final String METODO_MAP_KEY = "metodosConfigKey";
	    private static final String AUDITORIA_METODOS_MAPS = "auditoriaConfigMetodosMap";
	    
	    private AuditoriaConfigMetodoDAOI auditoriaConfigMetodoDAO;
	    private CacheManager cacheManager;

	
    @SuppressWarnings({ "unchecked", "deprecation" })
    @Transactional
	public Map<Integer,AuditoriaConfigMetodoVO> obtenerMetodosAuditables()
    {
        Map<Integer,AuditoriaConfigMetodoVO> metodosAuditables = null;
        Cache cache = cacheManager.getCache(AUDITORIA_METODOS_MAPS);
        if(cache == null)
            log.error("Ha ocurrido un error al obtener el cache de la configuracion para la auditoria de metodos.");
        else
            try
            {
                Element element = cache.get(METODO_MAP_KEY);
                if(element != null)
                	metodosAuditables = (Map<Integer,AuditoriaConfigMetodoVO>)element.getValue();
                else
                	metodosAuditables = null;
            }
            catch(Exception e)
            {
                log.error("Ha ocurrido un error al obtener la configuracion de la auditoria de metodos desde el cache.", e);
            }
        if(metodosAuditables == null)
        {
            List<AuditoriaConfigMetodo> metodosAuditables2 = new ArrayList<AuditoriaConfigMetodo>();
            metodosAuditables = new HashMap<Integer,AuditoriaConfigMetodoVO>();
            try
            {
                metodosAuditables2 = this.auditoriaConfigMetodoDAO.obtenerMetodosActivos();
            }
            catch(Exception e)
            {
                log.error("Ha ocurrido un error al cargar la configuracion para la auditoria de metodos de la BD.", e);
            }
            AuditoriaConfigMetodoVO metodoVO;
label0:
            for(Iterator<AuditoriaConfigMetodo> i$ = metodosAuditables2.iterator(); i$.hasNext(); metodosAuditables.put(metodoVO.getIdMetodo(), metodoVO))
            {
                AuditoriaConfigMetodo metodo = i$.next();
                metodoVO = new AuditoriaConfigMetodoVO();
                metodoVO.setIdMetodo(metodo.getIdMetodo());
                metodoVO.setNombre(metodo.getNombre());
                Iterator<AuditoriaConfigAtributo> i = metodo.getAuditoriaConfigAtributos().iterator();
                do
                {
                    if(!i.hasNext())
                        continue label0;
                    AuditoriaConfigAtributo atributo = i.next();
                    if(atributo.getAuditoriaConfigExpresions().size() > 0)
                    {
                        AuditoriaConfigAtributoVO atributoVO = new AuditoriaConfigAtributoVO();
                        atributoVO.setIdAtributo(atributo.getIdAtributo());
                        atributoVO.setIndice(atributo.getIndice());
                        atributoVO.setClase(atributo.getClase());
                        Iterator<AuditoriaConfigExpresion> i2 = atributo.getAuditoriaConfigExpresions().iterator();
                        do
                        {
                            if(!i2.hasNext())
                                break;
                            AuditoriaConfigExpresion configExpresion = i2.next();
                            if(configExpresion.getActivo().booleanValue())
                            {
                                AuditoriaConfigExpresionVO expresionVO = new AuditoriaConfigExpresionVO();
                                expresionVO.setExpresion(configExpresion.getExpresion());
                                expresionVO.setIdExpresion(configExpresion.getIdExpresion());
                                atributoVO.getExpresiones().add(expresionVO);
                            }
                        } while(true);
                        metodoVO.getAtributos().add(atributoVO);
                    }
                } while(true);
            }

            if(metodosAuditables.size() > 0)
                cache.put(new Element(METODO_MAP_KEY, (Serializable)metodosAuditables));
        }
        return metodosAuditables;
    }


	public void setAuditoriaConfigMetodoDAO(
			AuditoriaConfigMetodoDAOI auditoriaConfigMetodoDAO) {
		this.auditoriaConfigMetodoDAO = auditoriaConfigMetodoDAO;
	}


	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

    
    
 }
