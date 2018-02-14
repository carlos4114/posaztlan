package mx.com.aztlan.pos.infraservices.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.com.aztlan.pos.infraservices.negocio.seguridad.vo.SessionVO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Scope("prototype")
public class GlobalFrontController
{
	protected final Log log = LogFactory.getLog(getClass().getName());
	@Autowired
	private SessionVO sessionVO;
	
    public SessionVO getSessionVO()
    {	return this.sessionVO;
    }
}
