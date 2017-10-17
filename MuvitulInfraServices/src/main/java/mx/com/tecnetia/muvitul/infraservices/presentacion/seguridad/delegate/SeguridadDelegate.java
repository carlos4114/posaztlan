package mx.com.tecnetia.muvitul.infraservices.presentacion.seguridad.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.jsonwebtoken.Claims;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioFirmadoVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.servicios.CustomHttpServletRequestWrapper;

@Component
@Configuration
@PropertySource("classpath:config/${ENV_VAR}/global.properties")
public class SeguridadDelegate {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Environment env;

	@SuppressWarnings("unchecked")
	public Boolean accesoValidoUsuario(CustomHttpServletRequestWrapper request) {
		String urlServicesSeguridad = env.getProperty("url.services.seguridad");

		HttpRequestVO requestVO = new HttpRequestVO();

		Claims claims = (Claims) request.getAttribute(ClaimsEnum.CLAIMS_ID);
		requestVO.setRoles((List<Integer>) claims.get(ClaimsEnum.ROLES));
		requestVO.setParameterMap(request.getParameterMap());
		requestVO.setPathInfo(request.getServletPath() + request.getPathInfo());
		requestVO.setBody(request.getBody());
		requestVO.setExpiration(claims.getExpiration());

		Boolean accesoValido = this.restTemplate.postForObject(urlServicesSeguridad + "/rest/seguridad/autorizar",
				requestVO, Boolean.class);

		return accesoValido;
	}

	@SuppressWarnings("unchecked")
	public UsuarioFirmadoVO getUsuarioFirmado(String email) {
		String urlServicesSeguridad = env.getProperty("url.services.seguridad");
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setCorreo(email); 
	 
		return this.restTemplate.postForObject(urlServicesSeguridad + "/rest/seguridad/firmado",usuarioVO, UsuarioFirmadoVO.class );
	}

}
