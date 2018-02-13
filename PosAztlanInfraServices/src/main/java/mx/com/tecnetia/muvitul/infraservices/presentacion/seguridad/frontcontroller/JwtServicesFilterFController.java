package mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.frontcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.GenericFilterBean;

import edu.emory.mathcs.backport.java.util.Arrays;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.delegate.SeguridadDelegate;
import mx.com.tecnetia.muvitul.infraservices.servicios.CustomHttpServletRequestWrapper;

@Component
@Configuration
@PropertySource({"classpath:config/${ENV_VAR}/global.properties","classpath:config/aplicacion/aplicacion.properties"})
public class JwtServicesFilterFController extends GenericFilterBean {
	final protected Log log = LogFactory.getLog(getClass().getName());
	
	@Autowired
	UsuarioFirmadoBean usuarioFirmadoBean;
	@Autowired
	SeguridadDelegate seguridadDelegate;
	@Autowired
    Environment env;
	public final String tokenHeader = "Authorization";

	
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        
        //Se necesita activar la inyeccion "manualmente" ya que es un filtro y spring no lo reconoce de forma automatica
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        CustomHttpServletRequestWrapper wrapper = new CustomHttpServletRequestWrapper((HttpServletRequest) request);
       
      //VALIDAMOS SI ES METODO "OPTIONS", EN CUYO CASO ES UNA SOLICITUD VERIFICADA Y AUN NO ES LA PETICION DEFINITIVA
        if(request.getMethod()!=null){
          if(!request.getMethod().equals("OPTIONS")){
	        
	        
	        if(log.isDebugEnabled())
	        	log.debug("APLICANDO FILTRO JWT. VALIDANDO Y AUTORIZANDO ACCESO A RECURSO: "+request.getPathInfo());
	        
			//vemos si es una pagina que no debe ser validada o no esta protegida por la seguridad
	        String noAuthPagesTmp = env.getProperty("jwt.no.auth.pages");
	        @SuppressWarnings("unchecked")
			List<String> noAuthPages = noAuthPagesTmp==null?new ArrayList<String>():Arrays.asList(noAuthPagesTmp.split("\\|"));
	        
	        final String authHeader = request.getHeader(tokenHeader);
	        if(!noAuthPages.contains(request.getPathInfo())){

	        	//Vemos si existe el header. Si esta firmado el usuario!!
		        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		            throw new ServletException("No existe el header de Autorizacion. Debe autenticarse primero.");
		        }
		
		        final String token = authHeader.substring(7); // La parte que va despues de "Bearer "
		    	String pwdEncryptor = env.getProperty("jwt.password");;
		    	Claims claims = null;
		    	
		        try {
		        	//Obtenemos el token de los headers
		            claims = Jwts.parser().setSigningKey(pwdEncryptor).parseClaimsJws(token).getBody();	            
		            request.setAttribute(ClaimsEnum.CLAIMS_ID, claims);
		        }
		        catch (final SignatureException e) {
		            throw new ServletException("Error al entrar a la aplicacion. El token NO es valido.");
		        }	        
			        
		        //validamos (por medio del ws de seguridad) si este acceso al recurso es valido
		        Boolean esAccesoValido = this.seguridadDelegate.accesoValidoUsuario(wrapper);
		        if(!esAccesoValido){
		        	HttpServletResponse httpResponse = (HttpServletResponse)res;
		        	String invalidAccessPage = env.getProperty("invalid.access.page");
		        	if(invalidAccessPage!=null && !"".equals(invalidAccessPage))
		        	   httpResponse.sendRedirect(request.getContextPath()+invalidAccessPage);
					throw new ServletException("EL USUARIO "+claims.getSubject()+" NO CUENTA CON PERMISOS PARA ENTRAR A ESTE RECURSO: "+request.getPathInfo());
		        }
		        
		        usuarioFirmadoBean.setUser(seguridadDelegate.getUsuarioFirmado(claims.getSubject()));
	        }else{
            	//Subimos los claims al request
    	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	    	        final String token = authHeader.substring(7); // La parte que va despues de "Bearer "
	    	    	String pwdEncryptor = env.getProperty("jwt.password");;
	    	    	Claims claims = null;
	    	    	
	    	        try {
	    	        	//Obtenemos el token de los headers
	    	            claims = Jwts.parser().setSigningKey(pwdEncryptor).parseClaimsJws(token).getBody();	            
	    	            request.setAttribute(ClaimsEnum.CLAIMS_ID, claims);
	    	        }
	    	        catch (final SignatureException e) {
	    	            throw new ServletException("Error al entrar a la aplicacion. El token NO es valido.");
	    	        }	        
    	        }
            }
          }
        }
        chain.doFilter(wrapper, res);
    }

	public void setSeguridadDelegate(SeguridadDelegate seguridadDelegate) {
		this.seguridadDelegate = seguridadDelegate;
	}

}
