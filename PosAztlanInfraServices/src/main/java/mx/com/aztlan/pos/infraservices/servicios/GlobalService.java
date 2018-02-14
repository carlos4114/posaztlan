package mx.com.aztlan.pos.infraservices.servicios;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Scope("prototype")
public class GlobalService

{
	final protected Log log = LogFactory.getLog(getClass().getName());
}
