package mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionVO extends HashMap<String,Object> implements Serializable
{	
	public final static String USUARIO_FIRMADO_SESSION = "usuarioFirmadoSession";
	
    public SessionVO()
    {
    }

    public Object getAttribute(String key)
    {
        return get(key);
    }

    public Object setAttribute(String key, Object value)
    {
        return put(key, value);
    }

    public Object removeAttribute(String key)
    {
        return remove(key);
    }

    private static final long serialVersionUID = 0xd93ebaa26e15a82cL;
}
